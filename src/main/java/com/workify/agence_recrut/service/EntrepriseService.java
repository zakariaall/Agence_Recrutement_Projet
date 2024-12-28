package com.workify.agence_recrut.service;

import com.workify.agence_recrut.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.workify.agence_recrut.repository.EntrepriseRepository;

@Service
@Transactional
public class EntrepriseService {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    public Entreprise registerEntreprise(String name,String ville,String email,String password,String confPassowrd,String telephone){
        if (entrepriseRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email deja utiliser");
        }
        if(!password.equals(confPassowrd)){
            throw new IllegalArgumentException("mot de passe different du mot de passe de confirmation");
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setNomEntreprise(name);
        entreprise.setEmail(email);
        entreprise.setVille(ville);
        entreprise.setPassword(password);
        entreprise.setTelephone(telephone);
        entreprise.setRoles(Roles.ENP);


        return entrepriseRepository.save(entreprise);



    }
}
