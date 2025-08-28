import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CarApiService } from '../../services/car-api.service';

@Component({
  selector: 'app-car-register',
  imports: [ ReactiveFormsModule, CommonModule ],
  templateUrl: './car-register.component.html',
  styleUrl: './car-register.component.css',
  providers: [ CarApiService ]
})
export class CarRegisterComponent {
  carForm!: FormGroup;
  btnType!: string;
  submitted!: boolean;
  submitStatus!: TemplateRef<any>;

  @ViewChild('success') success!: TemplateRef<any>;
  @ViewChild('fail') fail!: TemplateRef<any>;

  constructor(private carApiService: CarApiService) {
    this.btnType = 'btn btn-secondary mt-4';
  }

  ngOnInit(): void {
    this.carForm = new FormGroup({
      brand: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      color: new FormControl('', Validators.required),
      transmission: new FormControl('', Validators.required),
      carYear: new FormControl(2000, [Validators.minLength(4), Validators.maxLength(5), Validators.pattern(/^[0-9]*$/)]),
      price: new FormControl(0., Validators.required)
    })
  }
  
  onChange() {
    if (this.carForm.invalid) { 
      this.btnType = 'btn btn-secondary mt-4'; 
    }
    else { 
      this.btnType = 'btn btn-primary mt-4'; 
    }
  }

  onSubmit() {
    let car: Car = this.carForm.value;
    this.submitted = true;

    this.carApiService.postCar(car).subscribe(
      response => {
        console.log(response);
        this.btnType = 'btn btn-success mt-4';
        this.submitStatus = this.success;
      },
      error => {
        console.log(error);
        this.btnType = 'btn btn-danger mt4';
        this.submitStatus = this.fail;
      }
    )
    this.carForm.reset();
  }
}
