package io.swagger.repository;

import io.swagger.model.Reservation;
import io.swagger.model.ReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationPK> {

    Reservation findByEmailAndToken(String email, String token);
    Reservation findByReservationPK(ReservationPK reservationPK);
    List<Reservation> findByReservationPK_Id(Integer Id);
    List<Reservation> findByReservationPK_IdAndReservationPK_DateFromAndReservationPK_DateTo(Integer id, Date dateFrom, Date dateTo);
}
