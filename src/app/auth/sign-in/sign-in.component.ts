import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-sign-in',
    templateUrl: './sign-in.component.html',
    styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
    signInForm: FormGroup;
    errorMessage: string = '';

    constructor(
        private fb: FormBuilder,
        private authService: AuthService,
        private router: Router
    ) {
        this.signInForm = this.fb.group({
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }

    onSubmit(): void {
        if (this.signInForm.valid) {
            this.authService.login(this.signInForm.value).subscribe({
                next: (success) => {
                    if (success) {
                        this.router.navigate(['/']); // Navigate to home or dashboard
                    } else {
                        this.errorMessage = 'Invalid credentials';
                    }
                },
                error: (err) => {
                    this.errorMessage = 'An error occurred during sign in.';
                    console.error(err);
                }
            });
        } else {
            this.signInForm.markAllAsTouched();
        }
    }
}
