import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { AuthorService } from 'src/app/core/services/author.service';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.scss']
})
export class UpdateAuthorComponent implements OnInit {

  author: AuthorDto;
  authors: Array<AuthorDto>;
  selectedAuthor: AuthorDto;
  authorSelected: boolean;

  constructor(private activeRoute:ActivatedRoute, private router: Router, private authorServie:AuthorService) { }

  ngOnInit(): void {
    this.getAllAuthor();
  }
  getAllAuthor(){
    this.authorServie.getAllAuthors().subscribe({
      next: (authors) => {
        this.authors = authors;
      },
      error: (error) => {
        console.log(error);
      },
   })
  }
  targetSelectedAuthor(){
    console.log(this.selectedAuthor.name);

    this.authorSelected = true;
  }
  updateAuthor(){

  }
}
