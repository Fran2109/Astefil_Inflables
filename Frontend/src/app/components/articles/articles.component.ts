import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/Article';
import { Category } from 'src/app/models/Category';
import { ArticleService } from 'src/app/services/article/article.service';
import { CategoryService } from 'src/app/services/category/category.service';
import { CreateCategoryComponent } from '../create-category/create-category.component';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDeleteCategoryComponent } from '../confirm-delete-category/confirm-delete-category.component';
import { EditCategoryComponent } from '../edit-category/edit-category.component';
import { CreateArticleComponent } from '../create-article/create-article.component';
import { ConfirmDeleteArticleComponent } from '../confirm-delete-article/confirm-delete-article.component';
import { EditArticleComponent } from '../edit-article/edit-article.component';
import { AuthService } from 'src/app/services/auth/auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  loading: boolean = true;
  categories: any[] = [];
  articles: any[] = [];
  selectedCategory: any;
  isAdmin$: Observable<boolean> | undefined;

  constructor(private articleService: ArticleService, private categoryService: CategoryService, private router: Router, private dialog: MatDialog, private authService: AuthService) { }

  ngOnInit() {
    this.loading = true;
    this.categoryService.getOrderedCategories().subscribe((categories: Category[]) => {
      this.categories = categories;
      this.selectCategory(this.categories[0]);
      this.loading = false;
    });
    this.isAdmin$ = this.authService.isAdmin();
  }

  selectCategory(category: any) {
    this.selectedCategory = category;
    this.articleService.getAllArticlesByCategoryId(category.id).subscribe((articles: Article[]) => {
      this.articles = articles;
    });
  }

  viewDetails(articleId: number) {
    this.router.navigate(['/articles', articleId])
  }

  returnFirstImage(article: Article): String {
    return this.articleService.returnFirstImage(article);
  }

  openCreateCategoryModal(): void {
    const dialogRef = this.dialog.open(CreateCategoryComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

  openDeleteCategoryModal(category: Category): void {
    const dialogRef = this.dialog.open(ConfirmDeleteCategoryComponent, {
      width: '400px',
      data: { categoryName: category.name }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.deleteCategory(category.id!);
      }
    });
  }

  deleteCategory(id: number): void {
    this.categoryService.deleteCategory(id).subscribe(() => {
      this.ngOnInit();
    });
  }

  openEditCategoryModal(category: Category): void {
    const dialogRef = this.dialog.open(EditCategoryComponent, {
      width: '400px',
      data: { category }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

  incrementCategoryOrder(id: number) {
    this.categoryService.incrementCategoryOrder(id).subscribe((data) => {
      this.ngOnInit();
    });
  }

  decrementCategoryOrder(id: number) {
    this.categoryService.decrementCategoryOrder(id).subscribe((data) => {
      this.ngOnInit();
    });
  }

  openAddArticleModal(): void {
    const dialogRef = this.dialog.open(CreateArticleComponent, {
      width: '500px',
      data: { idCategory: this.selectedCategory.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

  openDeleteArticleModal(articleId: number, articleName: string, articleDescription: string): void {
    const dialogRef = this.dialog.open(ConfirmDeleteArticleComponent, {
      width: '300px',
      data: {
        name: articleName,
        description: articleDescription
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.articleService.deleteArticle(articleId).subscribe(() => {
          this.ngOnInit();
        });
      }
    });
  }

  openEditArticleModal(articleId: number): void {
    const dialogRef = this.dialog.open(EditArticleComponent, {
      width: '500px',
      data: { articleId: articleId, idCategory: this.selectedCategory.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }
}