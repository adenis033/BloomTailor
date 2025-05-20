package com.bloomtailor.controller;

import com.bloomtailor.repository.BouquetRepository;
import com.bloomtailor.repository.FlowerRepository;
import com.bloomtailor.repository.StoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final FlowerRepository flowerRepo;
    private final BouquetRepository bouquetRepo;
    private final StoreRepository storeRepo;

    public HomeController(FlowerRepository flowerRepo, BouquetRepository bouquetRepo, StoreRepository storeRepo) {
        this.flowerRepo = flowerRepo;
        this.bouquetRepo = bouquetRepo;
        this.storeRepo = storeRepo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("flowers", flowerRepo.findAll());
        model.addAttribute("bouquets", bouquetRepo.findAll());
        model.addAttribute("stores", storeRepo.findAll());
        return "home";
    }
}
