import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Article } from 'src/app/models/Article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent {
  articleForm: FormGroup;
  images: File[] = [];
  imagePreviews: string[] = [];
  allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];
  invalidFileFormat = false;

  constructor(
    private dialogRef: MatDialogRef<CreateArticleComponent>,
    private fb: FormBuilder,
    private articleService: ArticleService,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.articleForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      height: ['', Validators.required],
      width: ['', Validators.required],
      length: ['', Validators.required],
    });
  }

  onFileChange(event: any): void {
    this.invalidFileFormat = false;
    this.imagePreviews = [];
    this.images = [];
    const files = event.target.files;

    for (let i = 0; i < files.length; i++) {
      const file = files[i];
      const extension = file.name.split('.').pop().toLowerCase();

      if (this.allowedExtensions.includes(extension)) {
        this.images.push(file);

        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.imagePreviews.push(e.target.result);
        };
        reader.readAsDataURL(file);
      } else {
        this.invalidFileFormat = true;
      }
    }
  }

  removeImage(index: number): void {
    this.images.splice(index, 1);
    this.imagePreviews.splice(index, 1);
  }

  onSubmit(): void {
    if (this.articleForm.valid && !this.invalidFileFormat) {
      const formData = new FormData();

      formData.append('name', this.articleForm.value.name);
      formData.append('description', this.articleForm.value.description);
      formData.append('height', this.articleForm.value.height);
      formData.append('width', this.articleForm.value.width);
      formData.append('length', this.articleForm.value.length);
      formData.append('idCategory', this.data.idCategory);

      this.images.forEach((image, index) => {
        formData.append('images', image);
      });

      this.articleService.addArticle(formData).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}