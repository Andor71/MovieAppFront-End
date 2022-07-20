import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateMovieComponent } from './create-movie/create-movie.component';
import { AdminRoutingModule } from './admin-routing.module';
import { FormsModule } from '@angular/forms';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { DeleteAuthorComponent } from './delete-author/delete-author.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';



@NgModule({
  declarations: [
    CreateMovieComponent,
    CreateAuthorComponent,
    DeleteAuthorComponent,
    DeleteMovieComponent,
    UpdateMovieComponent,
    UpdateAuthorComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
