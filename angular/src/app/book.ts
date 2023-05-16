import {Author} from "./author";
import {Category} from "./category";
import {PublishingHouse} from "./publishing-house";

export interface Book {
  id:string;
  title:string;
  numberOfPages:number;
  dateOfPublication:string;
  author: Author;
  publishingHouse: PublishingHouse;
  category: Category;
}
