public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Volkwagen", "Polo", "Preto", 50, 2023);
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());
        carro.frear();
        System.out.println(carro.mostrarVelocidade());
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());
        carro.acelerar();
        System.out.println(carro.mostrarVelocidade());

    }
}
