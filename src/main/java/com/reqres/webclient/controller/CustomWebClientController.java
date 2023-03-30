package com.reqres.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.reqres.webclient.data.Data;
import com.reqres.webclient.data.User;
import com.reqres.webclient.data.ResourceData;
import com.reqres.webclient.data.Resource;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 4800, allowCredentials = "false", allowedHeaders = "*")
@RestController
public class CustomWebClientController {

    @Autowired
    private WebClient webClient;

    // @GetMapping("/auth")
    // public Mono<User> getAuth(@PathVariable String id){

    //    return webClient.get()
    //             .uri("/users/{id}", id)
    //             .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    //             .retrieve()
    //             .bodyToMono(User.class);
    // }

    @GetMapping("/users/{id}")
    public Mono<User> getUser(@PathVariable String id){

        return webClient.get()
            .uri("/users/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(User.class);
    }

    @GetMapping("/users")
    public Mono<String> getUsers(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int per_page){

        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/users/")
                .queryParam("page", page)
                .queryParam("per_page", per_page)
                .build())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String.class);
    }

    @PostMapping("/users")
    public Mono<String> createUser(final Data data){

        return webClient.post()
            .uri("/register")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(data), Data.class)
            .retrieve()
            .bodyToMono(String.class);
    }

    @PutMapping("/users/{id}")
    public Mono<String> updateUser(@PathVariable String id, @RequestBody Data data){

        return webClient.put()
            .uri("/users/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header("Origin", "http://localhost:8081")
            .body(Mono.just(data), Data.class)
            .retrieve()
            .bodyToMono(String.class);
    } 
    
    @DeleteMapping("/users/{id}")
    public Mono<String> deleteUser(@PathVariable String id){

        return webClient.delete()
            .uri("/users/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header("Origin", "http://localhost:8081")
            .retrieve()
            .bodyToMono(String.class);
    }     

    // Resources
    @GetMapping("/resources/{id}")
    public Mono<Resource> getResource(@PathVariable String id){

        return webClient.get()
            .uri("/resources/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(Resource.class);
    }

    @GetMapping("/resources")
    public Mono<String> getResources(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int per_page){

        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/resources/")
                .queryParam("page", page)
                .queryParam("per_page", per_page)
                .build())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String.class);
    }

    @PostMapping("/resources")
    public Mono<String> createResource(final ResourceData data){

        return webClient.post()
            .uri("/resource")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(data), ResourceData.class)
            .retrieve()
            .bodyToMono(String.class);
    }

    @PutMapping("/resources/{id}")
    public Mono<String> updateResource(@PathVariable String id, @RequestBody ResourceData data){

        return webClient.put()
            .uri("/resources/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header("Origin", "http://localhost:8081")
            .body(Mono.just(data), ResourceData.class)
            .retrieve()
            .bodyToMono(String.class);
    } 
    
    @DeleteMapping("/resources/{id}")
    public Mono<String> deleteResource(@PathVariable String id){

        return webClient.delete()
            .uri("/resources/{id}", id)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header("Origin", "http://localhost:8081")
            .retrieve()
            .bodyToMono(String.class);
    }    

}
