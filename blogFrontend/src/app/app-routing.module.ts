import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlogsComponent} from './blogs/blogs.component';
import {ProfileComponent} from './profile/profile.component';
import {BlogDetailComponent} from './blogs/blog-detail/blog-detail.component';

const routes: Routes = [
  {
    path: 'blogs/:page',
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
    path: '**',
    component: BlogsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
