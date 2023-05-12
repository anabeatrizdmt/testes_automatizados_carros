package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {

    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {
        if (!carro.isLigado()){
            System.out.println("Você precisa ligar o carro antes");
            return;
        }
        if ((carro.getVelocidadeAtual() + velocidadeAMais) > carro.getVelocidadeMaxima()) {
            System.out.println("Devido ao limite de velociade não é possível acelerar mais " + velocidadeAMais);
            return;
        }
        carro.setVelocidadeAtual(carro.getVelocidadeAtual() + velocidadeAMais);
    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        if (!carro.isLigado()){
            System.out.println("Você precisa ligar o carro antes");
            return;
        }
        if ((carro.getVelocidadeAtual() - velocidadeAMenos) < 0) {
            System.out.println("Você está mais devagar do que deseja freiar");
            return;
        }
        carro.setVelocidadeAtual(carro.getVelocidadeAtual() - velocidadeAMenos);
    }

    @Override
    public void ligar(Carro carro) {
        if (carro.isLigado()) {
            System.out.println("O carro já está ligado");
            return;
        }
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        if (!carro.isLigado()) {
            System.out.println("O carro já está desligado");
            return;
        }
        if (carro.getVelocidadeAtual() != 0) {
            System.out.println("A velocidade do carro precisa ser zero. A velocidade atual é: " + carro.getVelocidadeAtual());
            return;
        }
        carro.setLigado(false);
    }

    @Override
    public String estadoAtual(Carro carro) {
        return carro.toString();
    }
}
