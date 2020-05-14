import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';

import { TokenService } from '../token/token.service';

@Injectable({ providedIn: 'root' })
export class AuthService {

  constructor(
    private http: HttpClient,
    private tokenService: TokenService) { }

  authenticate(username: string, password: string) {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/x-www-form-urlencoded')
      .append('Authorization', 'Basic YW5ndWxhcjphbmd1bGFyMTIz');
    
    const body = `username=${username}&password=${password}&grant_type=password`;

    return this.http.post<any>('http://localhost:8080/oauth/token', body, { headers, withCredentials: true })
      .pipe(tap(response => this.tokenService.setToken(response.access_token)));
  }

}
