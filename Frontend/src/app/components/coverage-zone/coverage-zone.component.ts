import { Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import { ZoneService } from 'src/app/services/zone/zone.service';
import { CreateZoneComponent } from '../create-zone/create-zone.component';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDeleteZoneComponent } from '../confirm-delete-zone/confirm-delete-zone.component';

@Component({
  selector: 'app-coverage-zone',
  templateUrl: './coverage-zone.component.html',
  styleUrls: ['./coverage-zone.component.css']
})
export class CoverageZoneComponent implements OnInit {
  map!: L.Map;
  zones: any[] = [];

  constructor(private dialog: MatDialog, private zoneService: ZoneService) { }

  ngOnInit(): void {
    this.initializeMap();
    this.loadZones();
  }

  initializeMap(): void {
    this.map = L.map('map').setView([-34.47102820314736, -58.759375465040044], 12);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
    }).addTo(this.map);
  }

  loadZones(): void {
    this.zoneService.getZones().subscribe(zones => {
      this.zones = zones;
      this.addMarkers();
    });
  }

  addMarkers(): void {
    this.zones.forEach(zone => {
      const marker = L.marker([zone.latitude, zone.longitude]).addTo(this.map);
      marker.bindPopup(`<b>${zone.name}</b>`);
    });
  }

  openCreateZoneModal(): void {
    const dialogRef = this.dialog.open(CreateZoneComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadZones();
      }
    });
  }

  openDeleteZoneModal(zone: any): void {
    const dialogRef = this.dialog.open(ConfirmDeleteZoneComponent, {
      width: '400px',
      data: { zone }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadZones();
      }
    });
  }
}
