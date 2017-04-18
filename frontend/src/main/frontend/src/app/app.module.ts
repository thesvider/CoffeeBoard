import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AlertModule } from 'ng2-bootstrap';
import { RatingModule } from 'ng2-bootstrap';
import { CarouselModule } from 'ng2-bootstrap';
import { CollapseModule } from 'ng2-bootstrap';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import { CoffeeDetailsComponent } from './coffee/coffee-details/coffee-details.component';
import { CoffeeListComponent } from './coffee/coffee-list/coffee-list.component';
import { CoffeeService } from "./coffee/shared/coffee.service";
import { NavComponent } from './shared/nav/nav.component';
import { AppRoutingModule }     from './app-routing/app-routing.module';
import { AddCoffeeComponent } from './coffee/add-coffee/add-coffee.component';
import { ImageUploadModule} from "angular2-image-upload";
import { ImageUploadComponent } from './coffee/image-upload/image-upload.component';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    CoffeeDetailsComponent,
    CoffeeListComponent,
    NavComponent,
    AddCoffeeComponent,
    ImageUploadComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AlertModule.forRoot(),
    CarouselModule.forRoot(),
    CollapseModule.forRoot(),
    RatingModule.forRoot(),
    ImageUploadModule.forRoot(),
    AppRoutingModule
  ],
  providers: [CoffeeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
