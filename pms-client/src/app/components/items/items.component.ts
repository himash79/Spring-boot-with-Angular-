import { Observable } from 'rxjs';
import { ItemService } from '../../services/item.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemMaster } from '../../model/ItemMaster';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  items!: Observable<ItemMaster[]>;
  selectValue: string = "";
  filterPriceField: string = "";
  selectValueByCategory: string = "";

  constructor(
    private itemService: ItemService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllItems();
  }

  getAllItems() {
    return this.items = this.itemService.getItems();
  }

  deletePost(id: string) {
    this.itemService.deleteItem(id).subscribe(data => {
      console.log(data);
      this.getAllItems();
    }, error => {
      console.log(error);
    });
  }

  updatePost(id: string){
    this.router.navigate(['upDateItem', id]);
  }

  postDetails(id: string) {
    console.log('post details viewed ! ' + id);
    this.router.navigate(['postDetails', id]);
  }

  filterAvailableItems () {
    this.items = this.itemService.getFilterAvailableItems(this.selectValue);
  }

  filterByPrice() {
    this.items = this.itemService.getItemsByPrice(this.filterPriceField);
  }

  filterCategoryItems() {
    this.items = this.itemService.getItemsByCategory(this.selectValueByCategory);
  }

}
