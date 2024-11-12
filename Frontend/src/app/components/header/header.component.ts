import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn$: Observable<boolean> | undefined;
  username$: Observable<string> | undefined;
  isAdmin$: Observable<boolean> | undefined;
  isEmployeeOrAdmin$: Observable<boolean> | undefined;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.checkTokenAndSetAuthStatus();
    this.isLoggedIn$ = this.authService.isLoggedIn();
    this.username$ = this.authService.username();
    this.isAdmin$ = this.authService.isAdmin();
    this.isEmployeeOrAdmin$ = this.authService.isEmployeeOrAdmin();
  }

  logout() {
    this.router.navigate(["/"]);
    this.authService.logout();
  }
}
