import { Routes } from '@angular/router';
import { HomeComponent } from './core/home.component';
import { CarListComponent } from './car-list/car-list.component';

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
  }
];
