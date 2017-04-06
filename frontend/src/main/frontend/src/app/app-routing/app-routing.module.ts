import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoffeeDetailsComponent }   from '../coffee/coffee-details/coffee-details.component';
import { CoffeeListComponent }   from '../coffee/coffee-list/coffee-list.component';
import { AddCoffeeComponent }   from '../coffee/add-coffee/add-coffee.component';
import { ImageUploadComponent} from "../coffee/image-upload/image-upload.component";
const routes: Routes = [
  { path: '', redirectTo: '/coffee-list', pathMatch: 'full' },
  { path: 'coffee-list',  component: CoffeeListComponent },
  { path: 'add-coffee',  component: AddCoffeeComponent },
  { path: 'detail/:id', component: CoffeeDetailsComponent },
  { path: 'image-upload/:id', component: ImageUploadComponent },
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
