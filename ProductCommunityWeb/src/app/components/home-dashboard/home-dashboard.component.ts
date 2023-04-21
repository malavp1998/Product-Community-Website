import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProuductService } from 'src/app/services/prouduct.service';
import { ReviewService } from 'src/app/services/review.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home-dashboard',
  templateUrl: './home-dashboard.component.html',
  styleUrls: ['./home-dashboard.component.css']
})
export class HomeDashboardComponent implements OnInit {

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
