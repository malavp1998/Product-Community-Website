import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getUserCount() {
    return this.http.get("http://localhost:8080/api/register/user/count");
  }
}
