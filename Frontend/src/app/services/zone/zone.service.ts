import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';
import { Zone } from 'src/app/models/Zone';

@Injectable({
  providedIn: 'root'
})
export class ZoneService {
  constructor(private apiService: ApiService) { }

  getZones(): Observable<Zone[]> {
    return this.apiService.getAllZones();
  }

}
