import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProuductService {

  constructor(private http: HttpClient) { }

  addProduct(product: object) {
    return this.http.post("http://localhost:8080/api/product", product);
  }

  getProuducts() {
    return this.http.get("http://localhost:8080/api/products");
  }

  getProductsCount() {
    return this.http.get("http://localhost:8080/api/products/count");
  }

  getProductsBySearchString(searchString:string) {
    return this.http.get("http://localhost:8080/api/products/"+ searchString);
  }



}
