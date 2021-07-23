package com.example.sayingsforeveryday.service.impl;

import com.example.sayingsforeveryday.model.Saying;
import com.example.sayingsforeveryday.repository.SayingRepository;
import com.example.sayingsforeveryday.service.SayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SayingServiceImpl implements SayingService {

    private final SayingRepository sayingRepository;

    @Autowired
    public SayingServiceImpl(SayingRepository sayingRepository) {
        this.sayingRepository = sayingRepository;
    }

    @Override
    public List<Saying> getAll() {
        return sayingRepository.findAll();
    }

    @Override
    public Saying getRandom() {
        List<Saying> all = sayingRepository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Saying list is empty");
        }
        int index = (int) (Math.random() * all.size());
        return all.get(index);
    }

    @Override
    public Saying save(Saying saying) {
        return sayingRepository.save(saying);
    }

    @Override
    public void deleteById(Integer id) {
        sayingRepository.deleteById(id);
    }
}
