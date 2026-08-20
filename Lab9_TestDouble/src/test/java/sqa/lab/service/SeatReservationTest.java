package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SeatReservationTest {

    @Test
    void shouldReturnTrueWhenSeatIsAvailable() throws SQLException {
        SeatDAO mockSeatDAO = Mockito.mock(SeatDAO.class);

        Mockito.when(mockSeatDAO.fetchAvailableSeats())
                .thenReturn(Arrays.asList("A1", "A2", "A3"));

        SeatReservation seatReservation =
                new SeatReservation(mockSeatDAO);

        boolean result =
                seatReservation.checkSeatAvailability("A2");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenSeatIsNotAvailable() throws SQLException {

        SeatDAO mockSeatDAO = Mockito.mock(SeatDAO.class);

        Mockito.when(mockSeatDAO.fetchAvailableSeats())
                .thenReturn(Arrays.asList("A1", "A2", "A3"));

        SeatReservation seatReservation =
                new SeatReservation(mockSeatDAO);

        boolean result =
                seatReservation.checkSeatAvailability("B1");

        assertFalse(result);
    }
}