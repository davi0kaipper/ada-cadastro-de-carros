import { Component, OnInit, ViewChild, TemplateRef, LOCALE_ID } from '@angular/core';
import { NgIf, NgFor, NgTemplateOutlet, CurrencyPipe, registerLocaleData } from '@angular/common';
import { CarApiService } from '../../services/car-api.service';
import { CarRegisterComponent } from '../car-register/car-register.component';
import localePt from '@angular/common/locales/pt'

registerLocaleData(localePt, 'pt');

@Component({
  selector: 'app-car-list',
  imports: [ NgIf, NgFor, NgTemplateOutlet, CurrencyPipe, CarRegisterComponent ],
  templateUrl: './car-list.component.html',
  providers: [ CarApiService ]
})
export class CarListComponent implements OnInit {
  cars!: Car[];
  car!: Car;

  @ViewChild('carInfo') carInfo!: TemplateRef<any>;
  @ViewChild('carUpdate') carUpdate!: TemplateRef<any>;
  showTemplate!: TemplateRef<any>;

  constructor(private carApiService: CarApiService) { }

  ngOnInit(): void {
    this.carApiService.getCars().subscribe((cars: any) => this.cars = cars);
  }

  onClick(car: Car) {
    this.car = car;
    this.showTemplate = this.carInfo;
  }

  update(car: Car) {
    this.showTemplate = this.carUpdate;
    this.car = car;
  }

  delete(id: number) {
    this.carApiService.deleteCar(id).subscribe(() => this.ngOnInit());
  }

}
