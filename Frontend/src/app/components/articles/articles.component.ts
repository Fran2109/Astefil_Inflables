import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article/article.service';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  loadingCategories: boolean = true;
  loadingArticles: boolean = true;
  categories: any[] = [];
  articles: any[] = [];
  selectedCategory: any;


  constructor(private articleService: ArticleService, private categoryService: CategoryService, private router: Router) { }

  ngOnInit() {
    this.loadingCategories = true;
    setTimeout(() => {
      this.categoryService.getCategories().subscribe((categories: any[]) => {
        this.categories = categories;
        this.selectCategory(this.categories[0]);
        this.loadingCategories = false;
      });
    }, 1000);
  }

  selectCategory(category: any) {
    this.loadingArticles = true;
    this.selectedCategory = category;
    setTimeout(() => {
      this.articles = this.articleService.getArticlesByCategoryId(category.id);
      this.loadingArticles = false;
    }, 1000);
    this.loadingArticles = false;
  }

  viewDetails(articleId: number) {
    this.router.navigate(['/articles', articleId]);
  }

}