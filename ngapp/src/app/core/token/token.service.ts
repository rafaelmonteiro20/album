import { Injectable } from '@angular/core';

const KEY_TOKEN = 'token';

@Injectable({ providedIn: 'root' })
export class TokenService {

    setToken(token: string) {
        window.localStorage.setItem(KEY_TOKEN, token);
    }

    getToken(): string {
        return window.localStorage.getItem(KEY_TOKEN);
    }

    removeToken() {
        window.localStorage.removeItem(KEY_TOKEN);
    }

    hasToken(): boolean {
        return !!this.getToken();
    }

}
