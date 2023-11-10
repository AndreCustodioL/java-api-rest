package com.project.api.control;

import com.project.api.model.Cliente;
import com.project.api.model.Produto;
import com.project.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prodRepo;

    @GetMapping("/select/all")
    public List<Produto> selectAll(){
        return prodRepo.findAll();
    }

    @GetMapping("/select/id/{id}")
    public Optional<Produto> selectById(@PathVariable("id") int id){
        return prodRepo.findById(id);
    }

    @GetMapping("/select/desc/{descricao}")
    public List<Produto> selectByPartialName(@PathVariable("descricao") String partialDesc) {
        return prodRepo.findByPartialDesc(partialDesc);
    }

    @GetMapping("/select/brand/{brand}")
    public List<Produto> selectByBrand(@PathVariable("brand") String brand) {
        return prodRepo.findByBrand(brand);
    }

    @GetMapping("/select/filter/price/{price}")
    public List<Produto> selectUnderPrice(@PathVariable("price") double price) {
        return prodRepo.findUnderPrice(price);
    }

    @GetMapping("/select/filter/brandprice/{brand}/{price}")
    public List<Produto> selectByBrandAndPrice(@PathVariable("brand") String brand, @PathVariable("price") double price) {
        return prodRepo.findByBrandAndPrice(brand, price);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Produto product){
        prodRepo.save(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Produto product){
        prodRepo.delete(product);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") int id){
        prodRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Produto product){
        prodRepo.save(product);
    }
}
