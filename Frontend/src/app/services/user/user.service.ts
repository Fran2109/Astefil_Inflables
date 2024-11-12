import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private apiService: ApiService) { }

  getAllEmployes(): Observable<User[]> {
    return this.apiService.getAllEmployes();
  }

  deleteUser(id: number): Observable<any> {
    return this.apiService.deleteUser(id);
  }

  postEmployee(username: string, password: string): Observable<User> {
    return this.apiService.postEmployee(username, password);
  }

  putEmployee(id: number, username: string, password: string) {
    return this.apiService.putEmployee(id, username, password);
  }
}