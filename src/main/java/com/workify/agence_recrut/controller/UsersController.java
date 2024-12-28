package com.workify.agence_recrut.controller;


import com.workify.agence_recrut.entites.Users;

import com.workify.agence_recrut.service.CurrentUserHolder;
import com.workify.agence_recrut.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CurrentUserHolder currentUserHolder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            Users user = usersService.login(email, password);
            currentUserHolder.setCurrentUser(user);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage()); // Retourne un code 400 avec le message d'erreur
        }
    }
    @GetMapping("/current-user")
    public ResponseEntity<Users> getCurrentUser() {
        Users user = currentUserHolder.getCurrentUser();
        if (user == null) {
            return ResponseEntity.status(401).body(null); // Aucun utilisateur connecté
        }
        return ResponseEntity.ok(user);
    }


}
