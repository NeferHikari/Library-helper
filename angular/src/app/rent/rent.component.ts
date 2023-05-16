import {Component, OnInit} from '@angular/core';
import {Rent} from "../rent";
import {RentService} from "../rent.service";
import {Copy} from "../copy";
import {Router} from "@angular/router";

@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})
export class RentComponent  implements OnInit{
  rents:Rent[]=[];
  ngOnInit(): void {
    this.getAll();
  }
  constructor(private rentService: RentService, private router: Router) { }
  getAll():void{
    this.rentService.getAll()
      .subscribe(data=> {
        this.rents = data;
      });}

  edit(rent: Rent): void {
    let id = parseInt(rent.id);
    this.router.navigateByUrl(`rentDetails/${id}`);
  }

  delete(rent: Rent): void {
    let id = parseInt(rent.id);
    this.rentService.delete(id).subscribe();
    this.getAll();
  }
}
