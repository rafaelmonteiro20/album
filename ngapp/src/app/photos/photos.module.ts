import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { PhotoComponent } from './photo/photo.component';
import { PhotoListComponent } from './photo-list/photo-list.component';
import { PhotosComponent } from './photo-list/photos/photos.component';
import { FilterByDescriptionPipe } from './photo-list/filter-by-description.pipe';

@NgModule({
    declarations: [
        PhotoComponent,
        PhotoListComponent,
        PhotosComponent,
        FilterByDescriptionPipe
    ],
    imports: [
        CommonModule,
        HttpClientModule
    ],
    exports: [
        PhotoListComponent
    ]
})
export class PhotosModule { }
