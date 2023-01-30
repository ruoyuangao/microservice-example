package com.example.search.controller;

import com.example.search.domain.SearchDetail;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SearchController {

    private final SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchDetail>> getDetails() {
        return new ResponseEntity<>(this.service.getAllInfo(), HttpStatus.OK);
    }
}
