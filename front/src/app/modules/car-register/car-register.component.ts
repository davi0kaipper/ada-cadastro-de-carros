import { Component, Input, ViewChild, ViewContainerRef, TemplateRef } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CarApiService } from '../../services/car-api.service';

@Component({
  selector: 'app-car-register',
  imports: [ ReactiveFormsModule, CommonModule ],
  templateUrl: './car-register.component.html',
})
export class CarRegisterComponent {
  carForm!: FormGroup;
  btnType!: string;
  submitted!: boolean;

  @ViewChild('submitContainer', {read: ViewContainerRef}) submitContainer!: ViewContainerRef;
  @ViewChild('success') success!: TemplateRef<any>;
  @ViewChild('fail') fail!: TemplateRef<any>;
  showTemplate!: TemplateRef<any>;

  @Input() id!: number;

  constructor(private carApiService: CarApiService) {
    this.btnType = 'btn btn-secondary mt-4';

    this.carForm = new FormGroup({
      brand: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      color: new FormControl('', Validators.required),
      transmission: new FormControl('', Validators.required),
      carYear: new FormControl('2000', [Validators.minLength(4), Validators.maxLength(5), Validators.pattern(/^[0-9]*$/)]),
      price: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]*$/)])
    })

    this.carForm.valueChanges.subscribe(() => this.onChange())

  }

  onChange() {
    this.submitted = false;

    if (this.carForm.invalid) {
      this.btnType = 'btn btn-secondary mt-4';
    }
    else {
      this.btnType = 'btn btn-primary mt-4';
    }
  }

  onSubmit() {
    this.submitted = true;
    let car: Car = this.carForm.value;
    if (this.id) { this.carApiService.putPatchCar(car, this.id).subscribe(response => {
                    console.log(response);
                    this.btnType = 'btn btn-success mt-4';
                    this.submitContainer.createEmbeddedView(this.success);
                  },
                  error => {
                    console.log(error);
                    this.btnType = 'btn btn-danger mt-4';
                    this.submitContainer.createEmbeddedView(this.fail);
                  }) }
    else { this.carApiService.postCar(car).subscribe(response => {
                    console.log(response);
                    this.btnType = 'btn btn-success mt-4';
                    this.submitContainer.createEmbeddedView(this.success);
                  },
                  error => {
                    console.log(error);
                    this.btnType = 'btn btn-danger mt-4';
                    this.submitContainer.createEmbeddedView(this.fail);
                  }) }
  } 

}
