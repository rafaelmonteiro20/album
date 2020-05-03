import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Photo } from './photo/photo';

@Injectable({ providedIn: 'root' })
export class PhotoService {

    constructor(private http: HttpClient) {}

    listAll(page: number = 0): Observable<Photo[]> {
        let params = new HttpParams().append('page', page.toString());
        return this.http.get<Photo[]>('http://localhost:8080/photos', { params });
    }
    
}
