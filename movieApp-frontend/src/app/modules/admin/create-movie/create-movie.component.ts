import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { MovieDto } from 'src/app/core/models/movie.model';
import { AuthorService } from 'src/app/core/services/author.service';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.scss'],
})
export class CreateMovieComponent implements OnInit {
  selectedAuthorId: number;
  authors: Array<AuthorDto>;
  newMovie: MovieDto = new MovieDto();

  constructor(
    private authorService: AuthorService,
    private movieService: MovieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authorService.getAllAuthors().subscribe({
      next: (authors) => {
        this.authors = authors;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  createMovie() {
    this.newMovie.image = 'movie1.jpg';

    this.newMovie.authorDto = this.authors.filter(
      (author) => author.id == this.selectedAuthorId
    )[0];
    this.movieService.createMovie(this.newMovie).subscribe({
      next: (movie) => {
        this.router.navigateByUrl('');
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  printMovie() {}
}
