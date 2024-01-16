package io.swagger.services;

import io.swagger.exception.NotFoundException;
import io.swagger.model.Guest;
import io.swagger.model.Reservation;
import io.swagger.model.Room;
import io.swagger.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;

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

    public Reservation getReservation(String email, String token) throws NotFoundException {
        Reservation reservation = reservationRepository.findByEmailAndToken(email,token);
        if(reservation != null){
            return reservation;
        }
        else{
            throw new NotFoundException(404,"Reservation not found");
        }
    }

    public void deleteReservation(String email,String token) throws NotFoundException {
        Reservation reservation = getReservation(email,token);
        reservationRepository.delete(reservation);
    }

    public List<Reservation> getRoomReservations(Integer roomId) throws NotFoundException {
        roomService.getRoom(roomId);
        return reservationRepository.findByReservationPK_Id(roomId);
    }

    public void saveRoomReservation(Reservation reservation) throws NotFoundException,HttpClientErrorException {
        Guest guest = guestsService.getGuest(reservation.getReservationPK().getJmbg());
        Room room = roomService.getRoom(reservation.getReservationPK().getId());

        reservation.setRoom(room);
        reservation.setGuest(guest);

        if(reservationRepository.findByReservationPK(reservation.getReservationPK())==null) {
            if(reservation.getReservationPK().getDateFrom().before(reservation.getReservationPK().getDateTo())) {
                reservationRepository.save(reservation);
            }
            else{
                throw new HttpClientErrorException(HttpStatus.CONFLICT,"Reservation dateFrom can't be after dateTo");
            }
        }else{
            throw new HttpClientErrorException(HttpStatus.CONFLICT,"Reservation already exists");
        }
    }

    public List<Reservation> getRoomReservationsOfDate(Integer roomId, Date dateFrom, Date dateTo){
        return reservationRepository.findByReservationPK_IdAndReservationPK_DateFromAndReservationPK_DateTo(roomId,dateFrom,dateTo);
    }

    public void updatePriceOfReservation(String email, String token, Reservation reservation) throws NotFoundException {
        if(getReservation(email,token)!=null) {
            reservationRepository.save(reservation);
        }
        else{
            throw new NotFoundException(404,"Reservation not found");
        }
    }
}


