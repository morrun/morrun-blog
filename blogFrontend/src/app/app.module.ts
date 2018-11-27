import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import {CustomStyleModule} from './shared/modules/custom-style/custom-style.module';
import { BlogsComponent } from './blogs/blogs.component';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BlogDetailComponent } from './blogs/blog-detail/blog-detail.component';
import { UsersComponent } from './users/users.component';
import { LoginComponent } from './users/login/login.component';
import { AddBlogComponent } from './blogs/add-blog/add-blog.component';
import { ErrorComponent } from './error/error.component';
import { ModifyBlogComponent } from './blogs/modify-blog/modify-blog.component';
import { ModifyCommentComponent } from './blogs/blog-detail/modify-comment/modify-comment.component';
import { BlogPipePipe } from './shared/pipes/blog-pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BlogsComponent,
    ProfileComponent,
    BlogDetailComponent,
    UsersComponent,
    LoginComponent,
    AddBlogComponent,
    ErrorComponent,
    ModifyBlogComponent,
    ModifyCommentComponent,
    BlogPipePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    CustomStyleModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
