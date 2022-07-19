import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { CreateMovieComponent } from './create-movie/create-movie.component';

const routes: Routes = [
  {path: 'create-movie', component: CreateMovieComponent},
  {path: 'create-author', component: CreateAuthorComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
