import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleService } from 'src/app/services/article/article.service';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {
  article: any;

  constructor(private route: ActivatedRoute, private articleService: ArticleService) { }

  ngOnInit() {
    const articleId = +this.route.snapshot.paramMap.get('id')!;
    this.article = this.articleService.getArticleById(articleId);
  }
}