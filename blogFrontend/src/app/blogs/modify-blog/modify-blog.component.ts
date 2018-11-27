import { Component, OnInit } from '@angular/core';
import {Blog} from '../../shared/models/blog';
import {BlogTypesService} from '../../shared/services/blog/blog-types.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BlogServiceService} from '../../shared/services/blog/blog-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {BlogType} from '../../shared/models/blog-type';
import {switchMap} from 'rxjs/internal/operators';

@Component({
  selector: 'app-modify-blog',
  templateUrl: './modify-blog.component.html',
  styleUrls: ['./modify-blog.component.scss']
})
export class ModifyBlogComponent implements OnInit {
  blog: Blog;
  blogFG: FormGroup;
  blogTypes: BlogType[];
  constructor(
    private rt: Router,
    private fb: FormBuilder,
    private bts: BlogTypesService,
    private router: ActivatedRoute,
    private blogService: BlogServiceService,
    private bs: BlogServiceService
  ) { }

  ngOnInit() {
    this.load();
    this.bts.getAllBlogTypes().subscribe( res => {
      this.blogTypes = res;
    });
  }
  load() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        return this.blogService.getBlogById(id);
      })
    ).subscribe(res => {
      this.blog = res;
      this.blogFG = this.fb.group({
        title: [this.blog.title, [Validators.required]],
        type: [this.blog.type.type],
        content: [this.blog.content, [Validators.required]]
      });
    });
  }
  submit() {
    if (this.blogFG.valid) {
      const {title, type, content} = this.blogFG.value;
      this.blog.title = title;
      this.blog.type.type = type;
      this.blog.content = content;
      this.bs.updateBlog(this.blog, this.blog.id).subscribe(res => {
        if (res.success) {
          this.rt.navigate(['/blogs']).then();
        } else  {
          this.rt.navigate(['/error']).then();
        }
      });
    }
  }

}
