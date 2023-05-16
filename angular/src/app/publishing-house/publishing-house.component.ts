import {Component, OnInit} from '@angular/core';
import {PublishingHouse} from "../publishing-house";
import {PublishingHouseService} from "../publishing-house.service";
import {Author} from "../author";
import {Router} from "@angular/router";

@Component({
  selector: 'app-publishing-house',
  templateUrl: './publishing-house.component.html',
  styleUrls: ['./publishing-house.component.css']
})
export class PublishingHouseComponent  implements OnInit {
  publishingHouses:PublishingHouse[]=[];
  ngOnInit(): void {
    this.getAll();
  }
  constructor(private publishingHouseService: PublishingHouseService,
              private router: Router) { }
  getAll():void{
    this.publishingHouseService.getAll()
      .subscribe(data=> {
        this.publishingHouses = data;
      });}

  edit(house:PublishingHouse):void{
    let id=parseInt(house.id);
    this.router.navigateByUrl(`publishingHouseDetails/${id}`);
  }
  delete(house: PublishingHouse): void {
    let id=parseInt(house.id);
    this.publishingHouseService.delete(id).subscribe();
    this.getAll();
  }
}
