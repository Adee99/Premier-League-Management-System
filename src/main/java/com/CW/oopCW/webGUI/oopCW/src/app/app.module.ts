import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SportsClubListComponent } from './sports-club-list/sports-club-list.component';
import { ClubDetailsService } from './sports-club-list/club-details.service';
import { PlayedmatchesListComponent } from './playedmatches-list/playedmatches-list.component';
import { PlayedmatchDetailsService } from './playedmatches-list/playedmatch-details.service';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    SportsClubListComponent,
    PlayedmatchesListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClubDetailsService,PlayedmatchDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }