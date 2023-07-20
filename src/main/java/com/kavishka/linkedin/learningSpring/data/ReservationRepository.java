package com.kavishka.linkedin.learningSpring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    List<Reservation> findReservationsByDate(Date date);
    List<Reservation> findReservationByDate(Date date);
}
