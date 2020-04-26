import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Photo } from './photo';

@Injectable({ providedIn: 'root' })
export class PhotoService {

    constructor(private http: HttpClient) {}

    listAll(): Observable<Photo[]> {
        return this.http.get<Photo[]>('http://localhost:8080/photos');
    }
    
}
