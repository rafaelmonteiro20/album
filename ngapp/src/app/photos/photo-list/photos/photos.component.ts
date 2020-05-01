import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

import { Photo } from '../../photo/photo';

@Component({
  selector: 'app-photos',
  templateUrl: './photos.component.html'
})
export class PhotosComponent implements OnChanges {

  @Input() photos: Photo[] = [];
  rows: any[] = [];

  constructor() { }
  
  ngOnChanges(changes: SimpleChanges) {
    if (changes.photos) {
      this.rows = this.groupColumns(this.photos);
    }
  }

  private groupColumns(photos: Photo[]) {
    const rows = [];
    for (let index = 0; index < photos.length; index += 3) {
      rows.push(photos.slice(index, index + 3));
    }
    return rows;
  }

}
