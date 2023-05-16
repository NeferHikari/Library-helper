import {Component, Input, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {Author} from "../author";
import {AuthorService} from "../author.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.css']
})
export class AuthorDetailsComponent implements OnInit {
  @Input() author?: Author;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.authorService.get(id)
      .subscribe(author => this.author = author);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private authorService: AuthorService) {
  }

  edit(): void {
    let id = this.author?.id
    let name=this.author?.name
    let surname=this.author?.surname;
    this.authorService.update({id,name,surname} as Author).subscribe();
    this.goBack();
  }

  add(name: string,surname: string): void {
    name = name.trim();
    surname = surname.trim();
    this.authorService.add({ name,surname } as Author)
      .subscribe();
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }

}
