import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { CommentDto } from '../models/comment.model';
@Injectable({
  providedIn: 'root',
})
export class CommentService {

  constructor(private http: HttpClient) { }

  getCommentByMovieId(id:number):Observable<Array<CommentDto>>{
    return this.http.get<Array<CommentDto>>("http://localhost:8080/comment/"+id);
  }

  createComment(commentDto:CommentDto):Observable<CommentDto>{
    return this.http.post<CommentDto>("http://localhost:8080/comment/create",commentDto);
  }

  createCommentByName(commentDto:CommentDto):Observable<CommentDto>{
    return this.http.post<CommentDto>("http://localhost:8080/comment/createByName",commentDto);
  }
}
