import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Copy} from "./copy";

const url = "http://localhost:8080/copies";

@Injectable({
  providedIn: 'root'
})
export class CopyService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient) {
  }

  getAll(): Observable<Copy[]> {
    return this.http.get<Copy[]>(`${url}/`)
  }

  get(id: number): Observable<Copy> {
    return this.http.get<Copy>(`${url}/${id}`)
  }

  delete(id: number): Observable<Copy> {
    return this.http.delete<Copy>(`${url}/delete/${id}`, this.httpOptions);
  }

  update(copy: Copy): Observable<Copy> {
    return this.http.put<Copy>(`${url}/edit/${copy.id}`, copy, this.httpOptions)
  }

  add(copy: Copy): Observable<Copy> {
    return this.http.post<Copy>(`${url}/add`, copy, this.httpOptions)
  }
}
