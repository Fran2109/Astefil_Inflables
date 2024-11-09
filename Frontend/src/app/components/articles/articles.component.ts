import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/Article';
import { Category } from 'src/app/models/Category';
import { ArticleService } from 'src/app/services/article/article.service';
import { CategoryService } from 'src/app/services/category/category.service';

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


  constructor(private articleService: ArticleService, private categoryService: CategoryService, private router: Router) { }

  ngOnInit() {
    this.loading = true;
    this.categoryService.getOrderedCategories().subscribe((categories: Category[]) => {
      this.categories = categories;
      this.selectCategory(this.categories[0]);
      this.loading = false;
    });
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

  returnFirstImage(article: Article) {
    if (article && article.id && article.images && article.images.length > 0) {
      if (article.id !== undefined && article.images[0].id !== undefined) {
        return this.articleService.getImage(article.id, article.images[0].id, article.images[0].name || '');
      }
      return "assets/images/no-image.jpg";
    }
    return "assets/images/no-image.jpg";
  }
}