import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Photo } from './photo';
import { PhotoComment } from './photo-comment';

@Injectable({ providedIn: 'root' })
export class PhotoService {

    constructor(private http: HttpClient) {}

    listAll(userName: string, page: number = 0): Observable<Photo[]> {
        let params = new HttpParams().append('page', page.toString());
        return this.http.get<Photo[]>(`http://localhost:8080/photos/user/${userName}`, { params });
    }

    upload(description: string, allowComments: boolean, file: File) {
        const formData = new FormData();
        formData.append('description', description);
        formData.append('allowComments', allowComments ? 'true' : 'false');
        formData.append('imageFile', file);
        return this.http.post('http://localhost:8080/photos/upload', formData);
    }

    findById(photoId: number) {
        return this.http.get<Photo>(`http://localhost:8080/photos/${photoId}`);
    }
    
    getComments(photoId: number) {
        return this.http.get<PhotoComment[]>(`http://localhost:8080/photos/${photoId}/comments`);
    }

    addComment(photoId: number, textComment: string) {
        return this.http.post(`http://localhost:8080/photos/${photoId}/comments`, { textComment });
    }

}
