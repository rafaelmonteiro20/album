import { Component } from '@angular/core';

import { PhotoService } from './photos/photo/photo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'Album';
  photos: Object[] = [];

  constructor(photoService: PhotoService) {
    photoService.listAll()
      .subscribe(photos => this.photos = photos);
  }

}
