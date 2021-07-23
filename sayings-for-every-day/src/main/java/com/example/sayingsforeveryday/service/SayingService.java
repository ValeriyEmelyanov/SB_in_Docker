package com.example.sayingsforeveryday.service;

import com.example.sayingsforeveryday.model.Saying;

import java.util.List;

public interface SayingService {
    List<Saying> getAll();
    Saying getRandom();
    Saying save(Saying saying);
    void deleteById(Integer id);
}
