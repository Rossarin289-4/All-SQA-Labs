package sqa.lab.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO{
    public List<String> fetchAvailableSeats() throws SQLException{
        List<String> avaliableSeats = new ArrayList<String>();

        Connection conn = DriverManager.getConnection("DATABASE_URL");
        Statement statement = conn.createStatement();
        ResultSet rs;

        rs = statement.executeQuery(
            "SELECT * FROM ROOMS WHERE AVAILABLE like '1'"
        );
        while (rs.next()){
            avaliableSeats.add(rs.getString("Seat name"));
        }
        return avaliableSeats;
    }
}