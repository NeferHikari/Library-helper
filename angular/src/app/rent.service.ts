import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rent} from "./rent";

const url = "http://localhost:8080/rents";

@Injectable({
  providedIn: 'root'
})
export class RentService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAll(): Observable<Rent[]> {
    return this.http.get<Rent[]>(`${url}/`)
}

  get(id: number): Observable<Rent> {
    return this.http.get<Rent>(`${url}/${id}`)
  }

  delete(id: number): Observable<Rent> {
    return this.http.delete<Rent>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(rent: Rent): Observable<Rent> {
    return this.http.put<Rent>(`${url}/edit/${rent.id}`, rent, this.httpOptions)
  }

  add(rent: Rent): Observable<Rent> {
    return this.http.post<Rent>(`${url}/add`, rent, this.httpOptions)
  }
}

