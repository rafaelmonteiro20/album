import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Photo } from '../photo/photo';
import { PhotoService } from '../photo/photo.service';

@Component({
  selector: 'app-photo-list',
  templateUrl: './photo-list.component.html'
})
export class PhotoListComponent implements OnInit {

  photos: Photo[] = [];
  filter: string = '';
  
  currentPage: number = 0;
  hasMore: boolean = true;

  constructor(
    private activatedRoute: ActivatedRoute,
    private photoService: PhotoService) { }
  
  ngOnInit(): void {
    this.photos = this.activatedRoute.snapshot.data['photos'];
  }

  load() {
    this.photoService.listAll(++this.currentPage)
      .subscribe(photos => {
        this.photos = this.photos.concat(photos);
        if (!photos.length) {
          this.hasMore = false;
        }
      });
  }

}
