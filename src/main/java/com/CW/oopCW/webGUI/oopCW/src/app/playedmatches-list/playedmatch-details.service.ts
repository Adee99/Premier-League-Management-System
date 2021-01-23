import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Playedmatches } from '../playedmatches-list/playedmatches';

@Injectable({
  providedIn: 'root'
})
export class PlayedmatchDetailsService {

  private basicURL = "http://localhost:8080/api/v1/sortDate";
 // private dateSearch="http://localhost:8080/api/v1/{matchDate}";
  private randomMatch="http://localhost:8080/api/v1/generateRandom";
  private search = "http://localhost:8080/api/v1/search/";
  constructor(private httpClientMatch : HttpClient) {}

  getPlayedMatchList():Observable<Playedmatches[]>{
    return this.httpClientMatch.get<Playedmatches[]>(this.basicURL);
  }

  searchMatchByDate(searchDate:any):Observable<Playedmatches[]>{
   return this.httpClientMatch.get<Playedmatches[]>(this.search + searchDate)
  }

  generateRandomMatch():Observable<Playedmatches[]>{
    return this.httpClientMatch.get<Playedmatches[]>(this.randomMatch)
  }


}
