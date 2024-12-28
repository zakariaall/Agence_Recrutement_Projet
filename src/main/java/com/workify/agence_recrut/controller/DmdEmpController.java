package com.workify.agence_recrut.controller;

import com.workify.agence_recrut.entites.DmdEmp;
import com.workify.agence_recrut.service.DmdEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DmdEmpController {
    @Autowired
    private DmdEmpService dmdEmpService;

    @PostMapping("/register/DmdEmp")
    public ResponseEntity<DmdEmp> registerDmdEmp(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String tel, @RequestParam String pass, @RequestParam String confPass) {

        try {
            DmdEmp dmdEmp = dmdEmpService.registerDmdEmp(nom,prenom,email,tel,pass,confPass);

            return ResponseEntity.ok(dmdEmp);
        } catch (IllegalArgumentException e)
        {
            // En cas d'erreur de validation (par exemple email déjà utilisé ou mots de passe non correspondants)
            return ResponseEntity.badRequest().body(null); // Retourne une réponse avec code 400 (Bad Request)
        }


    }

}
