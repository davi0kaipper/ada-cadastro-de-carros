import { Component } from '@angular/core';
import { NgIf, NgFor } from '@angular/common';
import { CarApiService } from '../../services/car-api.service';

@Component({
  selector: 'app-car-list',
  imports: [ NgIf, NgFor ],
  templateUrl: './car-list.component.html',
  providers: [ CarApiService ]
})
export class CarListComponent {
  cars!: any[];

  constructor(private carApiService: CarApiService) {
    this.carApiService.getCars().subscribe((cars: any) => this.cars = cars);
  }

}
