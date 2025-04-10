package com.product_catalog.service;

import com.product_catalog.model.UserProductCatalog;
import com.product_catalog.repository.UserProductCatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProductCatalogService {

    private final UserProductCatalogRepository userProductCatalogRepository;
    private final PasswordEncoder passwordEncoder;

    public UserProductCatalog registerNewUser(UserProductCatalog user) {
        if (userProductCatalogRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with username " + user.getUsername() + " already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userProductCatalogRepository.save(user);
    }
}
