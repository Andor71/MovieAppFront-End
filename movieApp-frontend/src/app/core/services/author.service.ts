import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { MovieDto } from '../models/movie.model';
import { Observable } from 'rxjs';
import { AuthorDto } from '../models/author.model';
@Injectable({
  providedIn: 'root',
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  getAllAuthors(): Observable<Array<AuthorDto>> {
    return this.http.get<Array<AuthorDto>>("http://localhost:8080/author/get-all");
  }

  getAuthor(id: number): Observable<AuthorDto> {
    return this.http.get<AuthorDto>("http://localhost:8080/author/" + id);
  }

  createAuthor(authorDto: AuthorDto): Observable<AuthorDto> {
    return this.http.post<AuthorDto>("http://localhost:8080/author/create", authorDto);
  }
}