import { Component, Input, OnInit } from '@angular/core';
import { CommentDto } from 'src/app/core/models/comment.model';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {

  @Input() comment: CommentDto;
  constructor() { }

  ngOnInit(): void {
  }

}
