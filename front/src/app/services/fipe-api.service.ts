import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../core/models/Brand';
import { Model } from '../core/models/Model';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FipeApiService {
  http!: HttpClient

  constructor(http: HttpClient) {this.http = http;}
  
  getBrands(): Observable<Brand[]> {
    return this.http.get<Brand[]>(`${environment.carAPI}/fipe/cars/brands`);
  }

  getModels(brandId: string): Observable<Model[]>  {
    return this.http.get<Model[]>(`${environment.carAPI}/fipe/cars/brands/${brandId}/models`);
  }
}

