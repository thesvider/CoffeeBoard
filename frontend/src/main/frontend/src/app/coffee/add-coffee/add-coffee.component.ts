import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CoffeeService } from '../shared/coffee.service';
import {Coffee} from "../shared/coffee";

@Component({
  selector: 'app-add-coffee',
  templateUrl: './add-coffee.component.html',
  styleUrls: ['./add-coffee.component.css']
})
export class AddCoffeeComponent implements OnInit {

  private coffee: Coffee;
  private error: any;

  constructor(private router:Router, private coffeeService:CoffeeService) {
  }

  ngOnInit() {
    this.coffee = new Coffee();
  }

  saveCoffee():void {
    this.coffeeService
      .saveCoffee(this.coffee)
      .then(coffeeList => {
        this.router.navigate(['/coffee-list']);
      })
      .catch(error => this.error = error);

  }


}
