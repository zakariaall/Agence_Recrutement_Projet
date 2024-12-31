package com.workify.agence_recrut.config;

import com.workify.agence_recrut.service.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsersService usersService;

    // Constructeur manuel
    public SecurityConfig(UsersService usersService) {
        this.usersService = usersService;
    }

    // Configuration de la sécurité pour l'application web
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactive la protection CSRF, utile pour les API stateless ou AJAX
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login","/register/DmdEmp","/register/Entreprise").permitAll() // Permet l'accès sans authentification à la page de connexion et de register
                        .anyRequest().authenticated() // Requiert une authentification pour toutes les autres requêtes
                )
            /*    .formLogin(form -> form
                        .loginPage("/login") // Page de connexion personnalisée
                        .defaultSuccessUrl("/home", true) // Redirection vers /home après une connexion réussie (true : redirection permanente)
                        .failureUrl("/login?error=true") // Redirection vers la page de connexion en cas d'échec
                        .permitAll() // Permet à tous les utilisateurs d'accéder à la page de connexion
                )*/
                .logout(logout -> logout
                        .logoutUrl("/logout") // Déconnexion via cette URL
                        .logoutSuccessUrl("/login?logout") // Redirection vers la page de connexion après la déconnexion
                        .permitAll() // Permet à tous d'accéder à la fonctionnalité de déconnexion
                )
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/access-denied") // Page à afficher en cas de refus d'accès
                );

        return http.build();
    }


    // Bean AuthenticationManager pour l'authentification
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(usersService) ;
        return authenticationManagerBuilder.build();
    }


}
