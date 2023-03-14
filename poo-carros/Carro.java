public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private double velocidadeMáxima;
    private double velocidadeAtual;
    private int ano;


    public Carro(String marca, String modelo, String cor, double velocidadeMáxima, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocidadeMáxima = velocidadeMáxima;
        this.velocidadeAtual = 0;
        this.ano = ano;
    }

    public double getVelocidadeMáxima() {
        return velocidadeMáxima;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public String acelerar() {
        int acelera = 0;
        while (this.velocidadeAtual < this.velocidadeMáxima && acelera != 10) {
            this.velocidadeAtual++;
            acelera++;
        }
        return mostrarVelocidade();
    }

    public String frear() {
        int freio = 0;
        while (this.velocidadeAtual > 0 && freio != 7) {
            this.velocidadeAtual--;
            freio++;
        }
        return mostrarVelocidade();
    }

    public String mostrarVelocidade() {
        if (this.velocidadeAtual == this.velocidadeMáxima) {
            return "Carro em velocidade maxima: " + this.velocidadeAtual;
        }
        if (this.velocidadeAtual == 0) {
            return "Carro parado";
        }
        return "Velocidade atual: " + this.velocidadeAtual;
    }
}
