import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PhotoService {

    constructor(private http: HttpClient) {}

    listAll(): Observable<Object[]> {
        return this.http.get<Object[]>('http://localhost:8080/photos');
    }
}
