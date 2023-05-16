import {Component, OnInit} from '@angular/core';
import {Author} from "../author";
import { AuthorService } from '../author.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  authors :Author[]|undefined;
  ngOnInit(): void {
    this.getAll();
  }
  constructor(private authorService: AuthorService,
              private router: Router) { }
  getAll():void{
    this.authorService.getAuthors()
      .subscribe(data=> {
          this.authors = data;
        });}

  edit(author:Author):void{
    let id = parseInt(author.id);
    this.router.navigateByUrl(`authorDetails/${id}`);
  }
  delete(author: Author): void {
    let id=parseInt(author.id);
    this.authorService.delete(id).subscribe();
    this.getAll();
  }
}
