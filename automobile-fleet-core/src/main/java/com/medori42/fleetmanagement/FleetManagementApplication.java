package com.medori42.fleetmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Main application class for the Fleet Service.
 * This microservice manages vehicle inventory, details, and fleet operations
 * within the Vehicle Fleet Management System.
 *
 * <p>
 * It interacts with other services via the Registry and Gateway to providing
 * a comprehensive fleet management solution.
 * </p>
 *
 * @author Radim Yassine
 * @version 1.0.0
 * @since 2024-01
 */
@SpringBootApplication
public class FleetManagementApplication {

    /**
     * Délai de connexion en millisecondes pour les appels HTTP.
     */
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;

    /**
     * Délai de lecture en millisecondes pour les appels HTTP.
     */
    private static final int HTTP_READ_TIMEOUT = 5000;

    /**
     * Point d'entrée principal de l'application Fleet Management.
     * Initialise le contexte Spring Boot et démarre le serveur.
     *
     * @param commandLineArgs les arguments de la ligne de commande
     */
    public static void main(String[] commandLineArgs) {
        SpringApplication.run(FleetManagementApplication.class, commandLineArgs);
    }

    /**
     * Configure et fournit un bean RestTemplate pour la communication HTTP.
     * Définit les délais de connexion et de lecture pour une communication
     * fiable entre les microservices.
     *
     * @return une instance RestTemplate configurée avec les timeouts appropriés
     */
    @Bean
    public RestTemplate httpRestTemplate() {
        RestTemplate restTemplateInstance = new RestTemplate();
        SimpleClientHttpRequestFactory httpRequestConfiguration = new SimpleClientHttpRequestFactory();
        httpRequestConfiguration.setConnectTimeout(HTTP_CONNECTION_TIMEOUT);
        httpRequestConfiguration.setReadTimeout(HTTP_READ_TIMEOUT);
        restTemplateInstance.setRequestFactory(httpRequestConfiguration);
        return restTemplateInstance;
    }
}
