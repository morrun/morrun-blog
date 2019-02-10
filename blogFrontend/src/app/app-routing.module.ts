import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlogsComponent} from './blogs/blogs.component';
import {ProfileComponent} from './profile/profile.component';
import {BlogDetailComponent} from './blogs/blog-detail/blog-detail.component';
import {LoginComponent} from './users/login/login.component';
import {AddCommand} from '@angular/cli/commands/add-impl';
import {AddBlogComponent} from './blogs/add-blog/add-blog.component';
import {ErrorComponent} from './error/error.component';
import {ModifyBlogComponent} from './blogs/modify-blog/modify-blog.component';
import {ModifyCommentComponent} from './blogs/blog-detail/modify-comment/modify-comment.component';

const routes: Routes = [
  {
    path: 'blogs/:page',
    component: BlogsComponent
  },
  {
    path: 'blogs/:type/:page',
    component: BlogsComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'blog-detail/:id',
    component: BlogDetailComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'create-blog',
    component: AddBlogComponent
  },
  {
    path: 'error',
    component: ErrorComponent
  },
  {
    path: 'modify-blog/:id',
    component: ModifyBlogComponent
  },
  {
    path: 'modify-comment/:id',
    component: ModifyCommentComponent
  },
  {
    path: '**',
    component: BlogsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
