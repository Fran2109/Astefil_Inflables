import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ZoneService } from 'src/app/services/zone/zone.service';

@Component({
  selector: 'app-confirm-delete-zone',
  templateUrl: './confirm-delete-zone.component.html',
  styleUrl: './confirm-delete-zone.component.css'
})
export class ConfirmDeleteZoneComponent {
  constructor(
    private dialogRef: MatDialogRef<ConfirmDeleteZoneComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { zone: any },
    private zoneService: ZoneService
  ) { }

  onConfirm(): void {
    this.zoneService.deleteZone(this.data.zone.id).subscribe(() => {
      this.dialogRef.close(true);
    });
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}
