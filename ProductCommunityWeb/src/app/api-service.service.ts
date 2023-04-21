import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  url = "http://localhost:8081"

  constructor(private http: HttpClient) { }

  public addUser(user: any) {
    return this.http.post(`${this.url}/user/`, user);
  }
}
