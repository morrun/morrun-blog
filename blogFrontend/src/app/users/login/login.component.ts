import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../shared/services/auth/auth.service';
import {User} from '../../shared/models/user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  err = false;
  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    this.authService.userSubject.subscribe( res => {
      if (!this.authService.way) {
        this.router.navigate(['/blogs',1]).then();
      }
    });
  }
  onSubmit(value) {
    this.authService.login(value as User)
      .subscribe(res => {
        if (res.success) {
          // console.log(res.user.authorities[0].type);
          this.router.navigate(['/blogs',1]).then( () => {
          });
        } else {
          this.err = true;
        }
      });
  }
  updateErr() {
    if (this.err) {
      this.err = false;
    }
  }
}
