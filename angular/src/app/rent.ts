import {Reader} from "./reader";
import {Copy} from "./copy";

export interface Rent {
  id:string;
  rentalDate:string;
  returnDate:string;
  returnExpectedDate:string;
  copy:Copy;
  reader:Reader;
}
