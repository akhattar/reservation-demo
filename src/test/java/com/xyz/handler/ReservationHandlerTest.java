package com.xyz.handler;

import com.xyz.model.Reservation;
import com.xyz.reservation.ReservationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationHandlerTest {

    @InjectMocks
    private ReservationHandler reservationHandler;

    @Mock
    private ReservationManager reservationManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNewReservation_Success() {
        Reservation reservation = new Reservation(1L, "Ankit", "2025-06-15", 4);
        when(reservationManager.createReservation(any(Reservation.class))).thenReturn(true);

        boolean result = reservationHandler.newReservation(reservation);

        assertTrue(result);
        verify(reservationManager, times(1)).createReservation(reservation);
    }

    @Test
    public void testNewReservation_Failure() {
        Reservation reservation = new Reservation(2L, "Ankit", "2025-06-20", 2);
        when(reservationManager.createReservation(any(Reservation.class))).thenReturn(false);

        boolean result = reservationHandler.newReservation(reservation);

        assertFalse(result);
        verify(reservationManager, times(1)).createReservation(reservation);
    }

    @Test
    public void testListReservations_ReturnsReservations() {
        Reservation r1 = new Reservation(1L, "John Doe", "2025-06-15", 4);
        Reservation r2 = new Reservation(2L, "Alice", "2025-06-20", 2);
        List<Reservation> mockReservations = Arrays.asList(r1, r2);

        when(reservationManager.listReservations()).thenReturn(mockReservations);

        List<Reservation> result = reservationHandler.listReservations();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Alice", result.get(1).getName());
        verify(reservationManager, times(1)).listReservations();
    }
}