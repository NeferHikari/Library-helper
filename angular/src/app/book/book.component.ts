import {Component, OnInit} from '@angular/core';
import {Book} from "../book";
import {BookService} from "../book.service";
import {Author} from "../author";
import {Router} from "@angular/router";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: Book[] = [];

  ngOnInit(): void {
    this.getAll();
  }

  constructor(private bookService: BookService, private router: Router) {
  }

  getAll(): void {
    this.bookService.getAll()
      .subscribe(data => {
        this.books = data;
      });
  }

  edit(book: Book): void {
    let id = parseInt(book.id);
    this.router.navigateByUrl(`bookDetails/${id}`);
  }

  delete(book: Book): void {
    let id = parseInt(book.id);
    this.bookService.delete(id).subscribe();
    this.getAll();
  }
}
