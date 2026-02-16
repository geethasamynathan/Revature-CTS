package com.ittechgenie.secureshop.seed;

import com.ittechgenie.secureshop.entity.*;
import com.ittechgenie.secureshop.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final PasswordEncoder encoder;

    public DataSeeder(RoleRepository roleRepo, UserRepository userRepo,
                      ProductRepository productRepo, PasswordEncoder encoder) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {

        Role adminRole = roleRepo.findByName("ROLE_ADMIN").orElseGet(() -> roleRepo.save(new Role("ROLE_ADMIN")));
        Role userRole  = roleRepo.findByName("ROLE_USER").orElseGet(() -> roleRepo.save(new Role("ROLE_USER")));

        // admin
        userRepo.findByUsername("admin").orElseGet(() -> {
            AppUser admin = new AppUser("admin", encoder.encode("Admin@123"));
            admin.getRoles().add(adminRole);
            return userRepo.save(admin);
        });

        // user
        userRepo.findByUsername("user1").orElseGet(() -> {
            AppUser user = new AppUser("user1", encoder.encode("User1@123"));
            user.getRoles().add(userRole);
            return userRepo.save(user);
        });

        // sample products
        if (productRepo.count() == 0) {
            productRepo.save(new Product("Laptop", 65000, 10));
            productRepo.save(new Product("Mouse", 700, 50));
            productRepo.save(new Product("Keyboard", 1500, 25));
        }

        System.out.println("✅ Seed completed: roles + users(admin/user1) + products");
    }
}
