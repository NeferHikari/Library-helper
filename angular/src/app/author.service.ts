import {Injectable} from '@angular/core';
import {Author} from "./author";
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, of, throwError} from 'rxjs';
const url = "http://localhost:8080/authors";
@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) {
  }
  getAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(`${url}/`)
  }

  get(id:number): Observable<Author> {
    return this.http.get<Author>(`${url}/${id}`)
  }

  delete(id: number): Observable<Author> {
    return this.http.delete<Author>(`${url}/delete/${id}`, this.httpOptions);
}

update(author:Author):Observable<Author>{
    return this.http.put<Author>(`${url}/edit/${author.id}`,author,this.httpOptions)
}

  add(author:Author):Observable<Author>{
    return this.http.post<Author>(`${url}/add`,author,this.httpOptions)
  }
}
