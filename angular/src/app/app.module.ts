import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AuthorComponent } from './author/author.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookComponent } from './book/book.component';
import { CategoryComponent } from './category/category.component';
import { CopyComponent } from './copy/copy.component';
import { PublishingHouseComponent } from './publishing-house/publishing-house.component';
import { ReaderComponent } from './reader/reader.component';
import { RentComponent } from './rent/rent.component';
import {AppRoutingModule} from "./app-routing.module";
import { AuthorDetailsComponent } from './author-details/author-details.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { CategoryDetailsComponent } from './category-details/category-details.component';
import { CopyDetailsComponent } from './copy-details/copy-details.component';
import { PublishingHouseDetailsComponent } from './publishing-house-details/publishing-house-details.component';
import { ReaderDetailsComponent } from './reader-details/reader-details.component';
import { RentDetailsComponent } from './rent-details/rent-details.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    BookComponent,
    CategoryComponent,
    CopyComponent,
    PublishingHouseComponent,
    ReaderComponent,
    RentComponent,
    AuthorDetailsComponent,
    BookDetailsComponent,
    CategoryDetailsComponent,
    CopyDetailsComponent,
    PublishingHouseDetailsComponent,
    ReaderDetailsComponent,
    RentDetailsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
