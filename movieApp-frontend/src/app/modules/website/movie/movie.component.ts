import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentDto } from 'src/app/core/models/comment.model';
import { MovieDto } from 'src/app/core/models/movie.model';
import { UserDto } from 'src/app/core/models/user.model';
import { CommentService } from 'src/app/core/services/comment.service';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent implements OnInit {
  id: number;
  movie: MovieDto;
  comments: Array<CommentDto>;

  newComment:CommentDto = new CommentDto();
  newUser:UserDto = new UserDto();


  constructor(private route: ActivatedRoute, private movieService: MovieService, private commentService: CommentService) {
    this.id = this.route.snapshot.params['id'];
    this.newComment.user= this.newUser;

  }

  ngOnInit(): void {
    this.getMovieById();
    this.getCommentsByMovieId();
  }

  getMovieById(){
    this.movieService.getMovie(this.id).subscribe({
      next: (movie) => {
        this.movie = movie;
      },
      error: (error) => {
        console.log(error);
      }
    })
  }

  getCommentsByMovieId(){
    this.commentService.getCommentByMovieId(this.id).subscribe({
      next:(comments) =>{
        this.comments = comments;
      },
      error: (error)=>{
        console.log(error);
      }
    })
  }

  sendComment(){

    this.newComment.movie = this.movie;
    console.log(this.newComment);
    this.commentService.createCommentByName(this.newComment).subscribe({
      next:(comment) =>{
        this.comments.push(comment);
      },
      error:(error) =>{
        console.log(error);
      }
    })

  }

}
