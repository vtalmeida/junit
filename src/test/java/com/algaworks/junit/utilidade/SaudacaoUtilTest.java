package com.algaworks.junit.utilidade;

import org.assertj.core.api.Assertions;
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

        // Act
        String saudacao = SaudacaoUtil.saudar(horaValida);

        // Assert
//        assertEquals("Bom dia", saudacao);

        // Utilizando o AssertJ
        Assertions.assertThat(saudacao)
//                .withFailMessage("Saudação incorreta!")
//                .isNotNull()
//                .isNotBlank()
                .isEqualTo("Bom dia");
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
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(horaInvalida));
        assertEquals("Hora inválida", e.getMessage());
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