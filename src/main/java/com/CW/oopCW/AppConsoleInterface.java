package com.CW.oopCW;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.CW.oopCW.model.SchoolFootballClub;
import com.CW.oopCW.model.UniversityFootballClub;
import com.CW.oopCW.service.PremierLeagueManager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class AppConsoleInterface{

    private final static PremierLeagueManager leagueManagerNw= new PremierLeagueManager();


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        leagueManagerNw.loadDataFromFileForMatchPlayedDetails();//loading saved data from the file matchPlayedDetails
        leagueManagerNw.loadDataFromFile();//loading saved data
        Scanner userChoiceInput = new Scanner(System.in);

        boolean userInput = true;

        //getting User Input
        while(userInput){
            System.out.println("\n----- Premier League Championship Management System ------ ");
            System.out.println("\n---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n");
            System.out.println("|-->> 1: Enter 1 to Add a new Football club to the system ");
            System.out.println("|-->> 2: Enter 2 to Delete a Football club from the system ");
            System.out.println("|-->> 3: Enter 3 to Display Premier League table on Console");
            System.out.println("|-->> 4: Enter 4 to Display information of selected clubs");
            System.out.println("|-->> 5: Enter 5 to Add played match details(Score & Date)");
            System.out.println("|-->> 6: Enter 6 to Display the GUI");
            System.out.println("|-->> 7: Enter 7 to Display help view");
            System.out.println("|-->> 8: Enter 8 to launch Web Application");
            System.out.println("|-->> 9: Enter 9 to Exit");
            System.out.println("--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+");
            System.out.print("|-->> Enter your choice: ");

            String choiceInputByUser = userChoiceInput.next();
            switch (choiceInputByUser){
                case "1":
                    addNewFootballClub();
                    break;
                case "2":
                    deleteExistFootballClub();
                    break;
                case "3":
                    leagueManagerNw.premierLeagueTableDisplay();
                    break;
                case "4":
                    displayDetailsOfClubs();
                    break;
                case "5":
                    addPlayedMatchDetails();
                    break;
                case "6":
                    loadAppGUI();
                    break;
                case "7":
                    helpView();
                    break;
                case "9":
                    leagueManagerNw.saveDataToTheFile();//saving data to the file when user exits the application
                    leagueManagerNw.saveDataToTheFileFromPlayedMatches();
                    System.out.println("\n--> Data Successfully Saved to the file <--");
                    System.exit(1);
                    break;
                case "8":
                    loadAppWebBased();
                    break;
                default:
                    System.out.println("\n-- Invalid Input! Check again --");

            }
        }
    }

