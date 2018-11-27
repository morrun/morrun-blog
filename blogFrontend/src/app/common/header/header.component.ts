import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from '../../shared/services/auth/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  show = false;
  constructor(
    public authService: AuthService,
    private router: Router
  ) { }

  ngOnInit( ) {
    this.authService.userSubject.subscribe( res => {
      if (res) {
        this.show = true;
      }
    });
  }
  logout() {
    this.authService.logout()
      .subscribe((res: {success: true}) => {
        if (res.success) {
          this.router.navigate(['/blogss']);
          this.authService.userSubject.next(null);
        }
      });
    this.show = false;
  }
  ngOnDestroy() {

  }
}
