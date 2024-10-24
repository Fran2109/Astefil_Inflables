import { Component, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/services/article/article.service';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  loadingCategories: boolean = true;
  loadingInflables: boolean = true;
  categories: any[] = [];
  inflables: any[] = [];
  selectedCategory: any;

  constructor(private articleService: ArticleService, private categoryService: CategoryService) { }

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
    this.loadingInflables = true;
    this.selectedCategory = category;
    setTimeout(() => {
      this.inflables = this.articleService.getArticlesByCategoryId(category.id);
      this.loadingInflables = false;
    }, 1000);
    this.loadingInflables = false;
  }
}