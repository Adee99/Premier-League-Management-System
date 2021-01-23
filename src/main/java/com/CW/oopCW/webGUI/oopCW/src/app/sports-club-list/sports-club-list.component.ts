import { Component, OnInit } from '@angular/core';
import {SportsClub} from '../sports-club-list/sports-club'
import{ClubDetailsService} from '../sports-club-list/club-details.service'

@Component({
  selector: 'app-sports-club-list',
  templateUrl: './sports-club-list.component.html',
  styleUrls: ['./sports-club-list.component.css']
})
export class SportsClubListComponent implements OnInit {
  title1 = "Premier League Table";

  sportsclubs:SportsClub[]; //defining a property for sportsclub array

  constructor(private clubDetailsService : ClubDetailsService ) { }

  ngOnInit(): void {
    this.getClubDetails();
    this.getSortByGoals();
    this.getSortByWins();
    
  }

  private getClubDetails(){
    this.clubDetailsService.getClubDetailsList().subscribe(data =>{
      this.sportsclubs = data;
    });
  }

  public getSortByGoals(){
    this.clubDetailsService.getSortByGoals().subscribe(data =>{
      this.sportsclubs = data;
    })
  }

  public getSortByWins(){
    this.clubDetailsService.getSortByWins().subscribe(data => {
      this.sportsclubs = data;
    })
  }

  public getSortByPoints(){
    this.clubDetailsService.getSortByPoints().subscribe(data=>{
      this.sportsclubs = data;
    })
  }
}
