package com.city.smartcity.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class UserConfig {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Bean
    CommandLineRunner init_users() {
        return args -> {
            User admin = userRepository.save(
                    new User(
                            "amine",
                            "amine",
                            "maroc",
                            "admin@gmail.com",
                            passwordEncoder.encode("admin"),
                            true,
                            true,
                            true,
                            true,
                            "ROLE_ADMIN"));
            User etudiant = userRepository.save(
                    new User(
                            "amine",
                            "amine",
                            "maroc",
                            "etudiant@gmail.com",
                            passwordEncoder.encode("etudiant"),
                            true,
                            true,
                            true,
                            true,
                            "ROLE_ETUDIANT"));
            User touriste = userRepository.save(
                    new User(
                            "amine",
                            "amine",
                            "france",
                            "touriste@gmail.com",
                            passwordEncoder.encode("touriste"),
                            true,
                            true,
                            true,
                            true,
                            "ROLE_TOURISTE"));
            User affaire = userRepository.save(
                    new User(
                            "amine",
                            "amine",
                            "Espagne",
                            "affaire@gmail.com",
                            passwordEncoder.encode("affaire"),
                            true,
                            true,
                            true,
                            true,
                            "ROLE_AFFAIRE"));
            User emploi = userRepository.save(
                    new User(
                            "amine",
                            "amine",
                            "maroc",
                            "emploi@gmail.com",
                            passwordEncoder.encode("emploi"),
                            true,
                            true,
                            true,
                            true,
                            "ROLE_EMPLOI"));

        };
    }

}
