package com.CW.oopCW.model;

import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {
    // declaring private variables
    private String theNameOfUniversity;

    //default constructor
    public UniversityFootballClub() {
    }

    //parameterized constructor
    public UniversityFootballClub(String theNameOfSportsClub, String theLocationOfSportsClub, int numberOfTheMatchesPlayed, int numberOfReceivedGoals, int numberOfScoredGoals, int numberOfPointsAchievedByClub, int numberOfWinsAchieved, int numberOfDefeatsAchieved, int numberOfDrawsAchieved, int recordedGoalDifference, String matchPlayedDate, String theNameOfUniversity) {
        super(theNameOfSportsClub, theLocationOfSportsClub, numberOfTheMatchesPlayed, numberOfReceivedGoals, numberOfScoredGoals, numberOfPointsAchievedByClub, numberOfWinsAchieved, numberOfDefeatsAchieved, numberOfDrawsAchieved, recordedGoalDifference, matchPlayedDate);
        this.theNameOfUniversity = theNameOfUniversity;
    }

    public String getTheNameOfUniversity() {
        return theNameOfUniversity;
    }

    public void setTheNameOfUniversity(String theNameOfUniversity) {
        this.theNameOfUniversity = theNameOfUniversity;
    }


    @Override
    public boolean equals(Object object1) {
        if (this == object1) return true;
        if (!(object1 instanceof UniversityFootballClub)) return false;
        if (!super.equals(object1)) return false;
        UniversityFootballClub that = (UniversityFootballClub) object1;
        return getTheNameOfUniversity().equals(that.getTheNameOfUniversity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTheNameOfUniversity());
    }
}
