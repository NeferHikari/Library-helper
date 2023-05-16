import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthorComponent} from "./author/author.component";
import {CopyComponent} from "./copy/copy.component";
import {CategoryComponent} from "./category/category.component";
import {BookComponent} from "./book/book.component";
import {PublishingHouseComponent} from "./publishing-house/publishing-house.component";
import {ReaderComponent} from "./reader/reader.component";
import {RentComponent} from "./rent/rent.component";
import {AuthorDetailsComponent} from "./author-details/author-details.component";
import {BookDetailsComponent} from "./book-details/book-details.component";
import {CategoryDetailsComponent} from "./category-details/category-details.component";
import {CopyDetailsComponent} from "./copy-details/copy-details.component";
import {PublishingHouseDetailsComponent} from "./publishing-house-details/publishing-house-details.component";
import {ReaderDetailsComponent} from "./reader-details/reader-details.component";
import {RentDetailsComponent} from "./rent-details/rent-details.component";

const routes: Routes = [{path:'authors',component:AuthorComponent},
  {path:'books',component:BookComponent},
  {path:'categories',component:CategoryComponent},
  {path:'copies',component:CopyComponent},
  {path:'publishingHouses',component:PublishingHouseComponent},
  {path:'readers',component:ReaderComponent},
  {path:'rents',component:RentComponent},
  {path:'authorDetails',component:AuthorDetailsComponent},
  {path:'authorDetails/:id',component:AuthorDetailsComponent},
  {path:'bookDetails',component:BookDetailsComponent},
  {path:'bookDetails/:id',component:BookDetailsComponent},
  {path:'categoryDetails',component:CategoryDetailsComponent},
  {path:'categoryDetails/:id',component:CategoryDetailsComponent},
  {path:'copyDetails',component:CopyDetailsComponent},
  {path:'copyDetails/:id',component:CopyDetailsComponent},
  {path:'publishingHouseDetails',component:PublishingHouseDetailsComponent},
  {path:'publishingHouseDetails/:id',component:PublishingHouseDetailsComponent},
  {path:'readerDetails',component:ReaderDetailsComponent},
  {path:'readerDetails/:id',component:ReaderDetailsComponent},
  {path:'rentDetails',component:RentDetailsComponent},
  {path:'rentDetails/:id',component:RentDetailsComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
