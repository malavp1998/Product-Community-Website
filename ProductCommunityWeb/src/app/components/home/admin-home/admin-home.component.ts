import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProuductService } from 'src/app/services/prouduct.service';
import { ReviewService } from 'src/app/services/review.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  closeResult = '';
  userName: any = ""
  activeTab = 'search';
  reviews: any = [];
  approveReviewCount = 0;
  unApproveReviewCount = 0;
  productCount = 0;
  products: any = [];

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private userSer: UserService, private productService: ProuductService, private modalService: NgbModal, private reviewService: ReviewService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.userName = params.get('name');
    });
    this.getReviews();
    this.getProudcts();
  }

  getReviews() {
    this.reviewService.getReviews().subscribe((res) => {
      this.reviews = res;
      this.setReviewCount(this.reviews);
    })
  }

  getProudcts() {
    this.productService.getProuducts().subscribe((res) => {
      this.products = res;
      this.addAvgRatingsToProducts();
    })
  }

  addAvgRatingsToProducts() {
    for (var product in this.products) {
      let p: any = this.products[product]
      let reviews = (p["productReviews"]);
      //  console.log("p,", reviews);
      let count = 0;
      let rating = 0;
      for (var review in reviews) {
        let rev = reviews[review];
        if (rev["reviewApproved"] == true) {
          rating = rating + rev["rating"];
          count = count + 1;
        }
      }
      p["avgRating"] = rating / count;
    }
  }

  setReviewCount(reviews: []) {
    this.approveReviewCount = 0;
    this.unApproveReviewCount = 0;
    for (var review in reviews) {
      {
        let r = reviews[review]
        if (r["reviewApproved"] == true) {
          this.approveReviewCount = this.approveReviewCount + 1;
        }
        else {
          this.unApproveReviewCount = this.unApproveReviewCount + 1;
        }
      }
    }
  }
  ApproveReview(reviewId: number) {
    this.reviewService.approveReview(reviewId).subscribe(() => {
      this.getReviews();
    });
  }

  unApproveReview(reviewId: number) {
    this.reviewService.unApproveReview(reviewId).subscribe(() => {
      this.getReviews();
    });
  }

  addProudct(formObj: any) {
    if (formObj.name != "" && formObj.code != "" && formObj.price != "" && formObj.brand != "") {
      this.productService.addProduct(formObj).subscribe(() => {
        this.getProudcts();
      });
    }
  }

  search(activeTab: string, $event: MouseEvent): void {
    $event.preventDefault();
    this.activeTab = activeTab;
  }

  result(activeTab: string, $event: MouseEvent): void {
    $event.preventDefault();
    this.activeTab = activeTab;
  }



  open(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      },
    );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
