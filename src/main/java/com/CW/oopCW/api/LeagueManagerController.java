package com.CW.oopCW.api;

import com.CW.oopCW.model.FootballClub;
import com.CW.oopCW.model.PlayedMatches;
import com.CW.oopCW.service.PremierLeagueManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
@RestController
public class LeagueManagerController {
PremierLeagueManager premierLeagueManager = new PremierLeagueManager();


//football club details list
    @GetMapping("/fbClubList")
    public List<FootballClub> fbClubList(){
        return premierLeagueManager.getFootBallClubList();
    }

  /*  @GetMapping("/matchlist/{matchDate}")
    public PlayedMatches matchesByDate(@PathVariable String matchDate){
        return premierLeagueManager.searchByDate(matchDate);
    }*/

   /* @GetMapping("/fbClubList/matchDate")
    public List<PlayedMatches> searchByDate(@PathVariable String matchDate){
    return premierLeagueManager.searchMatchByDate(matchDate);
    }*/

    //search match by date
    @GetMapping(path = "search/{matchDate}")
    public List<PlayedMatches> searchByDate(@PathVariable("matchDate") String matchDate){
        return premierLeagueManager.searchMatchByDate(matchDate);
    }

    //played matches details
    @GetMapping("/matchDetails")
    public List<PlayedMatches> playedMatches(){
        return premierLeagueManager.playedMatches();
    }

    @GetMapping("/sortWins")
    public List<FootballClub> sortByWins(){
        return premierLeagueManager.sortFromWins();
    }

    @GetMapping("/sortGoals")
    public List<FootballClub> sortByGoals(){
        return premierLeagueManager.sortFromGoals();
    }

    @GetMapping("/sortPoints")
    public List<FootballClub> sortByPoints(){
        return premierLeagueManager.sortFromPoints();
    }

    @GetMapping("/sortDate")
    public List<PlayedMatches> sortByDate(){
        return premierLeagueManager.sortByDate();
    }

  @GetMapping("/generateRandom")
    public List<PlayedMatches> getListOfPlayedMatches(){
        return premierLeagueManager.getListOfPlayedMatches();

  }


//    @GetMapping("/random")
//    public List<PlayedMatches>generateRandom(){
//        return premierLeagueManager.generatingRandomPlayedMatches();
//    }

}
