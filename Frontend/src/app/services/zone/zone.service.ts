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

  createZone(zoneData: Zone): Observable<Zone> {
    return this.apiService.createZone(zoneData);
  }

  deleteZone(zoneId: number): Observable<void> {
    return this.apiService.deleteZone(zoneId);
  }

  updateZone(zoneId: number, zoneData: Zone): Observable<Zone> {
    return this.apiService.updateZone(zoneId, zoneData);
  }

}
