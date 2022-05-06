import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { ItemComponent } from './components/item/item.component';
import { ItemsComponent } from './components/items/items.component';
import { UpdateItemComponent } from './components/update-item/update-item.component';

import { ItemService } from './services/item.service';

const appRoutes: Routes = [
  {path: 'addItem', component: AddItemComponent},
  {path: 'items', component: ItemsComponent},
  {path: 'postDetails/:id', component: ItemComponent},
  {path: 'upDateItem/:id', component: UpdateItemComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AddItemComponent,
    ItemComponent,
    ItemsComponent,
    UpdateItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [
    ItemService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
