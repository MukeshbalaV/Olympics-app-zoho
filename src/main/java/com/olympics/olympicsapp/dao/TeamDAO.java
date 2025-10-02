package com.olympics.olympicsapp.dao;

import com.olympics.olympicsapp.model.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamDAO {
    private final Connection connection;

    public TeamDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addTeam(Team team) {
        String query = "INSERT INTO teams (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, team.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllTeams() {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM teams")) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
