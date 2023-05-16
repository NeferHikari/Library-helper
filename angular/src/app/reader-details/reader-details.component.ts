import {Component, Input, OnInit} from '@angular/core';
import {Reader} from "../reader";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {ReaderService} from "../reader.service";

@Component({
  selector: 'app-reader-details',
  templateUrl: './reader-details.component.html',
  styleUrls: ['./reader-details.component.css']
})
export class ReaderDetailsComponent  implements OnInit {

  @Input() reader?: Reader;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.readerService.get(id)
      .subscribe(reader => this.reader = reader);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private readerService: ReaderService) {
  }

  edit(): void {
    let id = this.reader?.id
    let name=this.reader?.name
    let surname=this.reader?.surname;
    let email=this.reader?.email;
    this.readerService.update({id,name,surname,email} as Reader).subscribe();
    this.goBack();
  }

  add(name: string,surname: string,email:string): void {
    name = name.trim();
    surname = surname.trim();
    email=email.trim();
    this.readerService.add({ name,surname,email } as Reader)
      .subscribe();
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }

}
