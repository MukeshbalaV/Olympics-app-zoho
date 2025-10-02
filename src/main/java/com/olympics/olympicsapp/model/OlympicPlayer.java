package com.olympics.olympicsapp.model;

public class OlympicPlayer {
    private String name;
    private int age;
    private String gender;
    private String sport;
    private String team;
    private String event;
    private String medal;

    public OlympicPlayer(String name, int age, String gender, String sport, String team, String event, String medal) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sport = sport;
        this.team = team;
        this.event = event;
        this.medal = medal;
    }

    // getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getSport() { return sport; }
    public String getTeam() { return team; }
    public String getEvent() { return event; }
    public String getMedal() { return medal; }
}
