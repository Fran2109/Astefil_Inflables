import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrl: './edit-employee.component.css'
})
export class EditEmployeeComponent {
  editEmployeeForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<EditEmployeeComponent>,
    private userService: UserService,
    @Inject(MAT_DIALOG_DATA) public data: { employee: any }
  ) {
    this.editEmployeeForm = this.fb.group({
      username: [data.employee.username, [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', Validators.required]
    }, { validators: this.passwordMatchValidator });
  }

  passwordMatchValidator(form: FormGroup) {
    const password = form.get('password')?.value;
    const confirmPassword = form.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { passwordMismatch: true };
  }

  onSubmit(): void {
    if (this.editEmployeeForm.valid) {
      const { username, password } = this.editEmployeeForm.value;
      this.userService.putEmployee(this.data.employee.id, username, password).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onClose(): void {
    this.dialogRef.close(false);
  }
}
