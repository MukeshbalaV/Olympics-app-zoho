package com.olympics.olympicsapp.dao;

import com.olympics.olympicsapp.model.OlympicPlayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OlympicPlayerDAO {
    private final Connection connection;

    public OlympicPlayerDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void addPlayer(OlympicPlayer player) {
        String query = "INSERT INTO olympic_players (name, age, gender, sport, team, event, medal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getAge());
            stmt.setString(3, player.getGender());
            stmt.setString(4, player.getSport());
            stmt.setString(5, player.getTeam());
            stmt.setString(6, player.getEvent());
            stmt.setString(7, player.getMedal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllPlayers() {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM olympic_players")) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
