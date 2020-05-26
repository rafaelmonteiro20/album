import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    templateUrl: './photo-form.component.html'
})
export class PhotoFormComponent implements OnInit {

    photoForm: FormGroup;

    constructor(private formBuilder: FormBuilder) {}
    
    ngOnInit(): void {
        this.photoForm = this.formBuilder.group({
            file: ['', Validators.required],
            description: ['', 
                [
                    Validators.required,
                    Validators.maxLength(400)
                ]
            ],
            allowComments: [true]
        });
    }

}
