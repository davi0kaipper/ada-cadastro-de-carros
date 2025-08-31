import { CurrencyPipe, NgFor, NgIf, NgTemplateOutlet, registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { CarApiService } from '../../services/car-api.service';
import { CarFormComponent } from '../../shared/car-form.component';

registerLocaleData(localePt, 'pt');

@Component({
  selector: 'app-car-list',
  imports: [ NgIf, NgFor, NgTemplateOutlet, CurrencyPipe, CarFormComponent ],
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
