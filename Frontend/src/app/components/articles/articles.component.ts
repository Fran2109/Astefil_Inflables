import { Component, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/services/article/article.service';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class InflablesComponent implements OnInit {
  categories: any[] = [];
  inflables: any[] = [];
  selectedCategory: any;

  constructor(private articleService: ArticleService, private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.getCategories().subscribe((categories: any[]) => {
      this.categories = categories;
      this.selectCategory(this.categories[0]);
    });
  }

  selectCategory(category: any) {
    this.selectedCategory = category;
    this.inflables = this.articleService.getArticlesByCategoryId(category.id);
  }
}