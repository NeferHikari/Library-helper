import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "./category";
const url = "http://localhost:8080/categories";
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(`${url}/`)
}
  get(id:number): Observable<Category> {
    return this.http.get<Category>(`${url}/${id}`)
  }

  delete(id: number): Observable<Category> {
    return this.http.delete<Category>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(category:Category):Observable<Category>{
    return this.http.put<Category>(`${url}/edit/${category.id}`,category,this.httpOptions)
  }

  add(category:Category):Observable<Category>{
    return this.http.post<Category>(`${url}/add`,category,this.httpOptions)
  }
}
