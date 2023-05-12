package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarroServiceImplTest {
    private CarroService carroService;
    private Carro celtinha;

    @Before
    public void setUp() {
        carroService = new CarroServiceImpl();
        celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Given
        carroService.ligar(celtinha);

        // When
        carroService.acelerar(celtinha, 10);

        // Then
        // Assertivas
        // O Junit busca por Asserts no método para validar que o teste passou
        Assert.assertTrue(celtinha.getVelocidadeAtual() == 10);
    }

    @Test
    public void deveLigarCorretamente() {
        // Quando
        carroService.ligar(celtinha);

        // Então
        Assert.assertTrue(celtinha.isLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {
        // Quando:
        carroService.ligar(celtinha);
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveNaoAcelerarEstandoDesligado() {
        // Quando:
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertFalse(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }


    @Test
    public void deveNaoFreiarEstandoDesligado() {
        // Quando:
        carroService.frear(celtinha, 10);

        // Então:
        Assert.assertFalse(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveNaoDesligarEstandoEmMovimento() {
        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);
        carroService.desligar(celtinha);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveNaoFreiarMaisDoQueAVelocidadeAtual() {
        // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);
        carroService.frear(celtinha, 20);
        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveNaoPassarDaVelocidadeMaxima() {
       // Quando:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);
        carroService.acelerar(celtinha, 10);
        carroService.acelerar(celtinha, 25);
        carroService.acelerar(celtinha, 10);

        // Então:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(45, celtinha.getVelocidadeAtual());
    }
}
