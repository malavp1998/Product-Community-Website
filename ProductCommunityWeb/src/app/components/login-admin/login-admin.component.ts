import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  adminObj: any = {
    email: "",
    password: ""
  }

  res: any = {
    data: {},
    status: false
  };





  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  authAdmin() {
    this.authService.authenticateAdmin(this.adminObj).subscribe((res) => {
      this.res = res;
      if (this.res.status == true) {
        this.router.navigate(['admin', this.res.data.firstName]).then(() => {

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
