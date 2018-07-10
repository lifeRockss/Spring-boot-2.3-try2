/**
 * Copyright 2018 Liberty Global (http://www.libertyglobal.com) and produced by Piksel (http://www.piksel.com)
 */
package com.example.Springboot2.try2;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import reactor.core.publisher.Flux;

@RestController
@Validated
@RequestMapping("/")
public class DemoController {


    @GetMapping(value = "/search/{text}")
    public ResponseEntity<Flux<SearchResult>> search(@PathVariable(
            value = "text") String text) {
        /*  HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header-Add", "Added-Header");
        headers.set("My-Header-Set", "Set-Header");
        SearchResponse sr = new SearchResponse("Search Result");

        return new ResponseEntity<>(Flux.just(sr), headers, HttpStatus.OK);*/
        System.out.println("-------------");
        SearchResult sr = new SearchResult("Search Result");
        Flux<SearchResult> results =Flux.just(sr);
        return ResponseEntity.ok()
                .header("Header-Name", "headervalue")
                .body(results);
    }

}

@Getter
@ToString
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class SearchResult {

    public String result;
}
