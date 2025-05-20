package com.bloomtailor.controller;

import com.bloomtailor.model.Bouquet;
import com.bloomtailor.model.Flower;
import com.bloomtailor.repository.BouquetRepository;
import com.bloomtailor.repository.FlowerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final FlowerRepository flowerRepo;
    private final BouquetRepository bouquetRepo;

    public AdminController(FlowerRepository flowerRepo, BouquetRepository bouquetRepo) {
        this.flowerRepo = flowerRepo;
        this.bouquetRepo = bouquetRepo;
    }

    @GetMapping
    public String adminHome(Model model) {
        model.addAttribute("flowers", flowerRepo.findAll());
        model.addAttribute("bouquets", bouquetRepo.findAll());
        model.addAttribute("newFlower", new Flower());
        model.addAttribute("newBouquet", new Bouquet());
        return "admin";
    }

    @PostMapping("/flowers/add")
    public String addFlower(@ModelAttribute Flower flower) {
        flowerRepo.save(flower);
        return "redirect:/admin";
    }

    @PostMapping("/flowers/delete/{id}")
    public String deleteFlower(@PathVariable Long id) {
        flowerRepo.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/bouquets/add")
    public String addBouquet(@ModelAttribute Bouquet bouquet) {
        bouquetRepo.save(bouquet);
        return "redirect:/admin";
    }

    @PostMapping("/bouquets/delete/{id}")
    public String deleteBouquet(@PathVariable Long id) {
        bouquetRepo.deleteById(id);
        return "redirect:/admin";
    }
}
