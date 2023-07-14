package view;

import main.Calculos;

import java.util.Scanner;

public class Jogo {
    static Scanner input = new Scanner(System.in);
    static int pontos = 0;
    static Calculos calculos;

    public static void main(String[] args) {
        Jogo.play();
    }

    public static void play() {
        System.out.println("Informe o nível de dificuldade desejado[digite 1 para o nível fácil, 2 para o nível médio ou 3 para o nível difícil:]");
        int nivel = Jogo.input.nextInt();
        Jogo.calculos = new Calculos(nivel);

        System.out.println("Informe o resultado para a seguinte operação: ");
        int resposta;

        switch (calculos.getOperacao()) {
            case 0:
                System.out.println(calculos.getValor1() + " + " + calculos.getValor2());
                resposta = Jogo.input.nextInt();
                if (calculos.somar(resposta)) {
                    Jogo.pontos += 1;
                    System.out.println("Você tem " + Jogo.pontos + " ponto(s).");
                }
                break;
            case 1:
                System.out.println(calculos.getValor1() + " - " + calculos.getValor2());
                resposta = Jogo.input.nextInt();
                if (calculos.subtrair(resposta)) {
                    Jogo.pontos += 1;
                    System.out.println("Você tem " + Jogo.pontos + " ponto(s).");
                }
                break;
            case 2:
                System.out.println(calculos.getValor1() + " * " + calculos.getValor2());
                resposta = Jogo.input.nextInt();
                if (calculos.multiplicar(resposta)) {
                    Jogo.pontos += 1;
                    System.out.println("Você tem " + Jogo.pontos + " ponto(s).");
                }
                break;
            case 3:
                System.out.println(calculos.getValor1() + " / " + calculos.getValor2());
                System.out.println("OBS.: Informe até 3 casas decimais.");
                Double respostadiv = Jogo.input.nextDouble();
                if (calculos.dividir(respostadiv)) {
                    Jogo.pontos += 1;
                    System.out.println("Você tem " + Jogo.pontos + " ponto(s).");
                }
                break;
            default:
                System.out.println("A operação " + calculos.getOperacao() + "não é reconhecida");
        } Jogo.continuar();

    }

    public static void continuar() {
        System.out.println("Deseja continuar?[1- sim, 0- não]");
        int continuar = Jogo.input.nextInt();
        if (continuar == 1) {
            Jogo.play();
        } else {
            System.out.println("Sua pontuação final foi de  " + Jogo.pontos + " pts.");
            System.out.println("Até a próxima");
            System.exit(0);
        }
    }
}
