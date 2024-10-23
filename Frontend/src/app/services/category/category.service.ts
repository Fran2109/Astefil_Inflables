import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private categories = [
    { id: 1, name: 'Acuáticos' },
    { id: 2, name: 'Gigantes' },
    { id: 3, name: 'Castillos' },
    { id: 4, name: 'Juegos' }
  ];

  getCategories(): Observable<any[]> {
    return of(this.categories);
  }
}
