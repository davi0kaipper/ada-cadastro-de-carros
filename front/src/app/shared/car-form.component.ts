import { CommonModule } from '@angular/common';
import { Component, Input, TemplateRef, ViewChild, ViewContainerRef } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import { MatTooltipModule } from '@angular/material/tooltip';
import { Brand } from '../core/models/Brand';
import { CarFormGroup } from '../core/models/CarFormGroup';
import { Model } from '../core/models/Model';
import { TransmissionType, TransmissionTypes } from '../core/models/TransmissionType';
import { CarApiService } from '../services/car-api.service';
import { FipeApiService } from '../services/fipe-api.service';

@Component({
  selector: 'car-form',
  imports: [ ReactiveFormsModule, CommonModule, MatInputModule, MatSelectModule, MatTooltipModule ],
  templateUrl: './car-form.component.html',
})
export class CarFormComponent {
  carForm!: FormGroup<CarFormGroup>;
  btnType!: string;
  submitted!: boolean;
  brands: Brand[] = [];
  models: Model[] = [];
  transmissionTypes: TransmissionType[] = TransmissionTypes.cases;
  errors!: any[];

  @ViewChild('submitContainer', {read: ViewContainerRef}) submitContainer!: ViewContainerRef;
  @ViewChild('success') success!: TemplateRef<any>;
  @ViewChild('fail') fail!: TemplateRef<any>;
  showTemplate!: TemplateRef<any>;

  @Input() id!: number;

  constructor(
    private carApiService: CarApiService,
    private fipeApiService: FipeApiService
  ){
    this.btnType = 'btn btn-primary mt-4';
    this.fipeApiService.getBrands().subscribe({
      next: (brands: Brand[]) => this.brands = brands
    });
    this.carForm = new FormGroup<CarFormGroup>({
      brand: new FormControl(null),
      model: new FormControl(null),
      color: new FormControl(null),
      transmission: new FormControl(null),
      year: new FormControl(null),
      price: new FormControl(null)
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
    this.btnType = 'btn btn-primary mt-4';
  }

  onSubmit() {
    this.submitted = true;
    if (this.submitContainer) { this.submitContainer.clear(); }
    let car: Car = this.carFromForm(this.carForm);
    if (this.id) {
        this.carApiService.putPatchCar(car, this.id)
        .subscribe(response => {
          console.log(response);
          this.btnType = 'btn btn-success mt-4';
          this.submitContainer.createEmbeddedView(this.success);
        },
        err => {
          console.log(err);
          this.errors = err.error.violations;
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
        err => {
          console.log(err);
          this.errors = err.error.violations;
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

