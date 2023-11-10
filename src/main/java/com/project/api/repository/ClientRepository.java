package com.project.api.repository;

import com.project.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT * FROM client c WHERE c.name like ?1%", nativeQuery = true)
    List<Client> findByPartialName(String partialName);

    @Query(value = "SELECT * FROM client c WHERE c.name like %?1% AND c.email like %?2% ", nativeQuery = true)
    List<Client> findByNameAndEmail(String name, String email);

    List<Client> findByEmail(String email);
}
