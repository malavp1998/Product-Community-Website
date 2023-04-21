import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }

  addReview(productId: number, review: any) {
    return this.http.post("http://localhost:8080/api/review/" + productId, review);
  }

  approveReview(reviewId: number) {
    return this.http.get("http://localhost:8080/api/review/approve/" + reviewId);
  }

  unApproveReview(reviewId: number) {
    return this.http.get("http://localhost:8080/api/review/unapprove/" + reviewId);
  }

  getReviewCount() {
    return this.http.get("http://localhost:8080/api/review/count");
  }

  getReviews() {
    return this.http.get("http://localhost:8080/api/review");
  }

}
