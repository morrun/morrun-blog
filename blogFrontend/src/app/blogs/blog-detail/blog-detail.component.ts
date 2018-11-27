import {AfterContentInit, AfterViewInit, ChangeDetectorRef, Component, DoCheck, NgZone, OnChanges, OnInit} from '@angular/core';
import {BlogServiceService} from '../../shared/services/blog/blog-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Blog} from '../../shared/models/blog';
import {switchMap} from 'rxjs/internal/operators';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {CommentService} from '../../shared/services/comment/comment.service';
import {Comment} from '../../shared/models/comment';
import {AuthService} from '../../shared/services/auth/auth.service';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit{
  login = false;
  blog: Blog;
  commentFormGroup: FormGroup;
  clicked = 0;
  clicked1 = 0;
  page: number;
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private blogService: BlogServiceService,
    private commentService: CommentService,
    private fb: FormBuilder,
    private authS: AuthService
  ) {
    this.authS.userSubject.subscribe( res => {
      if (res) {
        this.login  = true;
      }
    });
  }
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
    if (this.commentFormGroup.valid) {
      const {commenterEmail, content} = this.commentFormGroup.value;
      this.authS.checkUserExist(commenterEmail).subscribe( res => {
        if (res.success && !this.login) {
          this.authS.way  = 1;
          this.rt.navigate(['/login']).then();
        } else {
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
      });
    }
  }
  modify(id: number) {
    alert(id);
  }
  clickLike() {
    if (this.clicked === 0 && this.clicked1 === 0) {
      this.blog.like += 1;
      this.clicked = 1;
    } else if (this.clicked1 === 1 && this.clicked === 0){
      this.blog.like += 1;
      this.blog.unlike -= 1;
      this.clicked1 = 0;
      this.clicked = 1;
    }
    if (this.clicked === 1) {
      this.update();
    }
  }
  update() {
    this.blogService.updateBlog(this.blog, this.blog.id).subscribe(res => {
      if (!res.success) {
        this.rt.navigate(['/error']).then();
      }
    });
  }
  clickUnlike() {
    if (this.clicked === 0 && this.clicked1 === 0) {
      this.blog.unlike += 1;
      this.clicked1 = 1;
    } else if (this.clicked1 === 0 && this.clicked === 1){
      this.blog.like -= 1;
      this.blog.unlike += 1;
      this.clicked1 = 1;
      this.clicked = 0;
    }
    if (this.clicked1 === 1) {
      this.update();
    }
  }
}
