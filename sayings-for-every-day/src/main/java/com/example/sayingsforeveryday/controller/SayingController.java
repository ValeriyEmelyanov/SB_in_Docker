package com.example.sayingsforeveryday.controller;

import com.example.sayingsforeveryday.dto.SayingRequestDto;
import com.example.sayingsforeveryday.model.Saying;
import com.example.sayingsforeveryday.service.SayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SayingController {

    private final SayingService sayingService;

    @Autowired
    public SayingController(SayingService sayingService) {
        this.sayingService = sayingService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Saying>> getAll() {
        return ResponseEntity.ok(sayingService.getAll());
    }

    @GetMapping("/random")
    public ResponseEntity<Saying> getRandom() {
        return ResponseEntity.ok(sayingService.getRandom());
    }

    @PostMapping("/")
    public ResponseEntity<Saying> create(@RequestBody SayingRequestDto sayingDto) {
        Saying saying = new Saying();
        saying.setText(sayingDto.getText());
        return new ResponseEntity<>(sayingService.save(saying), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        sayingService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
