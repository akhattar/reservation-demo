package com.xyz.handler;

import com.xyz.reservation.ReservationManager;
import com.xyz.model.Reservation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Path("/reservations")
public class ReservationHandler {


    private final ReservationManager reservationManager;

    public ReservationHandler() {
        this.reservationManager = new ReservationManager();
    }

    public ReservationHandler(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create-reservation")
    public boolean newReservation(Reservation reservation) {
        return reservationManager.createReservation(reservation);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list-reservations")
    public List<Reservation> listReservations() {
        return reservationManager.listReservations();
    }
}
