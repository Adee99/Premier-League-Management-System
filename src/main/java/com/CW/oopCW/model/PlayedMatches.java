package com.CW.oopCW.model;

import java.io.Serializable;

public class PlayedMatches implements Serializable {
    private String nameOfFirstTeam;
    private String nameOfSecondTeam;
    private int scoreOfTeamOne;
    private int scoreOfTeamTwo;
    private String matchPlayedDate;

    //default constructor
    public PlayedMatches() {
    }

    //parameterized constructor
    public PlayedMatches(String nameOfFirstTeam, String nameOfSecondTeam, int scoreOfTeamOne, int scoreOfTeamTwo, String matchPlayedDate) {
        this.nameOfFirstTeam = nameOfFirstTeam;
        this.nameOfSecondTeam = nameOfSecondTeam;
        this.scoreOfTeamOne = scoreOfTeamOne;
        this.scoreOfTeamTwo = scoreOfTeamTwo;
        this.matchPlayedDate = matchPlayedDate;
    }

    //getters and setters
    public String getNameOfFirstTeam() {
        return nameOfFirstTeam;
    }

    public void setNameOfFirstTeam(String nameOfFirstTeam) {
        this.nameOfFirstTeam = nameOfFirstTeam;
    }

    public String getNameOfSecondTeam() {
        return nameOfSecondTeam;
    }

    public void setNameOfSecondTeam(String nameOfSecondTeam) {
        this.nameOfSecondTeam = nameOfSecondTeam;
    }

    public int getScoreOfTeamOne() {
        return scoreOfTeamOne;
    }

    public void setScoreOfTeamOne(int scoreOfTeamOne) {
        this.scoreOfTeamOne = scoreOfTeamOne;
    }

    public int getScoreOfTeamTwo() {
        return scoreOfTeamTwo;
    }

    public void setScoreOfTeamTwo(int scoreOfTeamTwo) {
        this.scoreOfTeamTwo = scoreOfTeamTwo;
    }

    public String getMatchPlayedDate() {
        return matchPlayedDate;
    }

    public void setMatchPlayedDate(String matchPlayedDate) {
        this.matchPlayedDate = matchPlayedDate;
    }

    @Override
    public String toString() {
        return "PlayedMatches{" +
                "nameOfFirstTeam='" + nameOfFirstTeam + '\'' +
                ", nameOfSecondTeam='" + nameOfSecondTeam + '\'' +
                ", scoreOfTeamOne=" + scoreOfTeamOne +
                ", scoreOfTeamTwo=" + scoreOfTeamTwo +
                ", matchPlayedDate='" + matchPlayedDate + '\'' +
                '}';
    }
}
