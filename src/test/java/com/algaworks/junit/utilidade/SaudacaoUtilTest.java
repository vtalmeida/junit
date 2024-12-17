package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarDia() {
        assertEquals("Bom dia", SaudacaoUtil.saudar(9));
    }

    @Test
    public void saudarTarde() {
        assertEquals("Boa tarde", SaudacaoUtil.saudar(16));
    }

    @Test
    public void saudarNoite() {
        assertEquals("Boa noite", SaudacaoUtil.saudar(21));
    }

    @Test
    public void deveLancarException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }

}