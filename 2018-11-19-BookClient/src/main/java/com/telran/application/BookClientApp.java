package com.telran.application;

import dto.Book;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;

public class BookClientApp {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        /*String url = "http://localhost:8080";
//        String urn = "/startend/createDB?file=library.dta&num=20";
        String urn = "/startend/readDB?file=library.dta";
//        String urn = "/query/getAllBooks";
        URI uri = new URI(url + urn);

        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);

        ResponseEntity<Boolean> responce = restTemplate.exchange(request, Boolean.class);

        System.out.println(responce.getBody());

        urn = "/query/getAllBooks";
        uri = new URI(url + urn);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/json");
//        RequestEntity request1 = new RequestEntity(headers, HttpMethod.GET, uri);
        RequestEntity request1 = new RequestEntity(HttpMethod.GET, uri);
        System.out.println("Before ParameterizedTypeReference");
        ParameterizedTypeReference<HashMap<Long, Book>> type =
                new ParameterizedTypeReference<HashMap<Long, Book>>() {
                };

        System.out.println("before ResponseEntity");
        ResponseEntity<HashMap<Long, Book>> responce1 =
                restTemplate.exchange(request1, type);

        System.out.println("after ResponseEntity\nFeeling collection");
        Collection<Book> books = responce1.getBody().values();

        for (Book book : books) System.out.println(book);

//        System.out.println(responce1.getBody().values());
*/
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_XML);
        RequestEntity httpEntity = new RequestEntity<>(headers, HttpMethod.GET, new URI("http://localhost:8080/query/getAllBooks"));
        System.out.println(
                restTemplate.exchange(httpEntity, String.class));
    }
}
