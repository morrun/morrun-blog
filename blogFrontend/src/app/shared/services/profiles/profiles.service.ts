import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Blog} from '../../models/blog';
import {Observable} from 'rxjs';
import {Profiles} from '../../models/profiles';

@Injectable({
  providedIn: 'root'
})
export class ProfilesService {
  AUTH_API_URL = `${environment.API_URL}`;
  constructor(
    private http: HttpClient
  ) { }

  getAllProfiles(): Observable<Profiles[]> {
    return this.http.get<Profiles[]>(`${this.AUTH_API_URL}/profiles`);
  }
}
