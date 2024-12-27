package service;

import  java.util.*;
import com.workify.agence_recrut.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DmdEmpRepository;

@Service
@Transactional
public class DmdEmpService {
    @Autowired
    DmdEmpRepository dmdEmpRepository;

    public DmdEmp registerDmdEmp(String nom, String prenom, String email, String tel, String pass, String confPass){
        if (dmdEmpRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email deja utiliser");
        }
        if(!pass.equals(confPass)){
            throw new IllegalArgumentException("mot de passe different que le mot de passe de confirmation");

        }
    DmdEmp dmdEmp = new DmdEmp();
        dmdEmp.setNom(nom);
        dmdEmp.setPrenom(prenom);
        dmdEmp.setEmail(email);
        dmdEmp.setTelephone(tel);
        dmdEmp.setPassword(pass);
        dmdEmp.setRoles(Roles.DMDEMP);
    return dmdEmpRepository.save(dmdEmp);
    }
}
