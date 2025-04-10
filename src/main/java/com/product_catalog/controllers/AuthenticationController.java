package com.product_catalog.controllers;


import com.product_catalog.config.security.JwtUtil;
import com.product_catalog.model.UserProductCatalog;
import com.product_catalog.model.dtos.AuthRequest;
import com.product_catalog.model.dtos.AuthResponse;
import com.product_catalog.service.UserProductCatalogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserProductCatalogService userProductCatalogService;


    @PostMapping("/register")
    public ResponseEntity<UserProductCatalog> registerUser(@Valid @RequestBody UserProductCatalog user) {
        UserProductCatalog createdUser = userProductCatalogService.registerNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            String token = jwtUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}
