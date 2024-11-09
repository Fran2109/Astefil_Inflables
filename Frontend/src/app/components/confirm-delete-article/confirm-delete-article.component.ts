import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-delete-article',
  templateUrl: './confirm-delete-article.component.html',
  styleUrls: ['./confirm-delete-article.component.css']
})
export class ConfirmDeleteArticleComponent {

  constructor(
    private dialogRef: MatDialogRef<ConfirmDeleteArticleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { name: string; description: string }
  ) { }

  onConfirm(): void {
    this.dialogRef.close(true);
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}
