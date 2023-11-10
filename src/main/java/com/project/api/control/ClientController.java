package com.project.api.control;

import com.project.api.model.Client;
import com.project.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientRepository cliRepo;

    @GetMapping("/select/all")
    public List<Client> selectAll(){
        return cliRepo.findAll();
    }

    @GetMapping("/select/id/{id}")
    public Optional<Client> selectById(@PathVariable("id") int id){
        return cliRepo.findById(id);
    }

    @GetMapping("/select/name/{name}")
    public List<Client> selectByPartialName(@PathVariable("name") String partialName) {
        return cliRepo.findByPartialName(partialName);
    }

    @GetMapping("/select/email/{email}")
    public List<Client> selectByEmail(@PathVariable("email") String email) {
        return cliRepo.findByEmail(email);
    }

    @GetMapping("/select/filter/nameEmail/{name}/{email}")
    public List<Client> selectByNameAndEmail(@PathVariable("name") String name, @PathVariable("email") String email) {
        return cliRepo.findByNameAndEmail(name, email);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Client client){
        cliRepo.save(client);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Client client){
        cliRepo.delete(client);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") int id) {
        cliRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Client client){
        cliRepo.save(client);
    }
}
