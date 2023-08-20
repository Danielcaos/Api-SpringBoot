package com.api.database.controller;


import com.api.database.model.Search;
import com.api.database.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/")
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/search")
    public List<Search> getAllProducts() {
        return searchRepository.findAll();
    }

    @PostMapping("/search")
    public Search create(@RequestBody Search search) {
        return searchRepository.save(search);
    }

}
