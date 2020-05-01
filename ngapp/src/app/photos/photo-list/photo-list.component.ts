import { Component, OnInit } from '@angular/core';

import { Photo } from '../photo/photo';
import { PhotoService } from '../photo/photo.service';

@Component({
  selector: 'ab-photo-list',
  templateUrl: './photo-list.component.html'
})
export class PhotoListComponent implements OnInit {

  photos: Photo[] = [];
  filter: string = '';

  constructor(private photoService: PhotoService) { }
  
  ngOnInit(): void {
    this.photoService.listAll()
      .subscribe(photos => this.photos = photos);
  }

}
