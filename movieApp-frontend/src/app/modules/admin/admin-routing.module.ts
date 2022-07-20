import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { CreateMovieComponent } from './create-movie/create-movie.component';
import { DeleteAuthorComponent } from './delete-author/delete-author.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';

const routes: Routes = [
  {path: 'create-movie', component: CreateMovieComponent},
  {path: 'create-author', component: CreateAuthorComponent},
  {path: 'delete-author',component:DeleteAuthorComponent},
  {path: 'delete-movie', component: DeleteMovieComponent},
  {path: 'update-author',component:UpdateAuthorComponent},
  {path: 'update-movie',component:UpdateMovieComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
