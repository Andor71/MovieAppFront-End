import { Component, Input, OnInit } from '@angular/core';
import { MovieDto } from 'src/app/core/models/movie.model';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.scss']
})
export class MovieCardComponent implements OnInit {
  @Input() movie: MovieDto;

  constructor() { }

  ngOnInit(): void {
  }

}
