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
    this.getGame();
  }

  getGame(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.selectedArticle = this.articleService.getArticleById(id);
  }

  goBack() {
    this.router.navigate(["/articles"]);
  }

  openImageModal(imageUrl: string, altText: string): void {
    this.dialog.open(ImageModalComponent, {
      data: {
        imageUrl: imageUrl,
        altText: altText
      }, autoFocus: false,
      panelClass: 'custom-modal-container'
    });
  }
}
