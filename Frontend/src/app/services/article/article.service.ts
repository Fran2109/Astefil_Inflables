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

  returnFirstImage(article: Article): String {
    if (article && article.id && article.images && article.images.length > 0) {
      if (article.id !== undefined && article.images[0].id !== undefined) {
        return this.apiService.getImage(article.id, article.images[0].id, article.images[0].name || '');
      }
      return "assets/images/no-image.jpg";
    }
    return "assets/images/no-image.jpg";
  }
}
