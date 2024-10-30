import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { Article } from 'src/app/models/Article';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {
  selectedArticle!: Article | null;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private articleService: ArticleService
  ) { }

  ngOnInit(): void {
    this.getGame();
  }

  getGame(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.selectedArticle = this.articleService.getArticleById(id);
    /* this.articleService.getArticleById(id).subscribe(
      (article) => {
        if (article) {
          this.selectedArticle = article;
        }
      },
      (error) => {
        if (error.status === 404) {
          this.router.navigate(["/404"]);
        }
        return throwError(error);
      }
    ); */
  }

  goBack() {
    this.router.navigate(["/articles", this.selectedArticle?.categoryId]);
  }
}