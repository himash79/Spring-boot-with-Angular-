import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemMaster } from '../model/ItemMaster';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private baseUrl1 = "http://localhost:8090/itemAPI/";

  constructor(
    private http: HttpClient
  ) { }

  getItems(): Observable<any> {
    return this.http.get(`${this.baseUrl1}getAllItems`);
  }

  getItem(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl1}getItem/${id}`);
  }

  deleteItem(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl1}deleteItem/${id}`, {responseType: 'text'});
  }

  addItem(item: ItemMaster): Observable<any> {
    return this.http.post(`${this.baseUrl1}saveItem`, item);
  }

  updateItem(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl1}updateItem/${id}`, value);
  }

  getFilterAvailableItems(param: string): Observable<any> {
    return this.http.get(`${this.baseUrl1}getAvailableItem/${param}`);
  }

  getItemsByPrice(param: string): Observable<any> {
    return this.http.get(`${this.baseUrl1}getFilteredPriceItem/${param}`);
  }

  getItemsByCategory(param: string): Observable<any> {
    return this.http.get(`${this.baseUrl1}getFilteredCategoryItem/${param}`);
  }
}
