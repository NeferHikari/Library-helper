import {Component, OnInit} from '@angular/core';
import {Reader} from "../reader";
import {ReaderService} from "../reader.service";
import {Author} from "../author";
import {Router} from "@angular/router";
import {Copy} from "../copy";

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.css']
})
export class ReaderComponent  implements OnInit {
  readers:Reader[]=[];
  ngOnInit(): void {
    this.getAll();
  }
  constructor(private readerService: ReaderService,private router: Router) { }
  getAll():void{
    this.readerService.getAll()
      .subscribe(data=> {
        this.readers = data;
      });}

  edit(reader: Reader): void {
    let id = parseInt(reader.id);
    this.router.navigateByUrl(`readerDetails/${id}`);
  }

  delete(reader: Reader): void {
    let id = parseInt(reader.id);
    this.readerService.delete(id).subscribe();
    this.getAll();
  }
}

