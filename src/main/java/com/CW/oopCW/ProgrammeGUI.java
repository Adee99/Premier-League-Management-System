package com.CW.oopCW;

import com.CW.oopCW.model.FootballClub;
import com.CW.oopCW.model.PlayedMatches;
import com.CW.oopCW.service.PremierLeagueManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import static javafx.scene.paint.Color.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class ProgrammeGUI extends Application {

    public static List<PlayedMatches> searchDetails;
    PremierLeagueManager pLeagueManager = new PremierLeagueManager();
    //creating buttons for sorting data in the table

    Button sortFromPoints = new Button("Sort From Points");
    Button sortFromGoals = new Button("Sort From Goals");
    Button sortFromWins = new Button("Sort From Wins");
    Button autoGenerate = new Button("Auto Generate Matches");
    Button matchSearch = new Button("Search Matches");
    Button playedMatches = new Button("Display Played Matches");

    //labels
    Label headLbl = new Label("Welcome");
    Label headLbl2 = new Label("- Premier League Management System -");
    Label headLbl3 = new Label(" Premier League Table");

    //text field for search by date
    TextField searchField = new TextField();

    //tables for view details
    TableView<FootballClub>table1;
    TableView<PlayedMatches>table2;
    TableView<PlayedMatches>tableToDisplayPlayedMatches;

/*
   public static void main(String[] args) {
        launch(args);

    }*/

    @Override
    public void start(Stage primaryStageNew) throws Exception {
        primaryStageNew.setTitle(" Premier League Management System ");

        //background pane
        BorderPane backgroundPane = new BorderPane();

        //pane
        Pane subPane = new Pane();

        //setting up background image
        Image image = new Image("file:Img2.jpg");
        ImageView imgView = new ImageView();
        imgView.setImage(image);
        backgroundPane.getChildren().add(imgView);

        //setting image view
        imgView.setFitWidth(1020);
        imgView.setFitHeight(800);
        imgView.setPreserveRatio(false);



        //setting up columns

        TableColumn<FootballClub,String > clubNameColumn = new TableColumn<>("Name Of \nClub");
        clubNameColumn.setPrefWidth(90);
        clubNameColumn.setCellValueFactory(new PropertyValueFactory<>("theNameOfSportsClub"));


        TableColumn<FootballClub,Integer > numOfPlayedMatches = new TableColumn<>("No. Of \nMatches \nPlayed");
        numOfPlayedMatches.setMinWidth(90);
        numOfPlayedMatches.setCellValueFactory(new PropertyValueFactory<>("numberOfTheMatchesPlayed"));


        TableColumn<FootballClub,Integer > numOfWinsAchieved = new TableColumn<>("No. Of \nWins");
        numOfWinsAchieved.setMinWidth(90);
        numOfWinsAchieved.setCellValueFactory(new PropertyValueFactory<>("numberOfWinsAchieved"));


        TableColumn<FootballClub,Integer > numOfDrawsAchieved = new TableColumn<>("No. Of \nDraws");
        numOfDrawsAchieved.setMinWidth(90);
        numOfDrawsAchieved.setCellValueFactory(new PropertyValueFactory<>("numberOfDrawsAchieved"));


        TableColumn<FootballClub,Integer > numOfLossAchieved = new TableColumn<>("No. Of \nLoss");
        numOfLossAchieved.setMinWidth(55.55);
        numOfLossAchieved.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeatsAchieved"));


        TableColumn<FootballClub,Integer > numOfGoalsReceived = new TableColumn<>("Received \nGoals");
        numOfGoalsReceived.setMinWidth(55.55);
        numOfGoalsReceived.setCellValueFactory(new PropertyValueFactory<>("numberOfReceivedGoals"));


        TableColumn<FootballClub,Integer > numOfGoalsScored = new TableColumn<>("Scored \nGoals");
        numOfGoalsScored.setMinWidth(55.55);
        numOfGoalsScored.setCellValueFactory(new PropertyValueFactory<>("numberOfScoredGoals"));


        TableColumn<FootballClub,Integer > numOfGoalDifference = new TableColumn<>("Goal \nDifference");
        numOfGoalDifference.setMinWidth(55.55);
        numOfGoalDifference.setCellValueFactory(new PropertyValueFactory<>("recordedGoalDifference"));


        TableColumn<FootballClub,Integer > numOfAchievedPoints = new TableColumn<>("Achieved \nPoints");
        numOfAchievedPoints.setPrefWidth(94);
        numOfAchievedPoints.setCellValueFactory(new PropertyValueFactory<>("numberOfPointsAchievedByClub"));

        table1 = new TableView<>();
        table1.setItems(getDetailsToDisplay());
        table1.getColumns().addAll(clubNameColumn,numOfPlayedMatches,numOfWinsAchieved,numOfDrawsAchieved,numOfLossAchieved,numOfGoalsReceived, numOfGoalsScored,numOfGoalDifference,numOfAchievedPoints);

//setting up vbox for the table
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table1);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMaxWidth(765);
        table1.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 2px;");

        //setting functions to sortFromGoals button

        subPane.getChildren().add(sortFromGoals);
        sortFromGoals.setLayoutX(120);
        sortFromGoals.setLayoutY(220);
        sortFromGoals.setTextFill(BLACK);
        sortFromGoals.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");

        sortFromGoals.setOnAction(event -> {
            pLeagueManager.sortFromGoalsGUI();
            table1.setItems(getDetailsToDisplay());
            table1.refresh();

        });

        subPane.getChildren().add(matchSearch);
        matchSearch.setLayoutX(120);
        matchSearch.setLayoutY(150);
        matchSearch.setTextFill(BLACK);
        matchSearch.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");


        //setting up functions to sortFromPoints button to sort by points
        subPane.getChildren().add(sortFromPoints);
        sortFromPoints.setLayoutX(320);
        sortFromPoints.setLayoutY(220);
        sortFromPoints.setTextFill(BLACK);
        sortFromPoints.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");

        sortFromPoints.setOnAction(event -> {
            pLeagueManager.sortFromPointsGUI();
            table1.setItems(getDetailsToDisplay());
            table1.refresh();
        });

        //setting functions to sortFromGoals button

        subPane.getChildren().add(sortFromWins);
        sortFromWins.setLayoutX(520);
        sortFromWins.setLayoutY(220);
        sortFromWins.setTextFill(BLACK);
        sortFromWins.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");

        sortFromWins.setOnAction(event -> {
            pLeagueManager.sortFromWinsGUI();
            table1.setItems(getDetailsToDisplay());
            table1.refresh();

        });

        subPane.getChildren().add(autoGenerate);
        autoGenerate.setLayoutX(710);
        autoGenerate.setLayoutY(220);
        autoGenerate.setTextFill(BLACK);
        autoGenerate.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");


        //button to display played match details
        subPane.getChildren().add(playedMatches);
        playedMatches.setLayoutX(520);
        playedMatches.setLayoutY(150);
        playedMatches.setTextFill(BLACK);
        playedMatches.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");

        //Label 1
        subPane.getChildren().add(headLbl);
        headLbl.setAlignment(Pos.TOP_CENTER);
        headLbl.setLayoutX(420);
        headLbl.setLayoutY(12);



        final double fontSizeHead = 40.0;
        headLbl.setFont(new Font(fontSizeHead));
        headLbl.setTextFill(BLACK);
        headLbl.setStyle("-fx-font-weight: bold");


        //Label 2
        subPane.getChildren().add(headLbl2);
        headLbl2.setAlignment(Pos.TOP_CENTER);
        headLbl2.setLayoutX(256);
        headLbl2.setLayoutY(68);

        final double fontSizeHead2 = 25.0;
        headLbl2.setFont(new Font(fontSizeHead2));
        headLbl2.setTextFill(BLACK);
        headLbl2.setStyle("-fx-font-weight: bold");

        //label 3
        subPane.getChildren().add(headLbl3);
        headLbl3.setLayoutX(360);
        headLbl3.setLayoutY(290);

        final double fontSizeHead3 = 25.0;
        headLbl3.setFont(new Font(fontSizeHead3));
        headLbl3.setTextFill(BLACK);
        headLbl3.setStyle("-fx-font-weight: bold");


        //textField for search

        subPane.getChildren().add(searchField);
        searchField.setLayoutX(260);
        searchField.setLayoutY(148);
        searchField.setPromptText("YYYY-MM-DD");
        searchField.setStyle("-fx-border-color: #2d2d42; -fx-border-width: 2px;-fx-border-radius: 4px;");


        backgroundPane.setTop(subPane);
        backgroundPane.setCenter(vBox);


        //adding functions to search by date button
        matchSearch.setOnAction(event -> {
            Stage mainWindow = (Stage) matchSearch.getScene().getWindow();
            //mainWindow.close();
            BorderPane searchResultStg = new BorderPane();

            //setting up new window for table view of search by date
            Stage searchResultStage = new Stage();
            searchResultStage.setTitle("Search Result");
            searchResultStage.setResizable(false);

            //search result window
            //search result table
            TableColumn<PlayedMatches,String > teamOneName = new TableColumn<>("Team One");
            teamOneName.setPrefWidth(90);
            teamOneName.setCellValueFactory(new PropertyValueFactory<>("nameOfFirstTeam"));

            TableColumn<PlayedMatches,String > teamTwoName = new TableColumn<>("Team Two");
            teamTwoName.setPrefWidth(90);
            teamTwoName.setCellValueFactory(new PropertyValueFactory<>("nameOfSecondTeam"));

            TableColumn<PlayedMatches,String > teamOneScore = new TableColumn<>("Team One \nScore");
            teamOneScore.setPrefWidth(90);
            teamOneScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTeamOne"));

            TableColumn<PlayedMatches,String > teamTwoScore = new TableColumn<>("Team Two \nScore");
            teamTwoScore.setPrefWidth(90);
            teamTwoScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTeamTwo"));

            TableColumn<PlayedMatches,String > matchPlayedDate = new TableColumn<>("Match Played \nDate");
            matchPlayedDate.setPrefWidth(120);
            matchPlayedDate.setCellValueFactory(new PropertyValueFactory<>("matchPlayedDate"));

            table2 = new TableView<>();
            table2.getColumns().addAll(teamOneName,teamTwoName,teamOneScore,teamTwoScore,matchPlayedDate);

            VBox vBox2 = new VBox();
            vBox2.getChildren().addAll(table2);
            vBox2.setAlignment(Pos.CENTER);

            vBox2.setMaxWidth(480);
            searchResultStg.setCenter(vBox2);

            searchResultStage.setScene(new Scene(searchResultStg,480,400));
            searchResultStage.show();

            //checking whether entered date is valid
            if (PremierLeagueManager.validationOfDate(searchField.getText())) {
                searchDetails = pLeagueManager.searchMatchByDate(searchField.getText());
                //display played matches by accessed date
                table2.setItems(getMatchPlayedDetailsByDate(searchDetails));

            }else{
                searchField.setPromptText("Invalid Input");
                //change text field color for invalid inputs
                searchField.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 4px;");
                searchField.setPromptText("YYYY-MM-DD");

            }

        });

        //adding functions to auto generate button
        autoGenerate.setOnAction(event -> {
            //accessing method to auto generate matches
            pLeagueManager.generateRandomPlayedMatches();
            table1.setItems(getDetailsToDisplay());
            table1.refresh();

        });

        //adding functions to search by date button
        playedMatches.setOnAction(event -> {
            Stage mainWindow = (Stage) playedMatches.getScene().getWindow();

            //mainWindow.close();
            BorderPane searchResultStg = new BorderPane();

            //setting up new window for table view of search by date
            Stage matchDetailsStage = new Stage();
            matchDetailsStage.setTitle("Played Match Details");
            matchDetailsStage.setResizable(false);
            //search result window

            //table column team one
            TableColumn<PlayedMatches,String > teamOneName = new TableColumn<>("Team One");
            teamOneName.setPrefWidth(90);
            teamOneName.setCellValueFactory(new PropertyValueFactory<>("nameOfFirstTeam"));

            //table column team two
            TableColumn<PlayedMatches,String > teamTwoName = new TableColumn<>("Team Two");
            teamTwoName.setPrefWidth(90);
            teamTwoName.setCellValueFactory(new PropertyValueFactory<>("nameOfSecondTeam"));

            //table column team one score
            TableColumn<PlayedMatches,String > teamOneScore = new TableColumn<>("Team One \nScore");
            teamOneScore.setPrefWidth(90);
            teamOneScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTeamOne"));

            //table column team two score
            TableColumn<PlayedMatches,String > teamTwoScore = new TableColumn<>("Team Two \nScore");
            teamTwoScore.setPrefWidth(90);
            teamTwoScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTeamTwo"));

            //table column team match played
            TableColumn<PlayedMatches,String > matchPlayedDate = new TableColumn<>("Match Played \nDate");
            matchPlayedDate.setPrefWidth(120);
            matchPlayedDate.setCellValueFactory(new PropertyValueFactory<>("matchPlayedDate"));

            tableToDisplayPlayedMatches = new TableView<>();
            //add data tabular format
            tableToDisplayPlayedMatches.getColumns().addAll(teamOneName,teamTwoName,teamOneScore,teamTwoScore,matchPlayedDate);
            //method to load data sorted according to date
            pLeagueManager.sortByDateGUI();
            //set items table
            tableToDisplayPlayedMatches.setItems(getPlayedMatchDetailsToDisplay());
            tableToDisplayPlayedMatches.refresh();

            VBox vBox2 = new VBox();
            vBox2.getChildren().addAll(tableToDisplayPlayedMatches);
            vBox2.setAlignment(Pos.CENTER);
            //setting up match table max width
            vBox2.setMaxWidth(480);
            searchResultStg.setCenter(vBox2);

            matchDetailsStage.setScene(new Scene(searchResultStg,480,400));
            matchDetailsStage.show();

        });


        Scene scene1 = new Scene(backgroundPane,1000,760);
        primaryStageNew.setScene(scene1);
        primaryStageNew.setResizable(false);
        primaryStageNew.show();

    }

    //display club details in the premier league table
    public static ObservableList<FootballClub> getDetailsToDisplay() {
        //SportsClub sportsClub = new SportsClub(FXCollections.observableArrayList(SportsClub.listOfClubs));
        return FXCollections.observableList(PremierLeagueManager.listOfClubs);
    }

    //search played matches by date
    public static ObservableList<PlayedMatches> getMatchPlayedDetailsByDate(List<PlayedMatches> playedMatches){
        return FXCollections.observableArrayList(playedMatches);
    }

    //display all played matches
    public static ObservableList<PlayedMatches>getPlayedMatchDetailsToDisplay(){
        return FXCollections.observableList(PremierLeagueManager.listOfPlayedMatches);
    }

}
