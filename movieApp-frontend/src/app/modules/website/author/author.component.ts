import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { MovieDto } from 'src/app/core/models/movie.model';
import { AuthorService } from 'src/app/core/services/author.service';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {


  id: number;
  author: AuthorDto;
  movies: Array<MovieDto>

  constructor(private route: ActivatedRoute, private authorService: AuthorService, private movieService:MovieService) {
    this.id = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getAuthor();
  }

  getAuthor(){
    this.authorService.getAuthor(this.id).subscribe({
      next: (author) => {
        this.author = author;
        this.getMoviesByAuthorId();

      },
      error: (error)=>{
        console.log(error);
      }
    })
  }
  getMoviesByAuthorId(){
    this.movieService.getMoviesByAuthorId(this.author.id).subscribe({
      next:(movies) =>{
        this.movies = movies
        console.log(this.movies);

      }
      ,
      error:(error) =>{
        console.log(error);
      }
    })
  }
}
