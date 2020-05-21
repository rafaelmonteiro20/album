import { Injectable } from '@angular/core';
import { AbstractControl } from '@angular/forms';

import { SignUpService } from './signup.service';

@Injectable({ providedIn: 'root' })
export class UserNotTakenValidator {

    constructor(private signUpService: SignUpService) { }

    checkUserNameTaken() {
        return (control: AbstractControl) => {
            return control.valueChanges;
        }
    }

}
