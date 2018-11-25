import {AfterContentInit, AfterViewInit, ChangeDetectorRef, Component, DoCheck, NgZone, OnChanges, OnInit} from '@angular/core';
import {BlogServiceService} from '../../shared/services/blog/blog-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Blog} from '../../shared/models/blog';
import {switchMap} from 'rxjs/internal/operators';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {CommentService} from '../../shared/services/comment/comment.service';
import {Comment} from '../../shared/models/comment';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit{
  blog: Blog;
  commentFormGroup: FormGroup;
  page: number;
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private blogService: BlogServiceService,
    private commentService: CommentService,
    private fb: FormBuilder
  ) { }
  load() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        this.page = id;
        return this.blogService.getBlogById(id);
      })
    ).subscribe(res => {
      this.blog = res;
    });
  }
  ngOnInit() {
    this.load();

    this.commentFormGroup = this.fb.group({
      commenterEmail: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')]],
      content: ['', [Validators.required]]
    });
  }
  submit() {
    if(this.commentFormGroup.valid) {
      const {commenterEmail, content} = this.commentFormGroup.value;
      const comment = new Comment();
      comment.blog = new Blog();
      comment.commenterEmail = commenterEmail;
      comment.content = content;
      comment.blog = this.blog;
      comment.blog.comments = null;
      this.commentService.postComment(comment).subscribe(res => {
        this.blogService.getBlogById(comment.blog.id).subscribe( res => {
          this.blog = res;
        });
      });
      this.commentFormGroup.reset();
    }
  }

}
