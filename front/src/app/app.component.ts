import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgFor } from '@angular/common'
import { CarApiService } from './services/car-api.Service';

@Component({
  selector: 'app-root',
  imports: [ RouterOutlet, NgFor ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [ CarApiService ]
})
export class AppComponent {
  title = 'front';
  cars!: any[];

  constructor(carApiService: CarApiService) {
    carApiService.getCars().subscribe((cars: any) => this.cars = cars);
  }
}
