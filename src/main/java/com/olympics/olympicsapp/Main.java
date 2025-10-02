package com.olympics.olympicsapp;
import java.sql.Connection;
import java.sql.Statement;

import com.olympics.olympicsapp.dao.*;
import com.olympics.olympicsapp.model.*;
import com.olympics.olympicsapp.util.FileParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Clearing existing database data...");
        Connection conn = DBConnection.getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("TRUNCATE TABLE olympic_players");
            stmt.executeUpdate("TRUNCATE TABLE teams");
            stmt.executeUpdate("TRUNCATE TABLE sports");
            System.out.println("Database flushed. IDs reset to 1.");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SportDAO sportDAO = new SportDAO();
        TeamDAO teamDAO = new TeamDAO();
        OlympicPlayerDAO playerDAO = new OlympicPlayerDAO();

        playerDAO.deleteAllPlayers();
        teamDAO.deleteAllTeams();
        sportDAO.deleteAllSports();

        System.out.println("Database cleared successfully.");

        List<Sport> sports = FileParser.parseSports("D:\\OlympicsApp\\src\\main\\resources\\SportsCategories-2020.txt");
        List<Team> teams = FileParser.parseTeams("D:\\OlympicsApp\\src\\main\\resources\\Teams-2020.txt");
        List<OlympicPlayer> players = FileParser.parsePlayers("D:\\OlympicsApp\\src\\main\\resources\\Olympics2020.csv");

        sports.forEach(sportDAO::addSport);
        teams.forEach(teamDAO::addTeam);
        players.forEach(playerDAO::addPlayer);

        System.out.println("All data inserted successfully!");
    }
}
