import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from 'src/app/app.component';
import { HomeComponent } from './home/home.component';
import { MoviesComponent } from './movies/movies.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { WebsiteRoutingModule } from './website-routing.module';
import { MovieComponent } from './movie/movie.component';
import { AuthorComponent } from './author/author.component';
import { AuthorsComponent } from './authors/authors.component';
import { CommentComponent } from './comment/comment.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MoviesComponent,
    MovieComponent,
    AuthorComponent,
    AuthorsComponent,
    CommentComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    WebsiteRoutingModule,
    FormsModule,
  ]
})
export class WebsiteModule { }
