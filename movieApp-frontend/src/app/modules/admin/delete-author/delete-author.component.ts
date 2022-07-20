import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { MovieDto } from 'src/app/core/models/movie.model';
import { AuthorService } from 'src/app/core/services/author.service';
import { MovieService } from 'src/app/core/services/movie.service';

@Component({
  selector: 'app-delete-author',
  templateUrl: './delete-author.component.html',
  styleUrls: ['./delete-author.component.scss']
})
export class DeleteAuthorComponent implements OnInit {
  selectedAuthorId: number;
  authors: Array<AuthorDto>;

  constructor(
    private authorService: AuthorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authorService.getAllAuthors().subscribe({
      next: (authors) => {
        this.authors = authors;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  deleteAuthor(){
    this.authorService.deleteAuthor(this.selectedAuthorId).subscribe({
      next: () => {
        this.router.navigateByUrl('');
      },
      error: (e) => {
        console.log(e);
      },
    });
  }
}
