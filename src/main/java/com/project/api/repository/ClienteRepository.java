package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente c WHERE c.nome like ?1%", nativeQuery = true)
    List<Cliente> findByPartialName(String partialName);

    @Query(value = "SELECT * FROM cliente c WHERE c.nome like %?1% AND c.email like %?2% ", nativeQuery = true)
    List<Cliente> findByNameAndEmail(String nome, String email);

    List<Cliente> findByEmail(String email);
}
