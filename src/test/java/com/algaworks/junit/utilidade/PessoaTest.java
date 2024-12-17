package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    public void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Alex", "Silva");

        // Dessa forma já falha no primeiro assert, no assertAll ele verifica todas as condicoes
//        assertEquals("Alex", pessoa.getNome());
//        assertEquals("Silva", pessoa.getSobrenome());

        assertAll("Asserções de pessoa",
                () -> assertEquals("Alex", pessoa.getNome()),
                () -> assertEquals("Silva", pessoa.getSobrenome()));
    }

}