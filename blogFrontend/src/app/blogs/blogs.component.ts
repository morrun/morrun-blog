import { Component, OnInit } from '@angular/core';
import {BlogServiceService} from '../shared/services/blog/blog-service.service';
import {switchMap} from 'rxjs/internal/operators';
import {Blog} from '../shared/models/blog';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.scss']
})
export class BlogsComponent implements OnInit {
  length = 2;
  totalPages: number;
  page: number;
  blogs: Blog[];
  showBlogs: Blog[];
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private blogService: BlogServiceService
  ) { }

  ngOnInit() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        this.page = +paramMap.get('page');
        return this.blogService.getAllBlogs();
      })
    ).subscribe(res => {
      this.blogs = res;
      this.showBlogs = this.blogs.slice((this.page - 1) * this.length, this.page * this.length);
    });
  }

  arrayGen() {
    if (!this.blogs) {
      return [];
    }
    let result: number[] = [];
    if (this.blogs.length % this.length > 0) {
      this.totalPages = this.blogs.length / this.length + 1;
    } else {
      this.totalPages = this.blogs.length / this.length;
    }
    for (let i = 1;i <= this.totalPages; i ++) {
      result.push(i);
    }
    return result;
  }

  prev() {
    if (this.page === 1) {
      return;
    }
    const page = this.page - 1;
    this.rt.navigate(['/blogs', page]);
  }
  next() {
    const page = this.page + 1;
    if (page > this.totalPages) {
      return;
    }
    this.rt.navigate(['/blogs', page]);
  }
}
