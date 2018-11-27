import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BlogType} from '../../models/blog-type';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BlogTypesService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }
  getAllBlogTypes(): Observable<BlogType[]> {
    return this.http.get<BlogType[]>(`${this.AUTH_API_URL}/blogTypes`);
  }
}
