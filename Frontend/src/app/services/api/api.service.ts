import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/Article';
import { Category } from 'src/app/models/Category';
import { ResponseLoginDTO } from 'src/app/models/ResponseLoginDTO';
import { User } from 'src/app/models/User';
import { UserQuery } from 'src/app/models/UserQuery';
import { Zone } from 'src/app/models/Zone';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  _baseUrl: string = "http://localhost:8081/api/";
  constructor(private http: HttpClient) { }

  getOrderedCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this._baseUrl + "category/order");
  }

  addCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(this._baseUrl + 'category', category);
  }

  deleteCategory(id: number): Observable<void> {
    return this.http.delete<void>(this._baseUrl + 'category/' + id);
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

  updateCategory(category: Category): Observable<Category> {
    return this.http.put<Category>(this._baseUrl + 'category/' + category.id, category);
  }

  incrementCategoryOrder(id: number): Observable<Category> {
    return this.http.put(
      this._baseUrl + "category/" + id + "/incrementOrderNumber",
      {}
    );
  }

  decrementCategoryOrder(id: number): Observable<Category> {
    return this.http.put(
      this._baseUrl + "category/" + id + "/decrementOrderNumber",
      {}
    );
  }

  addArticle(articleData: FormData): Observable<Article> {
    return this.http.post<Article>(`${this._baseUrl}article`, articleData);
  }

  deleteArticle(articleId: number): Observable<void> {
    return this.http.delete<void>(`${this._baseUrl}article/${articleId}`);
  }

  updateArticle(articleId: number, articleData: Article): Observable<Article> {
    return this.http.put<Article>(`${this._baseUrl}article/${articleId}`, articleData);
  }

  getToken(): string | null {
    return localStorage.getItem("token") || null;
  }

  getAuthHeader(): object {
    return { headers: { Authorization: "Bearer " + this.getToken() } };
  }

  login(username: string, password: string): Observable<ResponseLoginDTO> {
    return this.http.post<ResponseLoginDTO>(this._baseUrl + "auth/login", {
      username: username,
      password: password,
    });
  }

  getUserInfo(): Observable<User> {
    return this.http.get<User>(this._baseUrl + "user", this.getAuthHeader());
  }

  getAllZones(): Observable<Zone[]> {
    return this.http.get<Zone[]>(this._baseUrl + "zone");
  }

  createZone(zoneData: Zone): Observable<Zone> {
    return this.http.post<Zone>(this._baseUrl + "zone", zoneData);
  }

  deleteZone(zoneId: number): Observable<void> {
    return this.http.delete<void>(this._baseUrl + "zone/" + zoneId);
  }

  updateZone(zoneId: number, zoneData: Zone): Observable<Zone> {
    return this.http.put<Zone>(this._baseUrl + "zone/" + zoneId, zoneData);
  }

  sendContactQuery(userQuery: UserQuery): Observable<UserQuery> {
    return this.http.post<UserQuery>(this._baseUrl + "user_query", userQuery);
  }

  getUserQuerys(): Observable<UserQuery[]> {
    return this.http.get<UserQuery[]>(this._baseUrl + "user_query");
  }

  replyToConsultation(consultationId: number): Observable<void> {
    return this.http.put<void>(
      this._baseUrl + "user_query/" + consultationId + "/answer",
      {},
      this.getAuthHeader()
    );
  }

  getAllEmployes(): Observable<User[]> {
    return this.http.get<User[]>(
      this._baseUrl + "admin/employee",
      this.getAuthHeader()
    );
  }

  postEmployee(username: string, password: string): Observable<User> {
    return this.http.post<User>(
      this._baseUrl + "admin/employee",
      { username, password },
      this.getAuthHeader()
    );
  }

  putEmployee(
    id: number,
    username: string,
    password: string
  ): Observable<User> {
    return this.http.put<User>(
      this._baseUrl + `admin/employee/${id}`,
      { username, password },
      this.getAuthHeader()
    );
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(
      this._baseUrl + `admin/employee/${id}`,
      this.getAuthHeader()
    );
  }
}
