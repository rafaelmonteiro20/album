import { Component, Input } from '@angular/core';

@Component({
    selector: 'ab-photo',
    templateUrl: './photo.component.html'
})
export class PhotoComponent {

    @Input() description = '';
    @Input() url = '';
    
}
