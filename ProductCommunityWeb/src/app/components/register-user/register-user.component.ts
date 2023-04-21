import { Component, OnInit } from '@angular/core';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  public user = {
    email: '',
    firstName: '',
    lastName: '',
    password: '',
  }

  constructor(private registrationService: RegistrationService) { }
  ngOnInit(): void { }

  registerUser() {
    this.registrationService.registerUser(this.user).subscribe((res) => {
      this.resetUserObj();
    })
  }

  resetUserObj() {
    this.user = {
      email: '',
      firstName: '',
      lastName: '',
      password: '',
    }
  }

}
