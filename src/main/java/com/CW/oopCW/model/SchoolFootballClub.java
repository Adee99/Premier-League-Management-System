package com.CW.oopCW.model;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {
    //private variables
    private String theNameOfSchool;

    //default constructor
    public SchoolFootballClub(){
    }

    //parameterized constructor
    public SchoolFootballClub(String theNameOfSportsClub, String theLocationOfSportsClub, int numberOfTheMatchesPlayed, int numberOfReceivedGoals, int numberOfScoredGoals, int numberOfPointsAchievedByClub, int numberOfWinsAchieved, int numberOfDefeatsAchieved, int numberOfDrawsAchieved, int recordedGoalDifference, String matchPlayedDate, String theNameOfSchool) {
        super(theNameOfSportsClub, theLocationOfSportsClub, numberOfTheMatchesPlayed, numberOfReceivedGoals, numberOfScoredGoals, numberOfPointsAchievedByClub, numberOfWinsAchieved, numberOfDefeatsAchieved, numberOfDrawsAchieved, recordedGoalDifference, matchPlayedDate);
        this.theNameOfSchool = theNameOfSchool;
    }

    public String getTheNameOfSchool() {
        return theNameOfSchool;
    }

    public void setTheNameOfSchool(String theNameOfSchool) {
        this.theNameOfSchool = theNameOfSchool;
    }

    //equals method
    @Override
    public boolean equals(Object obj1) {
        if (this == obj1) return true;
        if (!(obj1 instanceof SchoolFootballClub)) return false;
        if (!super.equals(obj1)) return false;
        SchoolFootballClub that = (SchoolFootballClub) obj1;
        return getTheNameOfSchool().equals(that.getTheNameOfSchool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTheNameOfSchool());
    }
}
