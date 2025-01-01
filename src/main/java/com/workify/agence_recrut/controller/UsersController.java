package com.workify.agence_recrut.controller;

import com.workify.agence_recrut.config.JwtConfig;
import com.workify.agence_recrut.entites.Users;
import com.workify.agence_recrut.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UsersController {

    private final UsersService usersService;
    private final JwtConfig jwtConfig;

    @Autowired
    public UsersController(UsersService usersService, JwtConfig jwtConfig) {
        this.usersService = usersService;
        this.jwtConfig = jwtConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            Users user = usersService.login(email, password);

            // Générer le token
            String token = jwtConfig.generateToken(user.getEmail());

            // Créer un objet de réponse contenant l'utilisateur et le token
            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            // Renvoyer la réponse avec le token
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Déconnecté avec succès !");
    }
}