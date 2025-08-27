import { Routes } from '@angular/router';
import { HomeComponent } from './core/home.component';
import { CarListComponent } from './modules/car-list/car-list.component';
import { CarRegisterComponent } from './modules/car-register/car-register.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'cars',
    component: CarListComponent
  },
  {
    path: 'register',
    component: CarRegisterComponent
  }
];
