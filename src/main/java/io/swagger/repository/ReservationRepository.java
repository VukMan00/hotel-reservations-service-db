package io.swagger.repository;

import io.swagger.model.Reservation;
import io.swagger.model.ReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationPK> {

    Reservation findByReservationPK(ReservationPK reservationPK);
    List<Reservation> findByReservationPK_Id(Integer Id);
}
