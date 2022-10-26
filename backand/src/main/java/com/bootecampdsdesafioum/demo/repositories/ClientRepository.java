package com.bootecampdsdesafioum.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootecampdsdesafioum.demo.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
