package br.com.ag;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class AgMainApplicationTests {

    @Test
    void contextLoads() {
        // Verifica se o contexto da aplicação carrega sem problemas.
    }
}
