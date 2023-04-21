package com.nagarro.productCommunitySystem.controller.productController;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Exception in method addProduct() " + e);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/product")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Exception in method updateProduct() " + e);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method getProducts() " + e);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/count")
    public ResponseEntity<Integer> getProductCount() {
        try {
            return new ResponseEntity<>(productService.getProductsCount(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method getProductCount() " + e);
        }
        return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/{searchstring}")
    public ResponseEntity<List<Product>> getProductCount(@PathVariable("searchstring") String searchstring) {
        try {
            System.out.println("searchstring " + searchstring);
            return new ResponseEntity<>(productService.getProductsBySearchString(searchstring), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method getProductCount() " + e);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


}
