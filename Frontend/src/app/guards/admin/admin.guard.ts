import { inject } from '@angular/core';
import { CanActivateFn, RouteConfigLoadEnd, Router } from '@angular/router';
import { Observable, catchError, map, of, retry, tap } from 'rxjs';
import { AuthService } from 'src/app/services/auth/auth.service';

export const adminGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.getUserInfo().pipe(
    map((user) => {
      if (!user) {
        router.navigate(["/login"]);
        return false;
      }
      if (user.role?.name !== "ADMIN" && user.role?.name !== "EMPLOYEE") {
        router.navigate(["/login"]);
        return false;
      }
      return true;
    }),
    catchError(() => {
      router.navigate(["/login"]);
      return of(false);
    })
  )
}