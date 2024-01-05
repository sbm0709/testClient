package com.demo.service;


import com.demo.dto.ShopDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Log4j2
@Service
public class RestTemplateService {
    private final String SERVICE_KEY = "KoDtJsVKUjPCWeuISpoKkT00zTW1/T3bQqcSDAI1ke1TqfceIic/UxLJF6wyx0IrGKkFWZGNevdFQ08jWlE7vg==";

    public String getShoplist(String perPage, String page){

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4")
                .queryParam("page",page)
                .queryParam("perPage",perPage)
                .queryParam("serviceKey",SERVICE_KEY)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error(responseEntity.getBody());
            return responseEntity.getBody();
        } else {
            System.out.println("Error: " + responseEntity.getStatusCodeValue());
            return null;
        }
    }

}
