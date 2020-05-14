import { Injectable } from '@angular/core';

const KEY_TOKEN = 'token';

@Injectable({ providedIn: 'root' })
export class TokenService {

    setToken(token): void {
        window.localStorage.setItem(KEY_TOKEN, token);
    }

}
