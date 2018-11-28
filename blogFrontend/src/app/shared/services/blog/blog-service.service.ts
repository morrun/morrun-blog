import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Observable} from 'rxjs';
import {Blog} from '../../models/blog';

@Injectable({
  providedIn: 'root'
})
export class BlogServiceService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  getAllBlogs(): Observable<Blog[]> {
    return this.http.get<Blog[]>(`${this.AUTH_API_URL}/blogs`);
  }
  getBlogById(id: number): Observable<Blog> {
    return this.http.get<Blog>(`${this.AUTH_API_URL}/blogs/${id}`);
  }
  addBlog(blog: Blog): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/blogs`, blog, {withCredentials: true});
  }
  updateBlog(blog: Blog, id: number): Observable<{success: boolean}> {
    return this.http.put<{success: boolean}>(`${this.AUTH_API_URL}/blogs/${id}`, blog, {withCredentials: true});
  }
}
