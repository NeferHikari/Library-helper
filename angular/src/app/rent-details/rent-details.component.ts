import {Component, Input, OnInit} from '@angular/core';
import {Rent} from "../rent";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {RentService} from "../rent.service";
import {Copy} from "../copy";
import {Reader} from "../reader";
import {Book} from "../book";
import {ReaderService} from "../reader.service";
import {CopyService} from "../copy.service";

@Component({
  selector: 'app-rent-details',
  templateUrl: './rent-details.component.html',
  styleUrls: ['./rent-details.component.css']
})
export class RentDetailsComponent  implements OnInit {
  @Input() rent?: Rent;
  copies: Copy[] = [];
  copy?:Copy;
  readers: Reader[] = [];
  reader?:Reader;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.rentService.get(id)
      .subscribe(rent => this.rent = rent);
    this.readerService.getAll()
      .subscribe(data=> {this.readers= data;});
    this.copyService.getAll()
      .subscribe(data=> {this.copies = data;});
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private rentService: RentService,
    private readerService: ReaderService,
    private copyService: CopyService) {
  }

  edit(): void {
    let id = this.rent?.id
    let copy=this.rent?.copy;
    let reader =this.rent?.reader;
    let returnExpectedDate =this.rent?.returnExpectedDate;
    let returnDate =this.rent?.returnDate;
    let rentalDate =this.rent?.rentalDate;
    this.rentService.update({id,rentalDate,returnDate,returnExpectedDate,copy,reader} as Rent).subscribe();
    this.goBack();
  }

  add(rentalDate:string,returnDate:string,returnExpectedDate:string): void {
    rentalDate = rentalDate.trim();
    returnDate = returnDate.trim();
    returnExpectedDate = returnExpectedDate.trim();
    let copy=this.copy;
    let reader=this.reader;
    this.rentService.add({rentalDate,returnDate,returnExpectedDate,copy,reader} as Rent)
      .subscribe();
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }
  selectCopy(id: string) {
    let bookId=parseInt(id);
    this.copyService.get(bookId).subscribe(data => this.copy = data);
  }
  selectReader(id: string) {
    let bookId=parseInt(id);
    this.readerService.get(bookId).subscribe(data => this.reader = data);
  }

}
