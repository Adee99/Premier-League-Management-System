import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SportsClub } from '../sports-club-list/sports-club';

@Injectable({
  providedIn: 'root'
})
export class ClubDetailsService {

  private basicURL = "http://localhost:8080/api/v1/fbClubList";
  private urlSortGoals = "http://localhost:8080/api/v1/sortGoals";
  private urlSortWins = "http://localhost:8080/api/v1/sortWins";
  private urlSortpoints = "http://localhost:8080/api/v1/sortPoints"
  constructor(private httpClient : HttpClient) { }

  getClubDetailsList():Observable<SportsClub[]>{
    return this.httpClient.get<SportsClub[]>(this.basicURL);
  }

getSortByGoals():Observable<SportsClub[]>{
  return this.httpClient.get<SportsClub[]>(this.urlSortGoals)
}
 getSortByWins():Observable<SportsClub[]>{
  return this.httpClient.get<SportsClub[]>(this.urlSortWins)
 }

 getSortByPoints():Observable<SportsClub[]>{
  return this.httpClient.get<SportsClub[]>(this.urlSortpoints)
}
}
