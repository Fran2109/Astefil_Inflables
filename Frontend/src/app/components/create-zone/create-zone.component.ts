import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ZoneService } from 'src/app/services/zone/zone.service';

@Component({
  selector: 'app-create-zone',
  templateUrl: './create-zone.component.html',
  styleUrls: ['./create-zone.component.css']
})
export class CreateZoneComponent {
  zoneForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<CreateZoneComponent>,
    private zoneService: ZoneService
  ) {
    this.zoneForm = this.fb.group({
      name: ['', Validators.required],
      latitude: ['', [Validators.required, Validators.pattern(/^-?\d+(\.\d+)?$/)]],
      longitude: ['', [Validators.required, Validators.pattern(/^-?\d+(\.\d+)?$/)]]
    });
  }

  onSubmit(): void {
    if (this.zoneForm.valid) {
      const newZone = this.zoneForm.value;
      this.zoneService.createZone(newZone).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onClose(): void {
    this.dialogRef.close(false);
  }
}
