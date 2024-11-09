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

  addCategory(category: Category): Observable<Category> {
    return this.apiService.addCategory(category);
  }

  deleteCategory(id: number): Observable<void> {
    return this.apiService.deleteCategory(id);
  }

  updateCategory(category: Category): Observable<Category> {
    return this.apiService.updateCategory(category);
  }

  incrementCategoryOrder(id: number): Observable<Category> {
    return this.apiService.incrementCategoryOrder(id);
  }

  decrementCategoryOrder(id: number): Observable<Category> {
    return this.apiService.decrementCategoryOrder(id);
  }
}
