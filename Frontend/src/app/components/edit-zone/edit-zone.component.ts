import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ZoneService } from 'src/app/services/zone/zone.service';

@Component({
  selector: 'app-edit-zone',
  templateUrl: './edit-zone.component.html',
  styleUrls: ['./edit-zone.component.css']
})
export class EditZoneComponent implements OnInit {
  zoneForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<EditZoneComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { zone: any },
    private zoneService: ZoneService
  ) {
    this.zoneForm = this.fb.group({
      name: ['', Validators.required],
      latitude: ['', [Validators.required, Validators.pattern(/^-?\d+(\.\d+)?$/)]],
      longitude: ['', [Validators.required, Validators.pattern(/^-?\d+(\.\d+)?$/)]]
    });
  }

  ngOnInit(): void {
    this.zoneForm.patchValue({
      name: this.data.zone.name,
      latitude: this.data.zone.latitude,
      longitude: this.data.zone.longitude
    });
  }

  onSubmit(): void {
    if (this.zoneForm.valid) {
      this.zoneService.updateZone(this.data.zone.id, this.zoneForm.value).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onClose(): void {
    this.dialogRef.close(false);
  }
}
