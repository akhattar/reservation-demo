package com.xyz.reservation;

import com.xyz.model.Reservation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ReservationManager {

    @Getter
    public final List<Reservation> reservationRepo = new ArrayList<>();

    public long idCount = 1;

    public boolean createReservation(Reservation reservation){
        log.debug("Create reservation;{}", reservation);

        if (!reservationRepo.isEmpty() && reservationRepo.stream().anyMatch(r -> r.equals(reservation))) {
            return false;
        }

        reservation.setId(idCount++);
       return reservationRepo.add(reservation);
    }


    public List<Reservation> listReservations() {

        if (reservationRepo.isEmpty()) {
            log.debug("No Reservations. Returning empty reservation");
            return Collections.singletonList(new Reservation());
        }

        log.debug("Returning {} reservations", reservationRepo.size());
        return new ArrayList<>(reservationRepo);
    }
}
