package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

class SimuladorEsperaTest {

    @Test
//  @Disabled("Não é mais aplicável")
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void deveEsperarENaoDarTimeout() {
//      Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: não deve ser utilizado em PROD");
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}