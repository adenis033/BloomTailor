package com.bloomtailor.service;

import com.bloomtailor.model.Flower;
import com.bloomtailor.repository.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public Optional<Flower> getFlowerById(Long id) {
        return flowerRepository.findById(id);
    }

    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }

    public void deleteFlower(Long id) {
        flowerRepository.deleteById(id);
    }
}
