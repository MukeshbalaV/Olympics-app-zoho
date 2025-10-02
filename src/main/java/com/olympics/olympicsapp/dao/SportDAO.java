package com.olympics.olympicsapp.dao;

import com.olympics.olympicsapp.model.Sport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SportDAO {
    private final Connection connection;

    public SportDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addSport(Sport sport) {
        String query = "INSERT INTO sports (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sport.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllSports() {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM sports")) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
