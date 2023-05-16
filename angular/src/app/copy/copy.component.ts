import {Component, OnInit} from '@angular/core';
import {Copy} from "../copy";
import {CopyService} from "../copy.service";
import {Author} from "../author";
import {Router} from "@angular/router";

@Component({
  selector: 'app-copy',
  templateUrl: './copy.component.html',
  styleUrls: ['./copy.component.css']
})
export class CopyComponent implements OnInit {
  copies: Copy[] = [];

  ngOnInit(): void {
    this.getAll();
  }

  constructor(private copyService: CopyService, private router: Router) {
  }

  getAll(): void {
    this.copyService.getAll()
      .subscribe(data => {
        this.copies = data;
      });
  }

  edit(copy: Copy): void {
    let id = parseInt(copy.id);
    this.router.navigateByUrl(`authorDetails/${id}`);
  }

  delete(copy: Copy): void {
    let id = parseInt(copy.id);
    this.copyService.delete(id).subscribe();
    this.getAll();
  }
}
