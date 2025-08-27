import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CarApiService } from '../../services/car-api.service';

@Component({
  selector: 'app-car-register',
  imports: [ ReactiveFormsModule ],
  templateUrl: './car-register.component.html',
  styleUrl: './car-register.component.css',
  providers: [ CarApiService ]
})
export class CarRegisterComponent {
  carForm!: FormGroup;

  constructor(private carApiService: CarApiService) {}

  ngOnInit(): void {
    this.carForm = new FormGroup({
      brand: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      color: new FormControl('', Validators.required),
      transmission: new FormControl('', Validators.required),
      carYear: new FormControl('', Validators.pattern(/^[0-9]*$/))
    })
  }

  onSubmit() {
    let car: Car = this.carForm.value;
    this.carApiService.postCar(car).subscribe(
      response => console.log(response)
    )
  }
}
