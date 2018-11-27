import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {switchMap} from 'rxjs/internal/operators';
import {CommentService} from '../../../shared/services/comment/comment.service';
import {Comment} from '../../../shared/models/comment';

@Component({
  selector: 'app-modify-comment',
  templateUrl: './modify-comment.component.html',
  styleUrls: ['./modify-comment.component.scss']
})
export class ModifyCommentComponent implements OnInit {
  comment: Comment;
  commentModify: FormGroup;
  constructor(
    private rt: Router,
    private router: ActivatedRoute,
    private commentService: CommentService,
    private fb: FormBuilder,
  ) { }

  ngOnInit() {
    this.load();
  }
  load() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        return this.commentService.getCommentById(id);
      })
    ).subscribe(res => {
      this.comment = res;
      this.commentModify = this.fb.group({
        commenterEmail: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')]],
        content: ['']
      });
    });
  }
  submit() {
    if (!(this.commentModify.get('commenterEmail').errors&&this.commentModify.get('commenterEmail').errors.pattern)){
      const {commenterEmail, content} = this.commentModify.value;
      if (commenterEmail) {
        this.comment.commenterEmail = commenterEmail;
      }
      if (content) {
        this.comment.content = content;
      }
      this.commentService.putComment(this.comment).subscribe( res => {
        if (res.success) {
          this.rt.navigate(['/blog-detail', this.comment.blog.id]).then();
        } else {
          this.rt.navigate(['/error']).then();
        }
      });
    }
    }


}
