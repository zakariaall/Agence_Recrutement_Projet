package com.workify.agence_recrut.controller;

import com.workify.agence_recrut.entites.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.workify.agence_recrut.service.EntrepriseService;

@RestController
@RequestMapping("/")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    // Endpoint pour l'enregistrement d'une entreprise
    @PostMapping("/register")
    public ResponseEntity<Entreprise> registerEntreprise(@RequestParam String name, @RequestParam String ville, @RequestParam String email, @RequestParam String password, @RequestParam String confPassword,@RequestParam String telephone) {
        try {
            // Appel au service pour enregistrer l'entreprise
            Entreprise entreprise = entrepriseService.registerEntreprise(name, ville, email, password, confPassword,telephone);

            return ResponseEntity.ok(entreprise); // Retourne l'entreprise enregistrée avec un code 200
        } catch (IllegalArgumentException e) {
            // En cas d'erreur de validation (par exemple email déjà utilisé ou mots de passe non correspondants)
            return ResponseEntity.badRequest().body(null); // Retourne une réponse avec code 400 (Bad Request)
        }
    }
    @GetMapping("/")
    public String testEndpoint() {
        return "API Entreprise accessible !";
    }
}
