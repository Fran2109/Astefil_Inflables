import { Injectable } from '@angular/core';
import { Article } from 'src/app/models/Article';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(
    private apiService: ApiService
  ) { }

  getAllArticles(): Observable<Article[]> {
    return this.apiService.getAllArticles();
  }

  getAllArticlesByCategoryId(id: Number): Observable<Article[]> {
    return this.apiService.getAllArticlesByCategoryId(id);
  }

  getArticleById(id: Number): Observable<Article> {
    return this.apiService.getArticleById(id);
  }

  getImage(id: Number, imageId: Number, imageName: string): String {
    return this.apiService.getImage(id, imageId, imageName);
  }

  getRelatedArticles(currentArticleId: number): Observable<Article[]> {
    return this.apiService.getRelatedArticles(currentArticleId);
  }


}
