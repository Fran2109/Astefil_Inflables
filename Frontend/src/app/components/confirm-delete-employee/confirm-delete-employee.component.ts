import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-confirm-delete-employee',
  templateUrl: './confirm-delete-employee.component.html',
  styleUrl: './confirm-delete-employee.component.css'
})
export class ConfirmDeleteEmployeeComponent {
  constructor(
    private dialogRef: MatDialogRef<ConfirmDeleteEmployeeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { employee: any },
    private userService: UserService
  ) { }

  onConfirm(): void {
    this.userService.deleteUser(this.data.employee.id).subscribe(() => {
      this.dialogRef.close(true);
    });
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}
