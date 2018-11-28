import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Comment} from '../../models/comment';
@Injectable({
  providedIn: 'root'
})
export class CommentService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  postComment(comment: Comment): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/comments`, comment);
  }
  getCommentById(id: number): Observable<Comment> {
    return this.http.get<Comment>(`${this.AUTH_API_URL}/comments/modify/${id}`);
  }
  putComment(comment: Comment): Observable<{success: boolean}> {
    return this.http.put<{success: boolean}>(`${this.AUTH_API_URL}/comments`, comment, {withCredentials: true});
  }
}
