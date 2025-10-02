package com.olympics.olympicsapp.util;

import com.olympics.olympicsapp.model.Sport;
import com.olympics.olympicsapp.model.Team;
import com.olympics.olympicsapp.model.OlympicPlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static List<Sport> parseSports(String filePath) {
        List<Sport> sports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) sports.add(new Sport(line));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return sports;
    }

    public static List<Team> parseTeams(String filePath) {
        List<Team> teams = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) teams.add(new Team(line));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return teams;
    }

    public static List<OlympicPlayer> parsePlayers(String filePath) {
        List<OlympicPlayer> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", -1);
                if (parts.length < 10) continue;

                String name = parts[1].trim();
                String gender = parts[2].trim();
                int age = Integer.parseInt(parts[3].trim());
                String team = parts[4].trim();
                String event = parts[5].trim();
                String sport = parts[8].trim();
                String medal;
                switch (parts[9].trim()) {
                    case "1": medal = "Gold"; break;
                    case "2": medal = "Silver"; break;
                    case "3": medal = "Bronze"; break;
                    default: medal = "None"; break;
                }

                players.add(new OlympicPlayer(name, age, gender, sport, team, event, medal));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return players;
    }
}
