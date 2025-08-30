import { CommonModule } from '@angular/common';
import { Component, Input, TemplateRef, ViewChild, ViewContainerRef } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import { MatTooltipModule } from '@angular/material/tooltip';
import { Brand } from '../../core/models/Brand';
import { CarFormGroup } from '../../core/models/CarFormGroup';
import { Model } from '../../core/models/Model';
import { TransmissionType, TransmissionTypes } from '../../core/models/TransmissionType';
import { CarApiService } from '../../services/car-api.service';
import { FipeApiService } from '../../services/fipe-api.service';

@Component({
  selector: 'app-car-register',
  imports: [ ReactiveFormsModule, CommonModule, MatInputModule, MatSelectModule, MatTooltipModule ],
  templateUrl: './car-register.component.html',
})
export class CarRegisterComponent {
  carForm!: FormGroup<CarFormGroup>;
  btnType!: string;
  submitted!: boolean;
  brands: Brand[] = [];
  models: Model[] = [];
  transmissionTypes: TransmissionType[] = TransmissionTypes.cases;

  @ViewChild('submitContainer', {read: ViewContainerRef}) submitContainer!: ViewContainerRef;
  @ViewChild('success') success!: TemplateRef<any>;
  @ViewChild('fail') fail!: TemplateRef<any>;
  showTemplate!: TemplateRef<any>;

  @Input() id!: number;

  constructor(
    private carApiService: CarApiService,
    private fipeApiService: FipeApiService
  ){
    this.btnType = 'btn btn-secondary mt-4';
    this.fipeApiService.getBrands().subscribe({
      next: (brands: Brand[]) => this.brands = brands
    });
    this.carForm = new FormGroup<CarFormGroup>({
      brand: new FormControl(null, Validators.required),
      model: new FormControl(null, Validators.required),
      color: new FormControl('', Validators.required),
      transmission: new FormControl(null, Validators.required),
      year: new FormControl(2000, [Validators.minLength(4), Validators.maxLength(5), Validators.pattern(/^[0-9]*$/)]),
      price: new FormControl(0, [Validators.required, Validators.pattern(/^[0-9]*$/)])
    })

    this.carForm.valueChanges.subscribe(() => this.onChange())
  }

  onBrandChange(event: MatSelectChange<Brand>) {
    const brand = event.value;
    this.carForm.value.model = null;
    this.fipeApiService.getModels(brand.code).subscribe({
      next: (models: Model[]) => this.models = models
    });
  }

  onChange() {
    this.submitted = false;
    console.log(this.carForm.value);
    if (this.carForm.invalid) {
      this.btnType = 'btn btn-secondary mt-4';
    }
    else {
      this.btnType = 'btn btn-primary mt-4';
    }
  }

  onSubmit() {
    this.submitted = true;
    let car: Car = this.carFromForm(this.carForm);
    if (this.id) {
        this.carApiService.putPatchCar(car, this.id)
        .subscribe(response => {
          console.log(response);
          this.btnType = 'btn btn-success mt-4';
          this.submitContainer.createEmbeddedView(this.success);
        },
        error => {
          console.log(error);
          this.btnType = 'btn btn-danger mt-4';
          this.submitContainer.createEmbeddedView(this.fail);
        }
      )
    }
    else {
      this.carApiService.postCar(car).subscribe(
        response => {
          console.log(response);
          this.btnType = 'btn btn-success mt-4';
          this.submitContainer.createEmbeddedView(this.success);
        },
        error => {
          console.log(error);
          this.btnType = 'btn btn-danger mt-4';
          this.submitContainer.createEmbeddedView(this.fail);
        }
      )
    }
  }

  carFromForm(carForm: FormGroup<CarFormGroup>): Car {
    const brand: string = carForm.value.brand?.name as string;
    const model: string = carForm.value.model?.name as string;
    const color: string = carForm.value.color as string;
    const transmission: string = carForm.value.transmission?.value as string;
    const year: number = carForm.value.year as number;
    const price: number = carForm.value.price as number;

    const car: Car = {
      id: 0,
      brand,
      model,
      color,
      transmission,
      year,
      price
    };

    return car;
  }

  getModelPlaceHolder() {
    const placeholder = this.carForm.value.brand == null ? "Você precisa selecionar uma marca primeiro" : "Selecione um modelo";
    return placeholder;
  }
}

