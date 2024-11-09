import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Category } from 'src/app/models/Category';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.css']
})
export class EditCategoryComponent implements OnInit {
  categoryForm: FormGroup;

  constructor(
    private dialogRef: MatDialogRef<EditCategoryComponent>,
    private fb: FormBuilder,
    private categoryService: CategoryService,
    @Inject(MAT_DIALOG_DATA) public data: { category: Category }
  ) {
    this.categoryForm = this.fb.group({
      name: [data.category.name, Validators.required]
    });
  }

  ngOnInit(): void { }

  onSubmit(): void {
    if (this.categoryForm.valid) {
      const updatedCategory: Category = {
        ...this.data.category,
        name: this.categoryForm.value.name
      };

      this.categoryService.updateCategory(updatedCategory).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}