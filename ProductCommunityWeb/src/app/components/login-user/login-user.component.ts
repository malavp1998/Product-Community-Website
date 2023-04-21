import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  userObj: any = {
    email: '',
    password: ''
  }

  res: any = {
    data: {},
    status: true
  };
  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  authUser() {

    this.authService.authenticateUser(this.userObj).subscribe((res) => {
      this.res = res;
      if (this.res.status == true) {
        this.router.navigate(['user', this.res.data.firstName]).then(() => {

          window.location.reload();

        })
        Swal.fire({

          icon: 'success',

          title: 'Login Successful',

          showConfirmButton: true,

          timer: 12000
        })

      }

      else {

        Swal.fire({

          icon: 'error',

          title: 'User not Found',

          text: 'Username/Password is wrong',

          showConfirmButton: true

        })

      }

    });
  }

  loginForm = new FormGroup({

    username: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(15)]),

    password: new FormControl('', [Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}'),

    Validators.minLength(8)])

  })



}
