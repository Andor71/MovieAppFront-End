import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthorDto } from 'src/app/core/models/author.model';
import { AuthorService } from 'src/app/core/services/author.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {

  id: number;
  author: AuthorDto;

  constructor(private route: ActivatedRoute, private authorService: AuthorService) {
    this.id = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.authorService.getAuthor(this.id).subscribe({
      next: (author) => {
        this.author = author;
      }
    })
  }

}
