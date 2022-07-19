import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthorDto } from 'src/app/core/models/author.model';
import { MovieDto } from 'src/app/core/models/movie.model';
import { AuthorService } from 'src/app/core/services/author.service';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  movieLoading: boolean = true;
  movies: Array<MovieDto> = [];

  authorsLoading: boolean = true;
  authors: Array<AuthorDto> = [];

  constructor(private movieService: MovieService, private authorServie: AuthorService) { }

  ngOnInit(): void {
    this.getAllMovies();
    this.getAllAuthor();
  }

  ngOnDestroy(): void {
  }

  getAllMovies(){
    this.movieService.getAllMovies().subscribe({
      next: (movies) => {
        this.movies = movies;
        this.movieLoading = false;
      },
      error: (error) => {
        console.log(error);
      },
   })
  }

  getAllAuthor(){
    this.authorServie.getAllAuthors().subscribe({
      next: (author) => {
        this.authors = author;
        this.authorsLoading = false;
      },
      error: (error) => {
        console.log(error);
      },
   })
  }
}
