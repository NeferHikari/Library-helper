import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reader} from "./reader";

const url = "http://localhost:8080/readers";
@Injectable({
  providedIn: 'root'
})
export class ReaderService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAll(): Observable<Reader[]> {
    return this.http.get<Reader[]>(`${url}/`)
}

  get(id: number): Observable<Reader> {
    return this.http.get<Reader>(`${url}/${id}`)
  }

  delete(id: number): Observable<Reader> {
    return this.http.delete<Reader>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(reader: Reader): Observable<Reader> {
    return this.http.put<Reader>(`${url}/edit/${reader.id}`, reader, this.httpOptions)
  }

  add(reader: Reader): Observable<Reader> {
    return this.http.post<Reader>(`${url}/add`, reader, this.httpOptions)
  }
}


