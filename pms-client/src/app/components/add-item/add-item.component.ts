import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemMaster } from 'src/app/model/ItemMaster';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  item: ItemMaster = new ItemMaster();
  submitted = false;

  constructor(
    private itemService: ItemService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  
  newItem(): void {
    this.submitted = false;
    this.item = new ItemMaster();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  save() {
    this.itemService.addItem(this.item).subscribe(data => {
      console.log(data)
      this.item = new ItemMaster();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  gotoList() {
    this.router.navigate(['/items']);
  }

}
