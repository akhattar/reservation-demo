package com.xyz.reservation;

import com.xyz.model.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import org.mockito.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


class ReservationManagerTest {
    private ReservationManager reservationManager;

    @BeforeEach
    public void setup() {
         // Mock the repository
        reservationManager = new ReservationManager();
    }

    @Test
    public void testListReservations_WhenEmpty_ShouldReturnDefaultReservation() {
        List<Reservation> result = reservationManager.listReservations();
        assertEquals(1, result.size());
        assertNotNull(result.get(0));
    }

    @Test
    public void testListReservations_WithData_ShouldReturnAllReservations() {
        Reservation r1 = new Reservation(1L, "Ankit K", "2025-06-15", 4);
        Reservation r2 = new Reservation(2L, "Ankit Khattar", "2025-06-20", 2);
        reservationManager.createReservation(r1);
        reservationManager.createReservation(r2);
        List<Reservation> result = reservationManager.listReservations();

        assertEquals(2, result.size());
        assertEquals("Ankit K", result.get(0).name);
        assertEquals("Ankit Khattar", result.get(1).name);
    }

    @Test
    public void testCreateReservation_Success() {
        Reservation reservation = new Reservation(null, "Ankit K", "2025-06-15", 4);
        boolean result = reservationManager.createReservation(reservation);
        assertTrue(result);
        assertNotNull(reservation.getId());
    }

}



