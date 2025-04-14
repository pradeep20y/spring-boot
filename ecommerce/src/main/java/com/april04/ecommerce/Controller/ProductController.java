package com.april04.ecommerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.april04.ecommerce.Entity.Product;
import com.april04.ecommerce.Service.ProductService;

import java.io.IOException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct() {
        List<Product> pro = productService.getProduct();
        System.out.println(pro.get(0).getAvailable());
        return pro;
    }

    @GetMapping("/product/{id}")
    public Product getMethodById(@PathVariable int id) {
        Product pro = productService.getMethodById(id);
        return pro;
    }

    @PostMapping("/product")
    public Product savejsonimg(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) throws IOException {

        return productService.addjsonimg(product, imageFile);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getimg(@PathVariable int id) {
        Product product = productService.getMethodById(id);
        byte[] img = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(img);
    }

    @PostMapping("/post")
    public String postMethodName(@RequestBody List<Product> product) {
        return productService.postProduct(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable int id, @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) throws IOException {
        Product product1 = null;
        try {
            product1 = productService.update(id, product, imageFile);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
        if (product1 != null) {
            return new ResponseEntity<>("success", HttpStatus.OK); // ✅ correct
        }

        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable int id) {
        return productService.delete(id);
    }

}
