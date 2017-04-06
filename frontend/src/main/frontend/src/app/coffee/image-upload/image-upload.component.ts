import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.component.html',
  styleUrls: ['./image-upload.component.css']
})
export class ImageUploadComponent implements OnInit {

  coffeeId : number;
  private sub: any;      // -> Subscriber

  constructor(private route: ActivatedRoute, private  router: Router) { }

  ngOnInit() {
    this.sub = this.route
      .params
      .subscribe(params => {
        this.coffeeId = params['id'];
        if(this.coffeeId) {
          console.log(this.coffeeId);
        }
      });
  }

  public goToImageDetails(coffeeId): void {
    this.router.navigate(['/detail', coffeeId]);
  }

}
