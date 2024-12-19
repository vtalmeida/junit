package com.algaworks.junit.utilidade;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Deve saudar com Bom dia")
    public void saudarDia() {
        // Arrange
        int horaValida = 9;
        String saudacaoCorreta = "Bom dia";

        // Act
        String saudacao = SaudacaoUtil.saudar(horaValida);

        // Assert
//        assertEquals("Bom dia", saudacao);

        // Utilizando o AssertJ
//        Assertions.assertThat(saudacao)
//                .withFailMessage("Saudação incorreta!")
//                .isNotNull()
//                .isNotBlank()
//                .isEqualTo("Bom dia");

        Condition<String> bomDia = new Condition<>((str) -> str.equals(saudacaoCorreta),
                "igual a %s", saudacaoCorreta);

        Assertions.assertThat(saudacao).is(bomDia);

//       Assertions.assertThat(saudacao)
//               .as("Validando se saudção é %s", saudacao)
//               .withFailMessage("Erro: Saudação incorreta! Resultado: %s", saudacao)
//               .isEqualTo(saudacaoCorreta);
    }

    @Test
    @DisplayName("Deve saudar com Boa tarde")
    public void saudarTarde() {
        int horaValida = 16;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    @DisplayName("Deve saudar com Boa noite")
    public void saudarNoite() {
        int horaValida = 21;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    @DisplayName("Deve lançar Exception")
    public void deveLancarException() {
        int horaInvalida = -10;
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(horaInvalida));
//        assertEquals("Hora inválida", e.getMessage());

//        IllegalArgumentException e = Assertions.catchThrowableOfType(() -> SaudacaoUtil.saudar(horaInvalida), IllegalArgumentException.class);
//        Assertions.assertThat(e).hasMessage("Hora inválida");

        Assertions.assertThatThrownBy(() -> SaudacaoUtil.saudar(horaInvalida))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hora inválida");
    }

    @Test
    @DisplayName("Não deve lançar Excpetion")
    public void naoDeveLancarException() {
        int horaValida = 0;
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(horaValida));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10,11})
    public void Dado_horario_matinal_Entao_deve_retornar_bom_dia(int hora) {
        String saudacao = SaudacaoUtil.saudar(hora);
        assertEquals("Bom dia", saudacao);
    }


}