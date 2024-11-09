import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ApiService } from '../api/api.service';
import { Category } from 'src/app/models/Category';

@Injectable({
  providedIn: 'root'
})

export class CategoryService {
  constructor(private apiService: ApiService) { }

  getOrderedCategories(): Observable<Category[]> {
    return this.apiService.getOrderedCategories();
  }
}
