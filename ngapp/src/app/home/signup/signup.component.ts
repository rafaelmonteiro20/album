import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { lowerCaseValidator } from 'src/app/shared/validators/lower-case.validator';
import { UserNotTakenValidator } from './user-not-taken.validator';
import { SignUpService } from './signup.service';
import { NewUser } from './new-user';

@Component({
    templateUrl: './signup.component.html'
})
export class SignUpComponent implements OnInit {

    signupForm: FormGroup;

    constructor(
        private formBuilder: FormBuilder,
        private signUpService: SignUpService,
        private userNotTakenValidator: UserNotTakenValidator,
        private router: Router) { }
    
    ngOnInit(): void {
        this.signupForm = this.formBuilder.group({
            email: ['', 
                [
                    Validators.required,
                    Validators.email
                ]
            ],
            fullName: ['',
                [
                    Validators.required,
                    Validators.minLength(2),
                    Validators.maxLength(50)
                ]
            ],
            userName: ['',
                [
                    Validators.required,
                    lowerCaseValidator,
                    Validators.minLength(2),
                    Validators.maxLength(30)
                ],
                this.userNotTakenValidator.checkUserNameTaken()
            ],
            password: ['',
                [
                    Validators.required,
                    Validators.minLength(6),
                    Validators.maxLength(14)
                ]
            ]
        });
    }

    signUp() {
        const newUser = this.signupForm.getRawValue() as NewUser;
        this.signUpService.save(newUser)
            .subscribe(() => this.router.navigate(['']));
    }

}
