package com.CW.oopCW.service;

import com.CW.oopCW.model.*;

import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class PremierLeagueManager implements LeagueManager {

    public static List<FootballClub> listOfClubs = new ArrayList<>();
    public static List<PlayedMatches> listOfPlayedMatches = new ArrayList<>();
    private static final Random generateRandom = new Random(); //instance of random class

    //adding new football club
    @Override
    public void addNewFootballClub(FootballClub addingNewClubs) {
        boolean check = false;
        for (FootballClub sportingClub : listOfClubs) {
            if (sportingClub.getTheNameOfSportsClub().contains(addingNewClubs.getTheNameOfSportsClub())) {
                check = true;
                break;
            }
        }
        if(!check){
            //initializing arraylist using add method
            listOfClubs.add(addingNewClubs);
            System.out.println(addingNewClubs.getTheNameOfSportsClub()+" Club Successfully Added");
            System.out.println("Number of clubs added: " +listOfClubs.size());
        }else{
            System.out.println("---> Club Already Available in the List. Add a different Club <---");
        }
    }
    //football club details
    public List<FootballClub> getFootBallClubList(){
        return listOfClubs;
    }

    //played match details
    public List<PlayedMatches> playedMatches(){
        return listOfPlayedMatches;
    }

    //display details of existing clubs
    @Override
    public void displayDetailsOfClubs(String nameForClubSearch) {
        boolean check = false;
        for (FootballClub sportingClub : listOfClubs) {
            check = true;
            if (sportingClub.getTheNameOfSportsClub().contains(nameForClubSearch)) {
                System.out.println("||------> Search Result <------||");
                System.out.println(" Name of the Sport Club: " + sportingClub.getTheNameOfSportsClub());
                System.out.println(" Location of the Sport Club: " + sportingClub.getTheLocationOfSportsClub());
                System.out.println(" Number of Matches Played: " + sportingClub.getNumberOfTheMatchesPlayed());
                System.out.println(" Number of Scored Goals: " +  sportingClub.getNumberOfScoredGoals());
                System.out.println(" Number of Received goals: " +  sportingClub.getNumberOfReceivedGoals());
                System.out.println(" Recorded Goal difference: " +  sportingClub.getRecordedGoalDifference());
                System.out.println(" Number of Wins achieved by the Club: " +  sportingClub.getNumberOfWinsAchieved());
                System.out.println(" Number of Defeats achieved by the Club: " + sportingClub.getNumberOfDefeatsAchieved());
                System.out.println(" Number of Draws achieved by the Club: " +  sportingClub.getNumberOfDrawsAchieved());
                System.out.println(" Number of Points achieved by the Club: " +  sportingClub.getNumberOfPointsAchievedByClub());
                break;
            }

        }
        if (!check) {
            System.out.println(" --> Club Not Found! Try Again <--");
        } else if (listOfClubs.size() == 0) {
            System.out.println("-- No Clubs Added -- ");
        }
    }

    //search played matches by date
    @Override
    public List<PlayedMatches> searchMatchByDate(String matchPlayedDates) {
        List<PlayedMatches> listOfPlayedMatches2= new  ArrayList<>();
        for(PlayedMatches playedMatches : listOfPlayedMatches) {
            if (playedMatches.getMatchPlayedDate().equals(matchPlayedDates)) {
                listOfPlayedMatches2.add(playedMatches);
            }
        }
        for(PlayedMatches playedMatches : listOfPlayedMatches2){
            System.out.println(playedMatches);
        }
        return listOfPlayedMatches2;
    }

    //generating random date
    public static int generateRandomInt(int startingYear,int endingYear){
        return startingYear + (int) Math.round(Math.random()*(endingYear - startingYear));
    }

    public static LocalDate generatingRandomDate(int startingYear, int endingYear){
        //accessing random date
        int date = generateRandomInt(1,28);
        //accessing random year
        int year = generateRandomInt(startingYear, endingYear);
        //accessing random month
        int month = generateRandomInt(1,12);
        return LocalDate.of(year,month,date);
    }

    //adding played match
    @Override
    public void addPlayedMatchDetails(String nameOfFirstTeam, String nameOfSecondTeam, int scoreOfTeamOne, int scoreOfTeamTwo, String matchPlayedDate) {
        //initializing variables
        FootballClub sprtingClubHome = null;
        FootballClub sprtingClubGuest = null;

        //assigning boolean value for variables
        boolean identifiedHme = false;
        boolean identifiedGst = false;

        for(FootballClub sprtingClb1: listOfClubs){
            if(sprtingClb1.getTheNameOfSportsClub().equals(nameOfFirstTeam)){
                sprtingClubHome = sprtingClb1;
                identifiedHme = true;
            }
        }

        for(FootballClub sprtingClb2 : listOfClubs){
            if(sprtingClb2.getTheNameOfSportsClub().equals(nameOfSecondTeam)){
                sprtingClubGuest = sprtingClb2;
                identifiedGst = true;
            }
        }

        if(identifiedHme && identifiedGst){

            sprtingClubHome.setNumberOfTheMatchesPlayed(sprtingClubHome.getNumberOfTheMatchesPlayed() + 1);
            sprtingClubGuest.setNumberOfTheMatchesPlayed(sprtingClubGuest.getNumberOfTheMatchesPlayed() + 1);
            sprtingClubHome.setNumberOfScoredGoals(sprtingClubHome.getNumberOfScoredGoals() + scoreOfTeamOne);
            sprtingClubGuest.setNumberOfScoredGoals(sprtingClubGuest.getNumberOfScoredGoals() + scoreOfTeamTwo);
            sprtingClubHome.setNumberOfReceivedGoals(sprtingClubHome.getNumberOfReceivedGoals() + scoreOfTeamTwo);
            sprtingClubGuest.setNumberOfReceivedGoals(sprtingClubGuest.getNumberOfReceivedGoals() + scoreOfTeamOne);

            if(scoreOfTeamOne>scoreOfTeamTwo){

                sprtingClubHome.setNumberOfPointsAchievedByClub(sprtingClubHome.getNumberOfPointsAchievedByClub()+3);
                sprtingClubHome.setNumberOfWinsAchieved(sprtingClubHome.getNumberOfWinsAchieved()+1);
                sprtingClubGuest.setNumberOfDefeatsAchieved(sprtingClubGuest.getNumberOfDefeatsAchieved()+1);
                sprtingClubHome.setRecordedGoalDifference(sprtingClubHome.getRecordedGoalDifference()+(scoreOfTeamOne-scoreOfTeamTwo));
                sprtingClubGuest.setRecordedGoalDifference(sprtingClubGuest.getRecordedGoalDifference()+(scoreOfTeamOne - scoreOfTeamTwo));

            }else if( scoreOfTeamOne < scoreOfTeamTwo){
                sprtingClubGuest.setNumberOfPointsAchievedByClub(sprtingClubGuest.getNumberOfPointsAchievedByClub()+3);
                sprtingClubGuest.setNumberOfWinsAchieved(sprtingClubGuest.getNumberOfWinsAchieved()+1);
                sprtingClubHome.setNumberOfDefeatsAchieved(sprtingClubHome.getNumberOfDefeatsAchieved()+1);
                sprtingClubHome.setRecordedGoalDifference(sprtingClubHome.getRecordedGoalDifference()+(scoreOfTeamTwo-scoreOfTeamOne));
                sprtingClubGuest.setRecordedGoalDifference(sprtingClubGuest.getRecordedGoalDifference()+(scoreOfTeamTwo - scoreOfTeamOne));

            }else {
                sprtingClubHome.setNumberOfPointsAchievedByClub(sprtingClubHome.getNumberOfPointsAchievedByClub()+1);
                sprtingClubGuest.setNumberOfPointsAchievedByClub(sprtingClubGuest.getNumberOfPointsAchievedByClub()+1);
                sprtingClubHome.setNumberOfDrawsAchieved(sprtingClubHome.getNumberOfDrawsAchieved()+1);
                sprtingClubGuest.setNumberOfDrawsAchieved(sprtingClubGuest.getNumberOfDrawsAchieved()+1);
            }

            //adding to listOfPlayedMatches
            listOfPlayedMatches.add(new PlayedMatches(nameOfFirstTeam,nameOfSecondTeam,scoreOfTeamOne,scoreOfTeamTwo,matchPlayedDate));
        }
    }


    //delete existing clubs from the system
    @Override
    public void deleteExistFootballClub(String nameOfSportClub) {
        boolean format = false;
        for (FootballClub deleteClubs : listOfClubs) {
            if (deleteClubs.getTheNameOfSportsClub().equals(nameOfSportClub)) {
                format = true;
                listOfClubs.remove(deleteClubs);
                System.out.println("\n The Sport Club " + nameOfSportClub + " successfully removed");
                break;
            }

        }
        if (!format) {
            System.out.println("--- Club not found! Try Again ---\n");
        }
    }


    //display premier league table
    @Override
    public void premierLeagueTableDisplay() {
        listOfClubs.sort(Collections.reverseOrder());
        System.out.print("\n---->> Premier League Table <<----\n");
        System.out.format("\n%-18s%14s%14s%14s%14s%14s%14s%16s\n", "------------------", "-----------------------", "--------------", "---------------", "--------------", "-------------------", "--------------------------", "-----------------");
        System.out.format("%-18s%14s%14s%14s%14s%14s%14s%14s%16s\n", "| Name of Club |", " Played Matches |", " No.of Wins |", " No.of Draws |", " No.of Loss |", " Goals Received |", " Goals Scored |", " Goals Difference |", " Achieved Points |");
        System.out.format("%-18s%14s%14s%14s%14s%14s%14s%16s\n", "------------------", "-----------------------", "--------------", "---------------", "--------------", "-------------------", "-------------------------------------------", "");
        for (FootballClub sportsClub : listOfClubs) {
            System.out.format("%8s%16s%18s%15s%14s%15s%17s%16s%18s\n", sportsClub.getTheNameOfSportsClub(), sportsClub.getNumberOfTheMatchesPlayed(),
                    sportsClub.getNumberOfWinsAchieved(), sportsClub.getNumberOfDrawsAchieved(),  sportsClub.getNumberOfDefeatsAchieved(),  sportsClub.getNumberOfReceivedGoals(),
                    sportsClub.getNumberOfScoredGoals(),  sportsClub.getRecordedGoalDifference(),  sportsClub.getNumberOfPointsAchievedByClub());
            System.out.format("%-18s%14s%14s%14s%14s%14s%14s%16s\n", "------------------", "-----------------------", "--------------", "---------------", "--------------", "-------------------", "-------------------------------------------", "");

        }
    }

    //sorting
    //sorting from wins and goals in the gui
    //sorting the table descending order according to the wins achieved
    public List<FootballClub> sortFromWins(){
        List<FootballClub> sortByWinsList = new ArrayList<>();
        for(FootballClub fbClub : listOfClubs){
            sortByWinsList.add(fbClub);
            sortByWinsList.sort((fbClub1, fbClub2) -> Integer.valueOf(fbClub2.getNumberOfWinsAchieved()).compareTo(
                    fbClub1.getNumberOfWinsAchieved()));

        }
        return sortByWinsList;
    }

    //sorting the table descending order according to the goals scored
    public List<FootballClub> sortFromGoals(){
        List<FootballClub> sortByGoalsList = new ArrayList<>();
        for(FootballClub fbClub : listOfClubs){
            sortByGoalsList.add(fbClub);
            sortByGoalsList.sort((fbClub1, fbClub2) -> Integer.valueOf(fbClub2.getNumberOfScoredGoals()).compareTo(
                    fbClub1.getNumberOfScoredGoals()));
        }
        return sortByGoalsList;
    }
    //sorting the table which displays all the matches in ascending order according to the match played date
    public List<PlayedMatches> sortByDate(){
        List<PlayedMatches> sortingByDate = new ArrayList<>();
        for(PlayedMatches playedMatches : listOfPlayedMatches){
            sortingByDate.add(playedMatches);
            Collections.sort(sortingByDate, new Comparator<PlayedMatches>() {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                public int compare(PlayedMatches date1, PlayedMatches date2){
                    try{
                        return dateFormat.parse(String.valueOf(date1.getMatchPlayedDate())).compareTo(dateFormat.parse(String.valueOf(date2.getMatchPlayedDate())));
                    } catch (ParseException parseException){
                        throw new IllegalArgumentException(parseException);
                    }
                }
            });
        }
        return sortingByDate;
    }

    //sorting from wins and goals in the gui
    //sorting the table descending order according to the wins achieved
    public void sortFromWinsGUI(){
        Collections.sort(listOfClubs, (fbClub1, fbClub2) -> Integer.valueOf(fbClub2.getNumberOfWinsAchieved()).compareTo(fbClub1.getNumberOfWinsAchieved()));

    }
    //sorting the table descending order according to the goals achieved
    public void sortFromGoalsGUI(){
        Collections.sort(listOfClubs, (fb1, fb2) -> Integer.valueOf(fb2.getNumberOfScoredGoals()).compareTo(fb1.getNumberOfScoredGoals()));
    }

    //sorting the table descending order according to the points achieved by club
    public void sortFromPointsGUI(){
        Collections.sort(listOfClubs, (fbClb1, fbClb2) -> Integer.valueOf(fbClb2.getNumberOfPointsAchievedByClub()).compareTo(fbClb1.getNumberOfPointsAchievedByClub()));
    }


    //non return method for app based GUI
    //generate random played matches between clubs
    public void generateRandomPlayedMatches(){
        //declaring variables
        String nameOfFirstClub ;
        String nameOfSecondClub ;
        int scoreOfFirstTeam ;
        int scoreOfSecondTeam ;
        String formattingDate ;

        //accessing random years between 2014-2020
        LocalDate creatingRandomDate = generatingRandomDate(2014, 2020);

        //access random data
        int index = generateRandom.nextInt(listOfPlayedMatches.size());
        //access random name from the arraylist
        nameOfFirstClub = listOfPlayedMatches.get(index).getNameOfFirstTeam();
        nameOfSecondClub = listOfPlayedMatches.get(index).getNameOfSecondTeam();
        //access random number for the score
        scoreOfFirstTeam = generateRandom.nextInt(10);
        scoreOfSecondTeam = generateRandom.nextInt(10);
        //access random date of the format yyyy-MM-dd
        formattingDate = creatingRandomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //invoke method addPlayedMatchDetails
        this.addPlayedMatchDetails(nameOfFirstClub, nameOfSecondClub, scoreOfFirstTeam, scoreOfSecondTeam,formattingDate);
    }

    //return method to access generateRandom method from controller
    public List<PlayedMatches> getListOfPlayedMatches(){
        this.generateRandomPlayedMatches();
        return listOfPlayedMatches;
    }

    //void method to sort by date in display played matches in gui
    public void sortByDateGUI() {
        Collections.sort(listOfPlayedMatches, new Comparator<PlayedMatches>() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            public int compare(PlayedMatches date1, PlayedMatches date2) {
                try {
                    return dateFormat.parse(String.valueOf(date1.getMatchPlayedDate())).compareTo(dateFormat.parse(String.valueOf(date2.getMatchPlayedDate())));
                } catch (ParseException parseException) {
                    throw new IllegalArgumentException(parseException);
                }

            }
        });
    }

    //return type to access method from controller
    public List<FootballClub> sortFromPoints(){
        List<FootballClub> sortByPoints = new ArrayList<>();
        for(FootballClub fbClub : listOfClubs){
            sortByPoints.add(fbClub);
            sortByPoints.sort((fbClub1,fbClub2)-> Integer.valueOf(fbClub2.getNumberOfPointsAchievedByClub()).compareTo(
                    fbClub1.getNumberOfPointsAchievedByClub()));
        }
        return sortByPoints;
    }

    //data saving
    //saving data to files and loading data from files
    //save data to the file
    public void saveDataToTheFile() throws IOException {

        FileOutputStream writeDataToFile = new FileOutputStream(new File("LeagueManagerDetails.txt"));
        ObjectOutputStream objectToStream = new ObjectOutputStream(writeDataToFile);

        for (FootballClub footballClub : listOfClubs) {
            objectToStream.writeObject(footballClub);
        }

        objectToStream.flush();
        objectToStream.close();
        writeDataToFile.close();

    }

    //load saved data from the file
    public void loadDataFromFile()throws IOException, ClassNotFoundException{

        FileInputStream readDataFromFile = new FileInputStream(new File("LeagueManagerDetails.txt"));
        ObjectInputStream objectsFromStream = new ObjectInputStream(readDataFromFile);

        for(;;){

            try{
                FootballClub footballClub = (FootballClub) objectsFromStream.readObject();
                listOfClubs.add(footballClub);

            }catch(EOFException e){
                break;
            }
        }
        objectsFromStream.close();
        readDataFromFile.close();
    }


    //played match details

    //save data to the file from list of played matches
    public void saveDataToTheFileFromPlayedMatches() throws IOException {

        FileOutputStream writeDataToFileMatch = new FileOutputStream(new File("PlayedMatchDetails.txt"));
        ObjectOutputStream objectToStreamTwo = new ObjectOutputStream(writeDataToFileMatch);

        for (PlayedMatches playedMatches : listOfPlayedMatches) {
            objectToStreamTwo.writeObject(playedMatches);
        }

        objectToStreamTwo.flush();
        objectToStreamTwo.close();
        writeDataToFileMatch.close();
    }


    //load saved data from the file
    public void loadDataFromFileForMatchPlayedDetails()throws IOException, ClassNotFoundException{

        FileInputStream readDataFromFileMatch = new FileInputStream(new File("PlayedMatchDetails.txt"));
        ObjectInputStream objectsFromStreamTwo = new ObjectInputStream(readDataFromFileMatch);

        for(;;){

            try{
                PlayedMatches playedMatches = (PlayedMatches) objectsFromStreamTwo.readObject();
                listOfPlayedMatches.add(playedMatches);

            }catch(EOFException e){
                break;
            }
        }
        objectsFromStreamTwo.close();
        readDataFromFileMatch.close();
    }

    //validating date by format
    public static boolean validationOfDate(String matchPlayedDate) {
        for(PlayedMatches playedMatches: listOfPlayedMatches) {
            if (matchPlayedDate.trim().equals("-")) {
                listOfPlayedMatches.add(playedMatches);
            } else {
                SimpleDateFormat simpleDf = new SimpleDateFormat("yyyy-MM-dd");
                simpleDf.setLenient(false);
                //parse string to date object
                try {
                    Date date = simpleDf.parse(matchPlayedDate);
                } catch (ParseException exception) {
                    System.out.println(matchPlayedDate + " is an invalid date format! Try Again");
                    return false;
                }
            }
        }
        return true;
    }
}
