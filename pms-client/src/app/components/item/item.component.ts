
import { ItemService } from './../../services/item.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemMaster } from 'src/app/model/ItemMaster';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  id: string = "";
  item: ItemMaster = new ItemMaster()

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.itemService.getItem(this.id).subscribe(data => {
      this.item = data;
    }, error => {
      console.log('Exception found on view post details ' + this.id);
      console.log(error);
      
    });
  }

  list() {
    this.router.navigate(["items"])
  }
}
