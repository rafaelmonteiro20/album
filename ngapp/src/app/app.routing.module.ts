import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PhotoListComponent } from './photos/photo-list/photo-list.component';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { PhotoListResolver } from './photos/photo-list/photo-list.resolver';
import { SignInComponent } from './home/signin/signin.component';
import { SignUpComponent } from './home/signup/signup.component';
import { LoginGuard } from './core/auth/login.guard';
import { PhotoFormComponent } from './photos/photo-form/photo-form.component';

const routes: Routes = [
    { 
        path: '', 
        component: SignInComponent,
        canActivate: [ LoginGuard ] 
    },
    { 
        path: 'signup', 
        component: SignUpComponent 
    },
    { 
        path: ':userName', 
        component: PhotoListComponent,
        resolve: {
            photos: PhotoListResolver
        } 
    },
    { 
        path: 'p/add', 
        component: PhotoFormComponent
    },
    { 
        path: '**', 
        component: NotFoundComponent 
    }
]

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
