import { Component, Input } from '@angular/core';

const CLOUD = 'http://localhost:8080/images/';

@Component({
    selector: 'app-photo',
    templateUrl: './photo.component.html'
})
export class PhotoComponent {

    private _url = '';

    @Input() description = '';
    
    @Input() set url(url: string) {
        if (url.startsWith('http') || url.startsWith('data')) {
            this._url = url;
        } else {
            this._url = CLOUD + url;
        }
    }

    get url() {
        return this._url;
    }
    
}
