package com.project.api.control;

import com.project.api.model.Cliente;
import com.project.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository cliRepo;

    @GetMapping("/select/all")
    public List<Cliente> selectAll(){
        return cliRepo.findAll();
    }

    @GetMapping("/select/id/{id}")
    public Optional<Cliente> selectById(@PathVariable("id") int id){
        return cliRepo.findById(id);
    }

    @GetMapping("/select/nome/{nome}")
    public List<Cliente> selectByPartialName(@PathVariable("nome") String partialName) {
        return cliRepo.findByPartialName(partialName);
    }

    @GetMapping("/select/email/{email}")
    public List<Cliente> selectByEmail(@PathVariable("email") String email) {
        return cliRepo.findByEmail(email);
    }

    @GetMapping("/select/filter/nomeEmail/{name}/{email}")
    public List<Cliente> selectByNameAndEmail(@PathVariable("name") String name, @PathVariable("email") String email) {
        return cliRepo.findByNameAndEmail(name, email);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Cliente cliente){
        cliRepo.save(cliente);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Cliente cliente){
        cliRepo.delete(cliente);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") int id) {
        cliRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Cliente cliente){
        cliRepo.save(cliente);
    }
}
