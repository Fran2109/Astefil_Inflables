import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { Article } from 'src/app/models/Article';
import { ArticleService } from 'src/app/services/article/article.service';
import { ImageModalComponent } from '../image-modal/image-modal.component';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {
  selectedArticle!: Article | null;
  relatedArticles: Article[] = [];
  carouselOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: true,
    navSpeed: 700,
    navText: ['<', '>'],
    items: 1,
    nav: true
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private articleService: ArticleService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.getArticle();
    });
  }

  getArticle(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.selectedArticle = this.articleService.getArticleById(id);
    if (this.selectedArticle) {
      if (this.selectedArticle?.categoryId !== undefined) {
        this.getRelatedArticles(this.selectedArticle.categoryId, id);
      }
    }
  }

  getRelatedArticles(categoryId: number, currentArticleId: number): void {
    this.relatedArticles = this.articleService.getArticlesByCategoryId(categoryId)
      .filter(article => article.id !== currentArticleId);
  }

  goBack() {
    this.router.navigate(["/articles"]);
  }

  openImageModal(imageUrl: string, altText: string): void {
    this.dialog.open(ImageModalComponent, {
      data: {
        imageUrl: imageUrl,
        altText: altText
      },
      autoFocus: false,
      panelClass: 'custom-modal-container'
    });
  }

  viewDetails(articleId: number): void {
    this.router.navigate(["/articles", articleId]);
  }
}
