import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProuductService } from 'src/app/services/prouduct.service';
import { ReviewService } from 'src/app/services/review.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  closeResult = '';
  currentRating: number = 0;
  userName: any = ""
  products: any = [];
  reviews: any = [];
  activeProductId: number = 0;
  searhString = "";
  constructor(private activatedRoute: ActivatedRoute, private router: Router, private userSer: UserService, private productService: ProuductService, private modalService: NgbModal, private reviewService: ReviewService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      this.userName = params.get('name');
    });
    this.getProudcts();
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
      console.log(rating + " " + count);
      p["avgRating"] = rating / count;
    }
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

  showReview(id: number) {
    console.log("id", id)
    for (var product in this.products) {
      let p: any = this.products[product]
      if (p["productId"] == id) {
        this.reviews = p["productReviews"];
      }
    }
  }

  addReview(review: any) {
    if (review.review != "" && review.rating != 0) {
      this.reviewService.addReview(this.activeProductId, review).subscribe(() => {
        this.getProudcts();
      });
    }
  }
  setActiveProductId(id: number) {
    this.activeProductId = id;
  }

  searchProduct() {
    if (this.searhString != "") {
      this.productService.getProductsBySearchString(this.searhString).subscribe((res) => {
        this.products = res;
      })
    }
    else {
      this.getProudcts();
      this.searhString = "";
    }


  }

}
