package de.telran.gateway;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import de.telran.model.Item;

public class ItemGateway {
	
	RestTemplate rest;
	String itemsCreaterUrl = "http://localhost:8080/items/create";
	
	public ItemGateway(RestTemplate rest) {
		this.rest = rest;
	}
	
	public boolean createItem(Item item, String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token);

		HttpEntity<Item> itemHttpEntity = new HttpEntity<>(item, httpHeaders);
		ResponseEntity<Void> responseEntity = rest.exchange(itemsCreaterUrl, HttpMethod.POST, itemHttpEntity, Void.class);
		if(responseEntity.getStatusCodeValue() == 200) {
			return true;
		} else {
			return false;
		}

	}
}
