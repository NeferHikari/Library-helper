import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../book";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {BookService} from "../book.service";
import {Author} from "../author";
import {PublishingHouse} from "../publishing-house";
import {Category} from "../category";
import {AuthorService} from "../author.service";
import {CategoryService} from "../category.service";
import {PublishingHouseService} from "../publishing-house.service";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  @Input() book?: Book;
  authors: Author[] = [];
  houses: PublishingHouse[] = [];
  categories: Category[] = [];
  author?: Author;
  house?: PublishingHouse;
  category?: Category;
  authorId =1;
  categoryId=1;
  houseId=1;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.bookService.get(id)
      .subscribe(book => this.book = book);
    this.authorService.getAuthors()
      .subscribe(data=> {this.authors = data;});
    this.categoryService.getAll()
      .subscribe(data=> {this.categories = data;});
    this.houseService.getAll()
      .subscribe(data=> {this.houses = data;});
    this.authorId=parseInt(this.authors[0].id);
    this.houseId=parseInt(this.houses[0].id);
    this.categoryId=parseInt(this.categories[0].id);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private bookService: BookService,
    private authorService: AuthorService,
    private categoryService: CategoryService,
    private houseService: PublishingHouseService) {
  }

  edit(): void {
    let id = this.book?.id
    let title = this.book?.title
    let numberOfPages = this.book?.numberOfPages;
    let dateOfPublication = this.book?.dateOfPublication;
    this.authorService.get(this.authorId).subscribe(author => {
      this.houseService.get(this.houseId).subscribe(publishingHouse => {
        this.categoryService.get(this.categoryId).subscribe(category => {
          this.bookService.update({id,title, numberOfPages: numberOfPages, dateOfPublication, author, publishingHouse, category} as Book).subscribe();
          this.goBack();
        });
      });
    });
  }

  add(title: string, numberOfPagesStr: string, dateOfPublication: string): void {
    title = title.trim();
    dateOfPublication = dateOfPublication.trim();
    let numberOfPages = parseInt(numberOfPagesStr, 10);

    this.authorService.get(this.authorId).subscribe(author => {
      this.houseService.get(this.houseId).subscribe(publishingHouse => {
        this.categoryService.get(this.categoryId).subscribe(category => {
          this.bookService.add({title, numberOfPages: numberOfPages, dateOfPublication, author, publishingHouse, category} as Book).subscribe();
          this.goBack();
        });
      });
    });
  }


  goBack(): void {
    this.location.back();
  }
  selectAuthor(id: string) {
    this.authorId=parseInt(id);
    this.authorService.get(this.authorId).subscribe(data => this.author = data);
  }
  selectHouse(id: string) {
    this.houseId=parseInt(id);
    this.houseService.get(this.houseId).subscribe(data => this.house = data);
  }
  selectCategory(id: string) {
    this.categoryId=parseInt(id);
    this.categoryService.get(this.categoryId).subscribe(data => this.category = data);
  }
}
