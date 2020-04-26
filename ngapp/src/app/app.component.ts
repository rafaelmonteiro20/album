import { Component, OnInit } from '@angular/core';

import { PhotoService } from './photos/photo/photo.service';
import { Photo } from './photos/photo/photo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'Album';
  photos: Photo[] = [];

  constructor(private photoService: PhotoService) {}
  
  ngOnInit(): void {
    this.photoService.listAll()
      .subscribe(photos => this.photos = photos);
  }

}
