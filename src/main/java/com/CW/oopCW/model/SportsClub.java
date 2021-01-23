package com.CW.oopCW.model;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    //declaring variables
    private String theNameOfSportsClub;
    private String theLocationOfSportsClub;

    //default constructor
    public SportsClub(){
    }

    //parameterized Constructor
    public SportsClub(String theNameOfSportsClub, String theLocationOfSportsClub) {
        this.theNameOfSportsClub = theNameOfSportsClub;
        this.theLocationOfSportsClub = theLocationOfSportsClub;
    }


    //getters and setters
    public String getTheNameOfSportsClub() {
        return theNameOfSportsClub;
    }

    public void setTheNameOfSportsClub(String theNameOfSportsClub) {
        this.theNameOfSportsClub = theNameOfSportsClub;
    }

    public String getTheLocationOfSportsClub() {
        return theLocationOfSportsClub;
    }

    public void setTheLocationOfSportsClub(String theLocationOfSportsClub) {
        this.theLocationOfSportsClub = theLocationOfSportsClub;
    }


    // hash code and equals methods
    @Override
    public boolean equals(Object object1) {
        if (this == object1) return true;
        if (!(object1 instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) object1;
        return getTheNameOfSportsClub().equals(that.getTheNameOfSportsClub()) &&
                getTheLocationOfSportsClub().equals(that.getTheLocationOfSportsClub());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTheNameOfSportsClub(), getTheLocationOfSportsClub());
    }
}
