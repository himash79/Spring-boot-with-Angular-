import { ItemMaster } from 'src/app/model/ItemMaster';
import { ItemService } from './../../services/item.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  id: string = "";
  item: ItemMaster = new ItemMaster();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService
  ) { }

  ngOnInit() {
    // this.post = new Post();
    this.id = this.route.snapshot.params['id'];
    
    this.itemService.getItem(this.id)
      .subscribe(data => {
        console.log(data)
        this.item = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.itemService.updateItem(this.id, this.item)
      .subscribe(data => {
        console.log(data);
        this.item = new ItemMaster();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/items']);
  }
}
