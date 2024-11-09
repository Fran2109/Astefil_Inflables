import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/Article';
import { Category } from 'src/app/models/Category';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  _baseUrl: string = "http://localhost:8081/api/";
  constructor(private http: HttpClient) { }

  getOrderedCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this._baseUrl + "category/order");
  }

  getAllArticles(): Observable<Article[]> {
    return this.http.get<any[]>(this._baseUrl + "article");
  }

  getAllArticlesByCategoryId(id: Number): Observable<Article[]> {
    return this.http.get<any>(this._baseUrl + "article/category/" + id);
  }

  getArticleById(id: Number): Observable<Article[]> {
    return this.http.get<any>(this._baseUrl + "article/" + id);
  }

  getRelatedArticles(currentArticleId: number): Observable<Article[]> {
    return this.http.get<any>(this._baseUrl + "article/related/" + currentArticleId);
  }

  getImage(id: Number, imageId: Number, imageName: string): String {
    return this._baseUrl + "image/" + id + "/" + imageId + "_" + imageName
  }
}
