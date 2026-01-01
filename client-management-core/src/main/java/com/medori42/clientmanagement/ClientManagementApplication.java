package com.medori42.clientmanagement;

import com.medori42.clientmanagement.domain.ClientEntity;
import com.medori42.clientmanagement.persistence.ClientDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main application class for the Customer Service.
 * This microservice handles customer data persistence and management logic
 * as part of the Vehicle Fleet Management System.
 *
 * <p>
 * Registered with Eureka Server for dynamic discovery.
 * </p>
 *
 * @author Radim Yassine
 * @version 1.0.0
 * @since 2024-01
 * @see ClientEntity
 * @see ClientDataRepository
 */
@SpringBootApplication
public class ClientManagementApplication {

    /**
     * Crée et configure le bean d'initialisation de données de démonstration.
     * Ce bean est exécuté au démarrage de l'application pour peupler
     * la base de données avec des enregistrements de test.
     *
     * @param clientDataRepository le repository d'accès aux données clients
     * @return un CommandLineRunner qui initialise les données de démonstration
     */
    @Bean
    CommandLineRunner loadInitialData(ClientDataRepository clientDataRepository) {
        return commandLineArgs -> {
            clientDataRepository.save(new ClientEntity(1L, "Amine SAFI", 23.0f));
            clientDataRepository.save(new ClientEntity(2L, "Amal ALAOUI", 22.0f));
            clientDataRepository.save(new ClientEntity(3L, "Samir RAMI", 22.0f));
        };
    }

    /**
     * Point d'entrée principal de l'application Client Management.
     * Lance le contexte Spring Boot et démarre le serveur embarqué.
     *
     * @param applicationArgs les arguments de ligne de commande
     */
    public static void main(String[] applicationArgs) {
        SpringApplication.run(ClientManagementApplication.class, applicationArgs);
    }
}
