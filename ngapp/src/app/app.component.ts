import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'Album';
  photos: Object[] = [];

  constructor(private http: HttpClient) {
    http
      .get<Object[]>('http://localhost:8080/photos')
      .subscribe(photos => this.photos = photos);
  }

}
