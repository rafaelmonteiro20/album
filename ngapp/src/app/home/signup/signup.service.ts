import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewUser } from './new-user';

@Injectable({ providedIn: 'root' })
export class SignUpService {

    constructor(private http: HttpClient) { }

    checkUserNameTaken(userName: string) {
        return this.http.get(`http://localhost:8080/users/exists/${userName}`);
    }

    save(newUser: NewUser) {
        return this.http.post(`http://localhost:8080/users`, newUser);
    }

}
