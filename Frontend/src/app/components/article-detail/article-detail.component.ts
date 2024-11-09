import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { Article } from 'src/app/models/Article';
import { ArticleService } from 'src/app/services/article/article.service';
import { ImageModalComponent } from '../image-modal/image-modal.component';
import { ViewportScroller } from '@angular/common';

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
    private dialog: MatDialog,
    private viewportScroller: ViewportScroller
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.getArticle();
    });
  }

  getArticle(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.articleService.getArticleById(id).subscribe(article => {
      this.selectedArticle = article;

      if (article.id !== undefined) {
        this.getRelatedArticles(article.id);
      }
    })
  }

  getRelatedArticles(currentArticleId: number): void {
    this.articleService.getRelatedArticles(currentArticleId).subscribe(articles => {
      this.relatedArticles = articles;
    })
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
    this.router.navigate(['/articles', articleId]).then(() => {
      this.viewportScroller.scrollToPosition([0, 0]);
    });
  }

  returnFirstImage(article: Article): String {
    return this.articleService.returnFirstImage(article);
  }

  getImage(id: Number, imageId: Number, imageName: string): String {
    return this.articleService.getImage(id, imageId, imageName);
  }
}
