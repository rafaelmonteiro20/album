import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PhotoService } from '../photo/photo.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './photo-form.component.html'
})
export class PhotoFormComponent implements OnInit {

    photoForm: FormGroup;
    file: File;

    constructor(
        private photoService: PhotoService,
        private formBuilder: FormBuilder,
        private router: Router) {}
    
    ngOnInit(): void {
        this.photoForm = this.formBuilder.group({
            file: ['', Validators.required],
            description: ['', 
                [
                    Validators.required,
                    Validators.maxLength(300)
                ]
            ],
            allowComments: [true]
        });
    }

    upload() {
        const description = this.photoForm.get('description').value;
        const allowComments = this.photoForm.get('allowComments').value;
        this.photoService.upload(description, allowComments, this.file)
            .subscribe(
                () => this.router.navigate(['']),
                err => console.log(err));
    }

}
