import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Article } from 'src/app/models/Article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrl: './edit-article.component.css'
})
export class EditArticleComponent implements OnInit {
  editArticleForm: FormGroup;

  constructor(
    private dialogRef: MatDialogRef<EditArticleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { articleId: number, idCategory: number },
    private fb: FormBuilder,
    private articleService: ArticleService
  ) {
    this.editArticleForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      height: ['', Validators.required],
      width: ['', Validators.required],
      length: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.articleService.getArticleById(this.data.articleId).subscribe(article => {
      this.editArticleForm.patchValue({
        name: article.name,
        description: article.description,
        height: article.height,
        width: article.width,
        length: article.length
      });
    });
  }

  onSubmit(): void {
    if (this.editArticleForm.valid) {
      const articleData: Article = {
        name: this.editArticleForm.get('name')!.value,
        description: this.editArticleForm.get('description')!.value,
        height: this.editArticleForm.get('height')!.value,
        width: this.editArticleForm.get('width')!.value,
        length: this.editArticleForm.get('length')!.value,
        categoryId: this.data.idCategory
      };
      this.articleService.updateArticle(this.data.articleId, articleData).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }
}