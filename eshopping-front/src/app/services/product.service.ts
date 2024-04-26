import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8081/eshopping/products';

  private categoryUrl = 'http://localhost:8081/eshopping/product-category';

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`
    return this.httpClient.get<Product[]>(searchUrl).pipe(
      map(response => {
        return response;
      })
    );
  }

  getProductCategories(): Observable<ProductCategory[]> {

    return this.httpClient.get<ProductCategory[]>(this.categoryUrl).pipe(
      map(response => response)
    );
  }
}


interface GetResponseProducts {
    products: Product[];
}

interface GetResponseProductCategory {
  productCategories: ProductCategory[];
}