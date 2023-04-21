import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  registerUser(userObj: any) {
    return this.http.post("http://localhost:8080/api/register/user", userObj);
  }
  registerAdmin(amdinObj: any) {
    return this.http.post("http://localhost:8080/api/register/admin", amdinObj);
  }

}

