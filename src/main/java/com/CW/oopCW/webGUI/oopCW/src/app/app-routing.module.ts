import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayedmatchesListComponent } from './playedmatches-list/playedmatches-list.component';
import { SportsClubListComponent } from './sports-club-list/sports-club-list.component';


const routes: Routes = [
  {path:'sportsclubs',component: SportsClubListComponent},//configering app routing module
  {path:'',redirectTo:'sportsclubs',pathMatch:'full'},//configering path
  {path:'playedmatches',component : PlayedmatchesListComponent},
  {path:'',redirectTo:'playedmatches',pathMatch:'full'},
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
