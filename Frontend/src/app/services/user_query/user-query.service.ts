import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { UserQuery } from 'src/app/models/UserQuery';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserQueryService {
  constructor(private apiService: ApiService) { }

  sendContactQuery(query: UserQuery): Observable<UserQuery> {
    return this.apiService.sendContactQuery(query);
  }

  getUserQuerys(): Observable<UserQuery[]> {
    return this.apiService.getUserQuerys();
  }

  replyToConsultation(consultationId: number): Observable<void> {
    return this.apiService.replyToConsultation(consultationId);
  }
}
