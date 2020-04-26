import { Component } from '@angular/core';

import { PhotoService } from './photos/photo/photo.service';
import { Photo } from './photos/photo/photo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'Album';
  photos: Photo[] = [];

  constructor(photoService: PhotoService) {
    photoService.listAll()
      .subscribe(photos => this.photos = photos);
  }

}
