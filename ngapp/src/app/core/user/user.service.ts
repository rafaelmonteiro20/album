import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode'

import { TokenService } from '../token/token.service';

@Injectable({ providedIn: 'root' })
export class UserService {

    constructor(private tokenService: TokenService) {
        this.tokenService.hasToken() && this.decodeAndNotify();
    }

    setToken(token: string) {
        this.tokenService.setToken(token);
        this.decodeAndNotify();
    }

    getUser() {

    }

    private decodeAndNotify() {
        const token = this.tokenService.getToken();
        const user = jwt_decode(token);
        console.log(user);
    }

}
