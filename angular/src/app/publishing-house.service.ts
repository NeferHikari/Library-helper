import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {PublishingHouse} from "./publishing-house";

const url = "http://localhost:8080/publishingHouses";
@Injectable({
  providedIn: 'root'
})
export class PublishingHouseService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAll(): Observable<PublishingHouse[]> {
    return this.http.get<PublishingHouse[]>(`${url}/`)
}

  get(id: number): Observable<PublishingHouse> {
    return this.http.get<PublishingHouse>(`${url}/${id}`)
  }

  delete(id: number): Observable<PublishingHouse> {
    return this.http.delete<PublishingHouse>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(publishingHouse: PublishingHouse): Observable<PublishingHouse> {
    return this.http.put<PublishingHouse>(`${url}/edit/${publishingHouse.id}`, publishingHouse, this.httpOptions)
  }

  add(publishingHouse: PublishingHouse): Observable<PublishingHouse> {
    return this.http.post<PublishingHouse>(`${url}/add`, publishingHouse, this.httpOptions)
  }
}

