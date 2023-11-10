package com.project.api.control;

import com.project.api.model.Product;
import com.project.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository prodRepo;

    @GetMapping("/select/all")
    public List<Product> selectAll(){
        return prodRepo.findAll();
    }

    @GetMapping("/select/id/{id}")
    public Optional<Product> selectById(@PathVariable("id") int id){
        return prodRepo.findById(id);
    }

    @GetMapping("/select/desc/{description}")
    public List<Product> selectByPartialDesc(@PathVariable("description") String partialDesc) {
        return prodRepo.findByPartialDesc(partialDesc);
    }

    @GetMapping("/select/brand/{brand}")
    public List<Product> selectByBrand(@PathVariable("brand") String brand) {
        return prodRepo.findByBrand(brand);
    }

    @GetMapping("/select/filter/price/{price}")
    public List<Product> selectUnderPrice(@PathVariable("price") double price) {
        return prodRepo.findUnderPrice(price);
    }

    @GetMapping("/select/filter/brandprice/{brand}/{price}")
    public List<Product> selectByBrandAndPrice(@PathVariable("brand") String brand, @PathVariable("price") double price) {
        return prodRepo.findByBrandAndPrice(brand, price);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Product product){
        prodRepo.save(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Product product){
        prodRepo.delete(product);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") int id){
        prodRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Product product){
        prodRepo.save(product);
    }
}
