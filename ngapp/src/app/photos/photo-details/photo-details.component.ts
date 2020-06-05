import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { Photo } from '../photo/photo';
import { PhotoService } from '../photo/photo.service';
import { PhotoComment } from '../photo/photo-comment';

@Component({
    templateUrl: './photo-details.component.html'
})
export class PhotoDetailsComponent implements OnInit {
    
    photo$: Observable<Photo>;
    comments$: Observable<PhotoComment>;

    constructor(
        private router: ActivatedRoute,
        private photoService: PhotoService) {}

    ngOnInit(): void {
        const photoId = this.router.snapshot.params.photoId;
        this.photo$ = this.photoService.findById(photoId);
        this.comments$ = this.photoService.getComments(photoId);
    }

}
