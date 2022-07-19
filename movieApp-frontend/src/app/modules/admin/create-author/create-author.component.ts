import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { AuthorService } from 'src/app/core/services/author.service';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.scss'],
})
export class CreateAuthorComponent implements OnInit {
  newAuthor = new AuthorDto();

  constructor(private authorService: AuthorService, private router: Router) {}

  ngOnInit(): void {}

  createAuthor() {
    this.newAuthor.image =
      'person' + Math.floor(Math.random() * 4 + 1) + '.jpg';

    this.authorService.createAuthor(this.newAuthor).subscribe({
      next: (author) => {
        this.router.navigateByUrl('');
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  printAuthor() {}
}
