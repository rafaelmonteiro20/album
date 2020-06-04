import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    templateUrl: './photo-details.component.html'
})
export class PhotoDetailsComponent implements OnInit {
    
    constructor(private router: ActivatedRoute) {}

    ngOnInit(): void {
        const photoId = this.router.snapshot.params.photoId;
        console.log(photoId);
    }

}
