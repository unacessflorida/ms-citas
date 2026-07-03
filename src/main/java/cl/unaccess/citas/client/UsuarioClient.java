package cl.unaccess.citas.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class UsuarioClient {

    private final WebClient webClient;

    public UsuarioClient(@Qualifier("authWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean existeProfesional(String username) {
        try {
            webClient.get()
                .uri("/api/v1/usuarios/{username}", username)
                .retrieve()
                .toBodilessEntity()
                .block();
            return true;
        } catch (WebClientResponseException.NotFound e) {
            return false;
        }
    }
}