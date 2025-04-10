package com.product_catalog.repository;

import com.product_catalog.model.UserProductCatalog;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProductCatalogRepository extends JpaRepository<UserProductCatalog, Long> {
    UserProductCatalog findByUsername(@NotBlank(message = "Username is required") String username);

    boolean existsByUsername(String username);


}
