import {Component, Input, OnInit} from '@angular/core';
import {PublishingHouse} from "../publishing-house";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {PublishingHouseService} from "../publishing-house.service";

@Component({
  selector: 'app-publishing-house-details',
  templateUrl: './publishing-house-details.component.html',
  styleUrls: ['./publishing-house-details.component.css']
})
export class PublishingHouseDetailsComponent implements OnInit {
  @Input() publishingHouse?: PublishingHouse;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.publishingHouseService.get(id)
      .subscribe(publishingHouse => this.publishingHouse = publishingHouse);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private publishingHouseService: PublishingHouseService) {
  }

  edit(): void {
    let name=this.publishingHouse?.name;
    let id = this.publishingHouse?.id;
    let address=this.publishingHouse?.address
    this.publishingHouseService.update({id,name,address} as PublishingHouse).subscribe();
    this.goBack();
  }

  add(name: string,address: string): void {
    name = name.trim();
    address = address.trim();
    this.publishingHouseService.add({ name,address } as PublishingHouse)
      .subscribe();
    this.goBack();
  }
  goBack(): void {
    this.location.back();
  }

}
