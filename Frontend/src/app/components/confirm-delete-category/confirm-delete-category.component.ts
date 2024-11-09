import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Category } from 'src/app/models/Category';

@Component({
  selector: 'app-confirm-delete-category',
  templateUrl: './confirm-delete-category.component.html',
  styleUrl: './confirm-delete-category.component.css'
})
export class ConfirmDeleteCategoryComponent {
  categoryName: string;

  constructor(
    private dialogRef: MatDialogRef<ConfirmDeleteCategoryComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.categoryName = data.categoryName ?? '';
  }

  onConfirm(): void {
    this.dialogRef.close(true);
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}