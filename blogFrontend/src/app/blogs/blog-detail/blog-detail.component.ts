import { Component, OnInit } from '@angular/core';
import {BlogServiceService} from '../../shared/services/blog/blog-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Blog} from '../../shared/models/blog';
import {switchMap} from 'rxjs/internal/operators';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {
  blog: Blog;
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private blogService: BlogServiceService
  ) { }

  ngOnInit() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        return this.blogService.getBlogById(id);
      })
    ).subscribe(res => {
      this.blog = res;
    });
  }
  submit() {

  }

}
