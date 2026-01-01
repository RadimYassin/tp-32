package com.medori42.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service Registry Application.
 * Deploys a Eureka Server to manage the service registry for the
 * Vehicle Fleet Management System.
 *
 * <p>
 * Enables dynamic service discovery and load balancing capabilities.
 * </p>
 *
 * @author Radim Yassine
 * @version 1.0.0
 * @since 2024-01
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    /**
     * Point d'entrée principal du serveur de registre.
     * Initialise le contexte Spring Boot et démarre le serveur Eureka.
     *
     * @param startupArguments les arguments de démarrage de l'application
     */
    public static void main(String[] startupArguments) {
        SpringApplication.run(ServiceRegistryApplication.class, startupArguments);
    }
}
