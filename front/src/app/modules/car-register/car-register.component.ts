import { Component } from '@angular/core';
import { CarFormComponent } from '../../shared/car-form.component';

@Component({
  selector: 'app-car-register',
  imports: [ CarFormComponent ],
  templateUrl: './car-register.component.html',
})
export class CarRegisterComponent {

  constructor(){ }

}
