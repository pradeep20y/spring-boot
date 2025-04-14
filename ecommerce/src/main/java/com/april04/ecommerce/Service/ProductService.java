package com.april04.ecommerce.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.april04.ecommerce.Entity.Product;
import com.april04.ecommerce.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getProduct() {
        return repo.findAll();
    }

    public String postProduct(List<Product> product) {
        repo.saveAll(product);
        return "Success";
    }

    public Product getMethodById(int id) {
        Optional<Product> optpro = repo.findById(id);
        return optpro.get();
    }

    public Product addjsonimg(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product update(int id, Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public String delete(int id) {

        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return "unsuccess";
        }

        return "success";
    }

}
