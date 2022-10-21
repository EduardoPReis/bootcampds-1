package com.bootecampdsdesafioum.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootecampdsdesafioum.demo.entities.Client;

@RestController
@RequestMapping(value ="/clients" )
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findall(){
		List<Client> clientlist = new ArrayList<>();
		clientlist.add(new Client(1L,"Eduardo Reis", "44104315977",5.000,null,0));
		
		return ResponseEntity.ok().body(clientlist);
	}
	
}
