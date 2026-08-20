package sqa.lab.service;

import java.sql.SQLException;
import java.util.List;

public class SeatReservation {

    private SeatDAO dao;

    public SeatReservation(SeatDAO dao) {
        this.dao = dao;
    }

    public boolean checkSeatAvailability(String seatName) throws SQLException {
        List<String> seatsAvailable = dao.fetchAvailableSeats();
        return seatsAvailable.contains(seatName);
    }
}