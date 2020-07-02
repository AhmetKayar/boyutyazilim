package com.boyutyazilim.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = {MediaType.APPLICATION_JSON_VALUE})

public class ValuesController {

    @CacheEvict(value = "values",allEntries = true)
    @GetMapping("clean")
    public ResponseEntity cleanCache(){

        return ResponseEntity.ok().build();
    }
    @GetMapping("/values")
    @Cacheable("values")
    public ResponseEntity<String> values() {
        return ResponseEntity.ok("Hello Word");
    }
}
