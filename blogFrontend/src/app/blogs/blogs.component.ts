import {Component, DoCheck, OnInit} from '@angular/core';
import {BlogServiceService} from '../shared/services/blog/blog-service.service';
import {switchMap} from 'rxjs/internal/operators';
import {Blog} from '../shared/models/blog';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {AuthService} from '../shared/services/auth/auth.service';
import {BlogTypesService} from '../shared/services/blog/blog-types.service';
import {BlogType} from '../shared/models/blog-type';
@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.scss']
})
export class BlogsComponent implements OnInit, DoCheck {
  login =false;
  length = 10;
  totalPages: number;
  page: number;
  blogs: Blog[];
  showBlogs: Blog[];
  selectedType: string = 'All';
  blogTypes: BlogType[];
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private blogService: BlogServiceService,
    private authS: AuthService,
    private blogType: BlogTypesService
  ) {
    this.authS.checkLogin();
    this.authS.userSubject.subscribe( res => {
      if (res) {
        this.login  = true;
      }
    });
  }

  ngOnInit() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        this.page = +paramMap.get('page');
        if (!this.page) {
          this.page = 1;
        }
        return this.blogService.getAllBlogs();
      })
    ).subscribe(res => {
      this.blogs = res;
      this.showBlogs = this.blogs.slice((this.page - 1) * this.length, this.page * this.length);
    });
    this.blogType.getAllBlogTypes().subscribe(res => {
      this.blogTypes = res;
    });
  }
  modifyView() {
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
  ngDoCheck() {
    //console.log(this.selectedType);
  }
}
