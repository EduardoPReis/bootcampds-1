package com.bootecampdsdesafioum.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootecampdsdesafioum.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
