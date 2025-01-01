package com.workify.agence_recrut.service;

import com.workify.agence_recrut.config.JwtConfig;
import com.workify.agence_recrut.entites.Users;
import com.workify.agence_recrut.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service

@Transactional

public class UsersService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);
    @Autowired
    private  UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Tentative de chargement de l'utilisateur avec l'email : {}", email);

        Users user = usersRepository.findByEmail(email);
        if (user == null) {
            logger.error("Utilisateur non trouvé avec l'email : {}", email);
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }

        // Convertir le rôle en tableau de chaînes de caractères
        String[] roles = { user.getRoles().name() };

        logger.debug("Utilisateur trouvé : {} avec le rôle : {}", user.getEmail(), roles[0]);

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // Utilisation du mot de passe en texte clair
                .roles(roles) // Utiliser le rôle converti
                .build();
    }

    public Users login(String email, String password) {
        logger.info("Tentative de connexion pour l'utilisateur avec l'email : {}", email);
        JwtConfig jwtConfig = new JwtConfig();

        Users user = usersRepository.findByEmail(email);
        if (user == null) {
            logger.error("Utilisateur non trouvé avec l'email : {}", email);
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }

        // Comparaison directe du mot de passe sans hachage
        if (!password.equals(user.getPassword())) {
            logger.warn("Mot de passe incorrect pour l'utilisateur : {}", email);
            throw new IllegalArgumentException("Mot de passe incorrect !");
        }
        String token = jwtConfig.generateToken(user.getEmail());
        logger.info("Connexion réussie pour l'utilisateur : {}", email);
        return user;
    }
}
