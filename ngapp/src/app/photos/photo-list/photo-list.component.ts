import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';

import { Photo } from '../photo/photo';
import { PhotoService } from '../photo/photo.service';

@Component({
  selector: 'app-photo-list',
  templateUrl: './photo-list.component.html'
})
export class PhotoListComponent implements OnInit, OnDestroy {

  photos: Photo[] = [];
  filter: string = '';
  debounce: Subject<string> = new Subject<string>();
  currentPage: number = 0;
  hasMore: boolean = true;

  constructor(
    private activatedRoute: ActivatedRoute,
    private photoService: PhotoService) { }
  
  ngOnInit(): void {
    this.photos = this.activatedRoute.snapshot.data['photos'];
    this.debounce
      .pipe(debounceTime(300))
      .subscribe(filter => this.filter = filter);
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

  ngOnDestroy(): void {
    this.debounce.unsubscribe();
  }

}
