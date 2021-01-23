package com.CW.oopCW.service;

import com.CW.oopCW.model.FootballClub;
import com.CW.oopCW.model.PlayedMatches;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {
    void addNewFootballClub(FootballClub addingNewClubs);
    void displayDetailsOfClubs(String nameForClubSearch);
    void addPlayedMatchDetails(String nameOfFirstTeam, String nameOfSecondTeam, int scoreOfTeamOne, int scoreOfTeamTwo,String matchPlayedDate);
    void saveDataToTheFile()throws IOException;
    void loadDataFromFile()throws IOException, ClassNotFoundException;
    void saveDataToTheFileFromPlayedMatches()throws IOException;
    void loadDataFromFileForMatchPlayedDetails()throws IOException, ClassNotFoundException;
    void deleteExistFootballClub(String nameOfSportClub);
    void  generateRandomPlayedMatches();
    void premierLeagueTableDisplay();
    List<PlayedMatches> searchMatchByDate(String matchPlayedDates);
}
