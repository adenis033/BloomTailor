package com.bloomtailor;

import com.bloomtailor.model.*;
import com.bloomtailor.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FlowerRepository flowerRepo;
    private final BouquetRepository bouquetRepo;
    private final StoreRepository storeRepo;
    private final UserRepository userRepo;

    public DataLoader(FlowerRepository flowerRepo, BouquetRepository bouquetRepo,
                      StoreRepository storeRepo, UserRepository userRepo) {
        this.flowerRepo = flowerRepo;
        this.bouquetRepo = bouquetRepo;
        this.storeRepo = storeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) {
        // Flowers
        flowerRepo.save(new Flower(null, "Rose", "rose.jpg", "Red", 2.50));
        flowerRepo.save(new Flower(null, "Tulip", "tulip.jpg", "Pink", 1.80));
        flowerRepo.save(new Flower(null, "Lily", "lily.jpg", "White", 3.00));
        flowerRepo.save(new Flower(null, "Sunflower", "sunflower.jpg", "Yellow", 2.00));
        flowerRepo.save(new Flower(null, "Orchid", "orchid.jpg", "Purple", 4.50));
        flowerRepo.save(new Flower(null, "Daisy", "daisy.jpg", "White", 1.50));

        // Bouquets
        bouquetRepo.save(new Bouquet(null, "Spring Mix", "spring-mix.jpg", "Fresh spring flowers", 35.00, true));
        bouquetRepo.save(new Bouquet(null, "Elegant White", "elegant-white.jpg", "Elegant occasions", 45.00, false));
        bouquetRepo.save(new Bouquet(null, "Romantic Red", "romantic-red.jpg", "Red roses", 50.00, true));
        bouquetRepo.save(new Bouquet(null, "Wildflowers", "wildflowers.jpg", "Natural wildflower arrangement", 30.00, true));
        bouquetRepo.save(new Bouquet(null, "Premium Roses", "premium-roses.jpg", "Our finest rose selection", 55.00, false));
        bouquetRepo.save(new Bouquet(null, "Tropical Vibes", "tropical-vibes.jpg", "Exotic tropical flowers", 40.00, true));

        // Stores
        storeRepo.save(new Store(null, "BloomTailor Central", "Strada Florilor 15", "+40 123 456 789", "Mon-Sun: 9-20"));
        storeRepo.save(new Store(null, "BloomTailor North", "Bulevardul Primaverii 22", "+40 987 654 321", "Mon-Sun: 10-19"));

        // Users
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = new User("user1", encoder.encode("user1"));
        user1.getRoles().add(Role.ROLE_USER);
        User user2 = new User("admin", encoder.encode("admin"));
        user2.getRoles().add(Role.ROLE_ADMIN);

        userRepo.save(user1);
        userRepo.save(user2);
    }
}
