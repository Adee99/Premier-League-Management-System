package com.CW.oopCW.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
//initializing private variables
    private int numberOfTheMatchesPlayed;
    private int numberOfReceivedGoals;
    private int numberOfScoredGoals;
    private int numberOfPointsAchievedByClub;
    private int numberOfWinsAchieved;
    private int numberOfDefeatsAchieved;
    private int numberOfDrawsAchieved;
    private int recordedGoalDifference;
    private String matchPlayedDate;

    //default constructor
    public FootballClub(){

    }

    //parameterized constructor
    public FootballClub(String theNameOfSportsClub, String theLocationOfSportsClub, int numberOfTheMatchesPlayed, int numberOfReceivedGoals, int numberOfScoredGoals, int numberOfPointsAchievedByClub, int numberOfWinsAchieved, int numberOfDefeatsAchieved, int numberOfDrawsAchieved, int recordedGoalDifference, String matchPlayedDate) {
        super(theNameOfSportsClub, theLocationOfSportsClub);
        this.numberOfTheMatchesPlayed = numberOfTheMatchesPlayed;
        this.numberOfReceivedGoals = numberOfReceivedGoals;
        this.numberOfScoredGoals = numberOfScoredGoals;
        this.numberOfPointsAchievedByClub = numberOfPointsAchievedByClub;
        this.numberOfWinsAchieved = numberOfWinsAchieved;
        this.numberOfDefeatsAchieved = numberOfDefeatsAchieved;
        this.numberOfDrawsAchieved = numberOfDrawsAchieved;
        this.recordedGoalDifference = recordedGoalDifference;
        this.matchPlayedDate = matchPlayedDate;
    }

    //getters and setters
    public int getNumberOfTheMatchesPlayed() {
        return numberOfTheMatchesPlayed;
    }

    public void setNumberOfTheMatchesPlayed(int numberOfTheMatchesPlayed) {
        this.numberOfTheMatchesPlayed = numberOfTheMatchesPlayed;
    }

    public int getNumberOfReceivedGoals() {
        return numberOfReceivedGoals;
    }

    public void setNumberOfReceivedGoals(int numberOfReceivedGoals) {
        this.numberOfReceivedGoals = numberOfReceivedGoals;
    }

    public int getNumberOfScoredGoals() {
        return numberOfScoredGoals;
    }

    public void setNumberOfScoredGoals(int numberOfScoredGoals) {
        this.numberOfScoredGoals = numberOfScoredGoals;
    }

    public int getNumberOfPointsAchievedByClub() {
        return numberOfPointsAchievedByClub;
    }

    public void setNumberOfPointsAchievedByClub(int numberOfPointsAchievedByClub) {
        this.numberOfPointsAchievedByClub = numberOfPointsAchievedByClub;
    }

    public int getNumberOfWinsAchieved() {
        return numberOfWinsAchieved;
    }

    public void setNumberOfWinsAchieved(int numberOfWinsAchieved) {
        this.numberOfWinsAchieved = numberOfWinsAchieved;
    }

    public int getNumberOfDefeatsAchieved() {
        return numberOfDefeatsAchieved;
    }

    public void setNumberOfDefeatsAchieved(int numberOfDefeatsAchieved) {
        this.numberOfDefeatsAchieved = numberOfDefeatsAchieved;
    }

    public int getNumberOfDrawsAchieved() {
        return numberOfDrawsAchieved;
    }

    public void setNumberOfDrawsAchieved(int numberOfDrawsAchieved) {
        this.numberOfDrawsAchieved = numberOfDrawsAchieved;
    }

    public int getRecordedGoalDifference() {
        return recordedGoalDifference;
    }

    public void setRecordedGoalDifference(int recordedGoalDifference) {
        this.recordedGoalDifference = recordedGoalDifference;
    }

    public String getMatchPlayedDate() {
        return matchPlayedDate;
    }

    public void setMatchPlayedDate(String matchPlayedDate) {
        this.matchPlayedDate = matchPlayedDate;
    }

    @Override
    public int compareTo(FootballClub fbClub) {
        return Comparator.comparing(FootballClub::getNumberOfPointsAchievedByClub).thenComparing(FootballClub::getRecordedGoalDifference)
                .compare(this, fbClub);
    }

    @Override
    public boolean equals(Object object1) {
        if (this == object1) return true;
        if (object1 == null || getClass() != object1.getClass()) return false;
        FootballClub that = (FootballClub) object1;
        return numberOfTheMatchesPlayed == that.numberOfTheMatchesPlayed &&
                numberOfReceivedGoals == that.numberOfReceivedGoals &&
                numberOfScoredGoals == that.numberOfScoredGoals &&
                numberOfPointsAchievedByClub == that.numberOfPointsAchievedByClub &&
                numberOfWinsAchieved == that.numberOfWinsAchieved &&
                numberOfDefeatsAchieved == that.numberOfDefeatsAchieved &&
                numberOfDrawsAchieved == that.numberOfDrawsAchieved &&
                recordedGoalDifference == that.recordedGoalDifference &&
                matchPlayedDate.equals(that.matchPlayedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTheMatchesPlayed, numberOfReceivedGoals, numberOfScoredGoals, numberOfPointsAchievedByClub,
                numberOfWinsAchieved, numberOfDefeatsAchieved, numberOfDrawsAchieved, recordedGoalDifference, matchPlayedDate);
    }

}
