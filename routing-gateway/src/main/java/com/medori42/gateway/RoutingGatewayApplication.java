package com.medori42.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

/**
 * API Gateway Application.
 * Serves as the single entry point for the Vehicle Fleet Management System,
 * handling request routing, filtering, and cross-cutting concerns.
 *
 * <p>
 * Integrates with Eureka for dynamic route definition.
 * </p>
 *
 * @author Radim Yassine
 * @version 1.0.0
 * @since 2024-01
 */
@SpringBootApplication
public class RoutingGatewayApplication {

    /**
     * Point d'entrée principal de l'application Gateway.
     * Démarre le contexte Spring Boot et le serveur de routage.
     *
     * @param launchArguments les arguments de lancement de l'application
     */
    public static void main(String[] launchArguments) {
        SpringApplication.run(RoutingGatewayApplication.class, launchArguments);
    }

    /**
     * Configure la découverte dynamique des routes via Eureka.
     * Permet la création automatique des routes pour les services
     * enregistrés dans le registre de services.
     *
     * @param reactiveClient    le client réactif de découverte de services
     * @param locatorProperties les propriétés de configuration du locator
     * @return le locator configuré pour le routage dynamique
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator configureRouteDiscovery(
            ReactiveDiscoveryClient reactiveClient,
            DiscoveryLocatorProperties locatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(reactiveClient, locatorProperties);
    }
}
