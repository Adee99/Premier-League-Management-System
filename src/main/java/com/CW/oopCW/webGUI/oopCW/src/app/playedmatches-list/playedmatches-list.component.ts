import { Component, OnInit } from '@angular/core';
import {Playedmatches} from '../playedmatches-list/playedmatches'
import {PlayedmatchDetailsService} from '../playedmatches-list/playedmatch-details.service'

@Component({
  selector: 'app-playedmatches-list',
  templateUrl: './playedmatches-list.component.html',
  styleUrls: ['./playedmatches-list.component.css']
})
export class PlayedmatchesListComponent implements OnInit {
    titleMatch = "Played Match Details";
    playedmatch:Playedmatches[]; //defining a property for played matches
    dateSearch:any;

  constructor(private playedMatchService :PlayedmatchDetailsService ) { }

  ngOnInit(): void {
    this.getPlayedMatchDetails();
    this.generateRandomMatch();
  }

  //method to access played match details
  public  getPlayedMatchDetails(){
    this.playedMatchService.getPlayedMatchList().subscribe(data => {
      this.playedmatch = data;
    })
  }

//method to generate random matches
  public generateRandomMatch(){
    this.playedMatchService.generateRandomMatch().subscribe(data=>{
      this.playedmatch = data;
    })
  }

  //method match search by date
  public searchMatch(){
    this.playedMatchService.searchMatchByDate(this.dateSearch).subscribe(data=>{
      this.playedmatch = data;
    })
  }

  }


