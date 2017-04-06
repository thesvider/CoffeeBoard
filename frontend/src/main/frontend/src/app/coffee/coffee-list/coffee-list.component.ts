import { Component, OnInit } from '@angular/core';
import { Coffee } from '../shared/coffee';
import { CoffeeService } from '../shared/coffee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-coffee-list',
  templateUrl: './coffee-list.component.html',
  styleUrls: ['./coffee-list.component.css']
})
export class CoffeeListComponent implements OnInit {

  coffeeList: Coffee[];
  error: any;


  constructor(private router: Router, private coffeeService: CoffeeService) { }

  ngOnInit(): void  {
    this.getCoffeeList();
  }

  getCoffeeList(): void {
    this.coffeeService
      .getCoffeeList()
      .then(coffeeList => this.coffeeList = coffeeList)
      .catch(error => this.error = error);
  }

  goToDetail(coffeeId): void {
    this.router.navigate(['/detail', coffeeId]);
  }

  goToNewCoffee(): void {
    this.router.navigate(['/add-coffee']);
  }

}
