import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { MovieDto } from '../models/movie.model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class MovieService {

  constructor(private http: HttpClient) { }

  getAllMovies(): Observable<Array<MovieDto>>{
    return this.http.get<Array<MovieDto>>("http://localhost:8080/movie/get-all");
  }

  getMovie(id: number): Observable<MovieDto>{
    return this.http.get<MovieDto>("http://localhost:8080/movie/"+id);
  }

  createMovie(movieDto: MovieDto): Observable<MovieDto> {
    return this.http.post<MovieDto>("http://localhost:8080/movie/create", movieDto)
  }

}