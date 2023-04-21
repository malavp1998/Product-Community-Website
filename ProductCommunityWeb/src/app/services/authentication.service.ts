import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  authenticateUser(userObj: any) {
    return this.http.post("http://localhost:8080/api/authorize/user", userObj);

  }
  authenticateAdmin(amdinObj: any) {
    return this.http.post("http://localhost:8080/api/authorize/admin", amdinObj);
  }
}
