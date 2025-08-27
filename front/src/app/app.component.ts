import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgFor } from '@angular/common'
import { CarApiService } from './services/car-api.service';
import { NavbarComponent } from './core/navbar.component';

@Component({
  selector: 'app-root',
  imports: [ RouterOutlet, NavbarComponent ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'front';
}
