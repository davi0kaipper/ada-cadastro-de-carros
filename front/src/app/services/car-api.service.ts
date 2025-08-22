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

  putCar(car: Car) {
    this.http.put(`${environment.carAPI}/cars`, car);
  }
}
