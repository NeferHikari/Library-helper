import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "./book";
const url = "http://localhost:8080/books";
@Injectable({
  providedIn: 'root'
})
export class BookService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAll(): Observable<Book[]> {
    return this.http.get<Book[]>(`${url}/`)
  }

  get(id: number): Observable<Book> {
    return this.http.get<Book>(`${url}/${id}`)
  }

  delete(id: number): Observable<Book> {
    return this.http.delete<Book>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(book: Book): Observable<Book> {
    return this.http.put<Book>(`${url}/edit/${book.id}`, book, this.httpOptions)
  }

  add(book: Book): Observable<Book> {

    return this.http.post<Book>(`${url}/add`, book, this.httpOptions)
  }
}

