import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BlogTypesService} from '../../shared/services/blog/blog-types.service';
import {BlogType} from '../../shared/models/blog-type';
import {Blog} from '../../shared/models/blog';
import {BlogServiceService} from '../../shared/services/blog/blog-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-blog',
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.scss']
})
export class AddBlogComponent implements OnInit {
  blogFG: FormGroup;
  blogTypes: BlogType[];
  constructor(
    private rt: Router,
    private fb: FormBuilder,
    private bts: BlogTypesService,
    private bs: BlogServiceService
  ) { }

  ngOnInit() {
    this.blogFG = this.fb.group({
      title: ['', [Validators.required]],
      type: [''],
      content: ['', [Validators.required]]
    });
    this.bts.getAllBlogTypes().subscribe( res => {
      this.blogTypes = res;
    });
  }
  submit() {
    if (this.blogFG.valid) {
      const {title, type, content} = this.blogFG.value;
      const blog = new Blog();
      blog.title = title;
      blog.type = new BlogType();
      blog.type.type = type;
      blog.content = content;
      this.bs.addBlog(blog).subscribe(res => {
        if (res.success) {
          this.rt.navigate(['/blogs']).then();
        } else  {
          this.rt.navigate(['/error']).then();
        }
      });
    }
  }
}
