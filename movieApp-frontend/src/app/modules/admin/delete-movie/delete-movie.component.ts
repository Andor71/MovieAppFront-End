import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { MovieDto } from 'src/app/core/models/movie.model';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-delete-movie',
  templateUrl: './delete-movie.component.html',
  styleUrls: ['./delete-movie.component.scss']
})
export class DeleteMovieComponent implements OnInit {

  movies: Array<MovieDto>;
  selectedMovieId: number;

  constructor(private router:Router,private movieService:MovieService) { }

  ngOnInit(): void {
    this.movieService.getAllMovies().subscribe({
      next:(movies) =>{
        console.log(movies);

        this.movies = movies;
      },
      error:(e)=>{
        console.log(e);

      }
    })
  }
  deleteMovie(){
    console.log("delete")
    this.movieService.deleteMovie(this.selectedMovieId).subscribe({
      error: (e) =>{
        console.log(e);
      }
    }
    );
    this.router.navigateByUrl('');
  }
}
