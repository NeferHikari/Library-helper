import {Component, Input, OnInit} from '@angular/core';
import {Copy} from "../copy";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {CopyService} from "../copy.service";
import {Book} from "../book";
import {Category} from "../category";
import {BookService} from "../book.service";

@Component({
  selector: 'app-copy-details',
  templateUrl: './copy-details.component.html',
  styleUrls: ['./copy-details.component.css']
})
export class CopyDetailsComponent implements OnInit {
  @Input() copy?: Copy;
  states:string[]=["In library","Rented"];
  status: string=this.states[0];
  books: Book[] = [];
  book?:Book;
  bookId:number=1;
  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.copyService.get(id)
      .subscribe(copy => this.copy = copy);
    this.bookService.getAll()
      .subscribe(data=> {this.books = data;});
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private copyService: CopyService,
    private bookService: BookService) {
  }

  edit(): void {
    this.bookService.get(this.bookId).subscribe(data => this.book = data);
    let status=this.copy?.status;
    let id = this.copy?.id;
    let book=this.copy?.book;
    this.copyService.update({id,book,status} as Copy).subscribe();
    this.goBack();
  }

  add(): void {
    this.bookService.get(this.bookId).subscribe(data => this.book = data);
    let book=this.book;
    let status=this.status;
    this.copyService.add({book,status} as Copy)
      .subscribe();
    this.goBack();
  }
  goBack(): void {
    this.location.back();
  }

  selectState(state: string) {
    this.status=state;
  }

  selectBook(id: string) {
    this.bookId=parseInt(id);
    this.bookService.get(this.bookId).subscribe(data => this.book = data);
  }
}
