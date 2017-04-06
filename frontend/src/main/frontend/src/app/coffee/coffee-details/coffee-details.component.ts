import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CoffeeService } from '../shared/coffee.service';
import { Coffee } from '../shared/coffee';
import {Review} from "../shared/review";

@Component({
  selector: 'app-coffee-details',
  templateUrl: './coffee-details.component.html',
  styleUrls: ['./coffee-details.component.css']
})
export class CoffeeDetailsComponent implements OnInit {

  private sub: any;      // -> Subscriber
  private coffeeId: number;
  private coffee: Coffee;
  private review: Review;
  private error;
  public isCollapsed:boolean = true;
  public max: number = 10;
  public rate: number = 7;

  constructor(private route: ActivatedRoute, private router: Router, private coffeeService: CoffeeService) { }

  ngOnInit() {
    this.review = new Review();
    this.sub = this.route
      .params
      .subscribe(params => {
        this.coffeeId = params['id'];
        if(this.coffeeId) {
          this.getCoffee(this.coffeeId);
        }
      });
  }

  getCoffee(id): void {
    this.coffeeService
      .getCoffee(id)
      .then(coffee =>{
        this.coffee = coffee;
        console.log(coffee);
      } )
      .catch(error => this.error = error);
  }

  saveReview(): void {
    this.review.coffee = this.coffee;
    this.coffeeService
      .saveReview(this.review)
      .then(review =>{
        this.review = new Review();
        this.getCoffee(this.coffeeId);
        this.isCollapsed = true;
      } )
      .catch(error => this.error = error);
  }

  goToImageUpload(coffeeId): void {
    this.router.navigate(['/image-upload', coffeeId]);
  }

  public collapsed(event:any):void {
    console.log(event);
  }

  public expanded(event:any):void {
    console.log(event);
  }


}
