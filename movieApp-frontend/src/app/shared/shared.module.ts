import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { PreloaderComponent } from './preloader/preloader.component';
import { MovieCardComponent } from './movie-card/movie-card.component';
import { RouterModule } from '@angular/router';
import { AuthorCardComponent } from './author-card/author-card.component';

@NgModule({
  declarations: [
    NavbarComponent,
    PreloaderComponent,
    MovieCardComponent,
    AuthorCardComponent,
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    NavbarComponent,
    PreloaderComponent,
    MovieCardComponent,
    AuthorCardComponent
  ]
})
export class SharedModule { }
