import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { CarRegisterComponent } from './car-register.component';
import { CarApiService } from '../../services/car-api.service';
import { spyOn } from 'jasmine';

describe('CarRegisterComponent', () => {
  let component: CarRegisterComponent;
  let fixture: ComponentFixture<CarRegisterComponent>;
  let carApiMock: CarApiService;

  const responseMock = {
    brand = "brand";
    model = "model";
    color = "color";
    transmission = "AUTO";
    year: 2000;
    price: 200000;
  }

  const errorMock = {
    brand: string = "brand"
  }

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarRegisterComponent],
      providers: [CarApiService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarRegisterComponent);
    carApiMock = TestBed.inject(CarApiService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deve cadastrar carro com dados válidos', () => {
    spyOn(carApiMock, 'postCar')

    component.carForm.controls['brand'].setValue('brand');
    component.carForm.controls['model'].setValue('model');
    component.carForm.controls['color'].setValue('color');
    component.carForm.controls['transmission'].setValue('transmission');
    component.carForm.controls['year'].setValue(2000);
    component.carForm.controls['price'].setValue(20000);

    const submitButton = fixture.debugElement.query(By.css('button[type="submit"]'));
    submitButton.triggerEventHandler('click', null);
    fixture.detectChanges();

    expect(carApiMock).toHaveBeenCalled();
    expect(carApiMock).toEqual(responseMock);
  })
});
