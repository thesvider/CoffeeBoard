import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable'
import 'rxjs/add/operator/toPromise'
import { Coffee } from './coffee';
import {Review} from "./review";

@Injectable()
export class CoffeeService {

  private coffeeURL = 'api/coffee';  // URL to web API

  constructor(private http:Http) {
  }

  getCoffeeList():Promise<Coffee[]> {
    return this.http
      .get(this.coffeeURL)
      .toPromise()
      .then(response => response.json() as Coffee[])
      .catch(this.handleError);
  }

  getCoffee(id):Promise<Coffee> {
    return this.http
      .get(this.coffeeURL + "/" + id)
      .toPromise()
      .then(response => response.json() as Coffee)
      .catch(this.handleError);
  }

  saveCoffee(coffee:Coffee):Promise<Coffee> {
    let headers = new Headers({
      'Content-Type': 'application/json'
    });

    return this.http
      .post(this.coffeeURL, JSON.stringify(coffee), {headers: headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  saveReview(review:Review):Promise<Review> {
    let headers = new Headers({
      'Content-Type': 'application/json'
    });

    return this.http
      .post(this.coffeeURL + "/review", JSON.stringify(review), {headers: headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  private extractData(res:Response) {
    let body = res.json();
    return body.data || {};
  }

  private handleError(error:Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg:string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
