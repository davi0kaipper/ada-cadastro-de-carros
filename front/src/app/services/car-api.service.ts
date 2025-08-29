import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarApiService {
  http!: HttpClient

  constructor(http: HttpClient) {this.http = http;}
  
  getCars() {
    return this.http.get(`${environment.carAPI}/cars`);
  }

  getCarsById(id: number) {
    return this.http.get(`${environment.carAPI}/cars/${id}`);
  }

  postCar(car: Car) {
    return this.http.post(`${environment.carAPI}/cars`, car);
  }

  putPatchCar(car: Car, id: number) {
    if (car.brand && car.model && car.color && car.transmission && car.carYear && car.price)
      return this.http.put(`${environment.carAPI}/cars/${id}`, car);
    else {
      return this.http.patch(`${environment.carAPI}/cars/${id}`, car);
    }
  }

  deleteCar(id: number) {
    return this.http.delete(`${environment.carAPI}/cars/${id}`);
  }
}