//load GUI(javafx)
    private static void loadAppGUI(){
        Application.launch(ProgrammeGUI.class);
    }

    //load GUI(Angular)
    private static void loadAppWebBased(){
        SpringApplication.run(AppConsoleInterface.class);
    }

    private static void addNewFootballClub(){

        boolean nameValidation;
        boolean locationValidation;
        Scanner inputNwClub = new Scanner(System.in);

        //validating the user input to only allow letters for the name
        String theNameOfSportsClub;
        do {
            System.out.print("\nEnter the Name of the Sports Club: ");
            theNameOfSportsClub = inputNwClub.next();
            nameValidation = theNameOfSportsClub.matches("^[a-zA-Z]*$");//reference=https://www.javatpoint.com/java-regex
            if (!nameValidation) {
                System.out.println("\n--> Please Enter a valid Input (Only Letters Allowed) <--");
            }
        }while (!nameValidation);

        //validating the user input to only allow letters for the location
        String theLocationOfSportsClub;
        do {
            System.out.print("Enter the location of the Sports Club: ");
            theLocationOfSportsClub = inputNwClub.next();
            locationValidation = theLocationOfSportsClub.matches("^[a-zA-Z]*$");//reference=https://www.javatpoint.com/java-regex
            if (!locationValidation) {
                System.out.println("\n--> Please Enter a valid Input (Only Letters Allowed) <--");
            }
        }while(!locationValidation);

        //user input to choose club type
        System.out.println("\n-- Enter the type of the club --");
        System.out.println(" Enter S for school football club ");
        System.out.println(" Enter U for university football club ");
        System.out.print(" Enter your choice: ");

        //declaring variable to check input
        String typeOfClub;

        SchoolFootballClub schoolClub;
        UniversityFootballClub uniClub;

        while (true){
            try{
                typeOfClub = inputNwClub.next();

            }catch (InputMismatchException | IllegalArgumentException ex){
                System.out.println("\n--> Invalid Input! Try Again <--");
                inputNwClub.next();
                continue;
            }
            break;
        }

        switch (typeOfClub){
            case "S":
            case "s":
                System.out.print("\nEnter the name of the School: ");
                String theNameOfSchool = inputNwClub.next();
                schoolClub = new SchoolFootballClub(theNameOfSportsClub, theLocationOfSportsClub,0,0,0,0,0,0,0,0,"-",theNameOfSchool);
                leagueManagerNw.addNewFootballClub(schoolClub);
                break;
            case "u":
            case "U":
                System.out.print("\n Enter the name of the University: ");
                String theNameOfUniversity = inputNwClub.next();
                uniClub = new UniversityFootballClub(theNameOfSportsClub,theLocationOfSportsClub,0,0,0,0,0,0,0,0,"-",theNameOfUniversity);
                leagueManagerNw.addNewFootballClub(uniClub);
                break;
            default:
                System.out.println("-- Please enter valid Input --");
        }
    }



    //delete existing club in the system
    private static void deleteExistFootballClub(){
        Scanner inputDlt = new Scanner(System.in);
        System.out.print("\n Enter the Name of the Sports Club: ");
        String nameOfSportClub = inputDlt.next();
        leagueManagerNw.deleteExistFootballClub(nameOfSportClub);
    }

    //display statics of clubs after search by name
    private static void displayDetailsOfClubs(){
        Scanner inputDetailsForDisplay = new Scanner(System.in);
        System.out.print("\n Enter the name of the sport club to display details: ");
        String namesForClubSearch = inputDetailsForDisplay.next();
        leagueManagerNw.displayDetailsOfClubs(namesForClubSearch);

    }


    //help view
    private static void helpView(){
        System.out.println("\n ---> Help View <---");
        System.out.println("---->| Add clubs to the system before adding played matches between clubs. ");
        System.out.println("---->| You can use provided buttons in the GUI to sort statistics. ");
        System.out.println("---->| All data will be automatically saved when the user press 8 and exit the application. ");
        System.out.println("----------------------------------------------------------------------------");
    }

    //adding details of played matches between two existing clubs in the system
    public static void addPlayedMatchDetails() {
        boolean clubNameValidation;
        Scanner inputPlayedMatch = new Scanner(System.in);

        //validating date input

        while (true) {
            System.out.print("\n Enter the date of matches played: ");
            String matchPlayedDate = inputPlayedMatch.next();
            if (matchPlayedDate.trim().equals("-")) {
                System.out.print("--> "+ matchPlayedDate + " Date Successfully Added");
            } else {
                SimpleDateFormat simpleDf = new SimpleDateFormat("yyyy-MM-dd");
                simpleDf.setLenient(false);
                //parse string to date object
                try {
                    Date date = simpleDf.parse(matchPlayedDate);
                    System.out.print("--> "+matchPlayedDate + " Date Successfully Added");
                } catch (ParseException exception) {
                    System.out.println("\n-->" + matchPlayedDate + " is an invalid date format! Try Again");
                    return;
                }
            }

            String nameOfFirstTeam;
            do {
                System.out.print("\n Enter the name of first club: ");
                nameOfFirstTeam = inputPlayedMatch.next();
                clubNameValidation = nameOfFirstTeam.matches("^[a-zA-Z]*$");
                if (!clubNameValidation) {
                    System.out.println("\n--> Please Enter a valid Input (Only Letters Allowed) <--");
                }
            }while (!clubNameValidation);

            String nameOfSecondTeam;
            do {
                System.out.print("\n Enter the name of second club:  ");
                nameOfSecondTeam = inputPlayedMatch.next();
                clubNameValidation = nameOfSecondTeam.matches("^[a-zA-Z]*$");
                if (!clubNameValidation) {
                    System.out.println("\n--> Please Enter a valid Input (Only Letters Allowed) <--");
                }
            }while (!clubNameValidation);
            //validating the input to get integers
            int scoreOfTeamOne;
            do {
                System.out.print("\n Enter the score of first club: ");
                while (!inputPlayedMatch.hasNextInt()) {
                    System.out.print(" Please enter an integer:  ");
                    inputPlayedMatch.next();
                }
                scoreOfTeamOne = inputPlayedMatch.nextInt();
            } while (scoreOfTeamOne <= 0);

            //validating the input to get integers
            int scoreOfTeamTwo;
            do {
                System.out.print("\n Enter the score of second club: ");
                while (!inputPlayedMatch.hasNextInt()) {
                    System.out.print(" Please enter an integer: ");
                    inputPlayedMatch.next();
                }
                scoreOfTeamTwo = inputPlayedMatch.nextInt();
            } while (scoreOfTeamTwo <= 0);

            System.out.println("\n--> Match between "+ nameOfFirstTeam + " and " + nameOfSecondTeam +" Successfully Added <--");
            leagueManagerNw.addPlayedMatchDetails(nameOfFirstTeam, nameOfSecondTeam, scoreOfTeamOne, scoreOfTeamTwo, matchPlayedDate);

            return;
        }
    }

}
