import {Component, OnInit} from '@angular/core';
import {Category} from "../category";
import {CategoryService} from "../category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent  implements OnInit{
  categories:Category[]=[];
  ngOnInit(): void {
    this.getAll();
  }
  constructor(private categoryService: CategoryService,private router: Router) { }
  getAll():void{
    this.categoryService.getAll()
      .subscribe(data=> {
        this.categories = data;
      });}


  edit(category:Category):void{
    let id=parseInt(category.id);
    this.router.navigateByUrl(`categoryDetails/${id}`);
  }
  delete(category: Category): void {
    let id=parseInt(category.id);
    this.categoryService.delete(id).subscribe();
    this.getAll();
  }
}
