import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    constructor() { }

    login(credentials: any): Observable<boolean> {
        // Mock login
        console.log('Login attempt', credentials);
        return of(true);
    }

    register(userData: any): Observable<boolean> {
        // Mock registration
        console.log('Register attempt', userData);
        return of(true);
    }
}
