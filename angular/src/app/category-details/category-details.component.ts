import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../category";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {CategoryService} from "../category.service";

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit{
  @Input() category?: Category;

  ngOnInit() {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.categoryService.get(id)
      .subscribe(category => this.category = category);
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private categoryService: CategoryService) {
  }

  edit(): void {
    let name=this.category?.name;
    let id = this.category?.id;
    this.categoryService.update({id,name} as Category).subscribe();
    this.goBack();
  }

  add(name: string): void {
    name = name.trim();
    this.categoryService.add({ name } as Category)
      .subscribe();
    this.goBack();
  }
  goBack(): void {
    this.location.back();
  }

}
