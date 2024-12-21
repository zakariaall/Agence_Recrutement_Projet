package service;

import com.workify.agence_recrut.entites.*;
import repository.EntrepriseRepository;

public class EntrepriseService {
    EntrepriseRepository entrepriseRepository;

    public Entreprise registerEntreprise(String name,String ville,String email,String password,String confPassowrd){
        if (entrepriseRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email deja utiliser");
        }
        if(!password.equals(confPassowrd)){
            throw new IllegalArgumentException("mot de passe different du mot de passe de confirmation");
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setEmail(email);
        entreprise.setVille(ville);
        entreprise.setPassword(password);
        entreprise.setRoles(Roles.ENP);


        return entrepriseRepository.save(entreprise);



    }
}
