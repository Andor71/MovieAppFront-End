import { Component, Input, OnInit } from '@angular/core';
import { AuthorDto } from 'src/app/core/models/author.model';

@Component({
  selector: 'app-author-card',
  templateUrl: './author-card.component.html',
  styleUrls: ['./author-card.component.scss']
})
export class AuthorCardComponent implements OnInit {

  @Input() author: AuthorDto;

  constructor() { }

  ngOnInit(): void {
  }

}
