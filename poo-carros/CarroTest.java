import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CarroTest {
    private Carro carro;

    @BeforeEach
    void init() {
        carro = new Carro("Volkwagen", "Polo", "Preto", 30, 2023);
    }

    @Test
    void deveraAumentaVelocidadeAtualDoCarro() {
        carro.acelerar();
        final double expect = 10.0;
        final double actual = carro.getVelocidadeAtual();

        assertEquals(expect, actual);
    }


    @Test
    void deveraAcelerarOCarroAteSuaVelocidadeMaxima() {
        while (carro.getVelocidadeAtual() < carro.getVelocidadeMáxima()) {
            carro.acelerar();
        }

        final String expect = "Carro em velocidade maxima: " + carro.getVelocidadeMáxima();
        final String actual = carro.acelerar();

        assertEquals(expect, actual);

    }

    @Test
    void deveraReduzirAVelocidadeAtualDoCarroCasoAMesmaSejaMaiorOuIgualA7() {
        carro.acelerar();

        final String expect = "Velocidade atual: 3.0";
        final String actual = carro.frear();

        assertEquals(expect, actual);
    }

    @Test
    void deveraPararCarroCasoVelocidadeDepoisDeFrearSejaMenorOuIgualAZero() {
        carro.acelerar();
        carro.frear();
        final String expect = "Carro parado";
        final String actual = carro.frear();

        assertEquals(expect, actual);
    }

    @Test
    void deveraMostrarAVelocidadeAtualDoCarro() {
        carro.acelerar();
        carro.acelerar();
        carro.frear();
        final double expect = 13.0;
        final double actual = carro.getVelocidadeAtual();

        assertEquals(expect, actual);
    }

    @Test
    void deveraNaoAceleraCarroMaisQueAVelocidadeMaxima() {
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.frear();
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.acelerar();

        final double expect = carro.getVelocidadeMáxima();
        final double actual = carro.getVelocidadeAtual();

        assertEquals(expect, actual);
    }
}