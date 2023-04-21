import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProuductService } from '../services/prouduct.service';
import { ReviewService } from '../services/review.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})
export class FrontPageComponent implements OnInit {

  imagePath = "src/assets/background2.jpg";
  reviewCount: Object = 0;
  productCount: Object = 0;
  userCount: Object = 0;
  constructor(private router: Router, private reviewService: ReviewService, private productService: ProuductService, private userService: UserService) { }

  ngOnInit(): void {
    this.getReviewCount();
    this.getProudctCount();
    this.getUserCount();
  }

  getReviewCount() {
    this.reviewService.getReviewCount().subscribe((res) => {
      this.reviewCount = res;
    });
  }

  getProudctCount() {
    this.productService.getProductsCount().subscribe((res) => {
      this.productCount = res;
    });
  }

  getUserCount() {
    this.userService.getUserCount().subscribe((res) => {
      this.userCount = res;
    });
  }

}
