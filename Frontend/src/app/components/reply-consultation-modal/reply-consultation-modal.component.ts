import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UserQueryService } from 'src/app/services/user_query/user-query.service';

@Component({
  selector: 'app-reply-consultation-modal',
  templateUrl: './reply-consultation-modal.component.html',
  styleUrls: ['./reply-consultation-modal.component.css']
})
export class ReplyConsultationModalComponent {
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: { consultation: any },
    private dialogRef: MatDialogRef<ReplyConsultationModalComponent>,
    private userQueryService: UserQueryService
  ) { }

  onReply(): void {
    const consultationId = this.data.consultation.id;
    this.userQueryService.replyToConsultation(consultationId).subscribe(() => {
      this.dialogRef.close(true);
    });
  }

  onClose(): void {
    this.dialogRef.close(false);
  }
}
