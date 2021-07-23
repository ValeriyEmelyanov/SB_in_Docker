package com.example.sayingsforeveryday.repository;


import com.example.sayingsforeveryday.model.Saying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SayingRepository extends JpaRepository<Saying, Integer> {
}
