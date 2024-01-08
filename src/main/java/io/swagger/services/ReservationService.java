package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.Reservation;
import io.swagger.model.ReservationPK;
import io.swagger.model.Room;
import io.swagger.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final GuestsService guestsService;

    private final RoomService roomService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, GuestsService guestsService, RoomService roomService){
        this.reservationRepository = reservationRepository;
        this.guestsService = guestsService;
        this.roomService = roomService;
    }

    public Reservation getReservation(Integer roomId, String guestJMBG) throws NotFoundException {
        roomService.getRoom(roomId);
        guestsService.getGuest(guestJMBG);
        ReservationPK reservationPK = new ReservationPK(roomId,guestJMBG);
        Optional<Reservation> reservation = reservationRepository.findById(reservationPK);
        if(reservation.isPresent()){
            return reservation.get();
        }
        else{
            throw new NotFoundException(404,"Reservation not found");
        }
    }

    public void deleteReservation(Integer roomId, String guestJMBG) throws NotFoundException {
        Reservation reservation = getReservation(roomId,guestJMBG);
        reservationRepository.deleteById(reservation.getReservationPK());
    }

    public List<Reservation> getRoomReservations(Integer roomId) throws NotFoundException {
        roomService.getRoom(roomId);
        List<Reservation> roomReservations = reservationRepository.findByReservationPK_Id(roomId);
        if(!roomReservations.isEmpty()) {
            return roomReservations;
        }else{
            throw new NotFoundException(404,"Reservations not found");
        }
    }

    public void saveRoomReservation(Integer roomId, String guestJMBG, Reservation reservation) throws NotFoundException {
        Guest guest = guestsService.getGuest(guestJMBG);
        Room room = roomService.getRoom(roomId);

        reservation.setRoom(room);
        reservation.setGuest(guest);
        reservation.setReservationPK(new ReservationPK(roomId,guestJMBG));

        reservationRepository.save(reservation);
    }
}

