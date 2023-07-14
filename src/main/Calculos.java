package main;

import view.Jogo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculos {
    static Jogo jogo;
    private int nivel;

    private int valor1;
    private int valor2;
    private int operacao;
    private int resultado;


    public Calculos(int nivel) {
        Random random = new Random();
        this.operacao = 3;//random.nextInt(3); //0-somar, 1-diminuir, 2-multiplicar, 3-dividir
        this.nivel = nivel;

        if (nivel == 1) {
            //facil
            this.valor1 = random.nextInt(10);
            this.valor2 = (int) (Math.random() * 10) + 1;
        } else if (nivel == 2) {
            //medio
            this.valor1 = random.nextInt(100);
            this.valor2 = (int) (Math.random() * 100) + 1;
        } else if (nivel == 3) {
            //dificil
            this.valor1 = random.nextInt(1000);
            this.valor2 = (int) (Math.random() * 1000) + 1;
        }
    }


    public int getNivel() {
        return nivel;
    }

    public int getValor1() {
        return valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public int getOperacao() {
        return operacao;
    }

    public int getResultado() {
        return resultado;
    }

    public String toString() {
        String opcao;
        if (this.getOperacao() == 0) {
            opcao = "Somar";
        } else if (this.getOperacao() == 1) {
            opcao = "Subtrair";
        } else if (this.getOperacao() == 2) {
            opcao = "multiplicar";

        } else if (this.getOperacao() == 3) {
            opcao = "Dividir";
        } else {
            opcao = "Opção inválida";
        }
        return "valor = 1 " + this.getValor1()
                + "\nValor2 = " + this.getValor2()
                + "\nOperação = " + opcao +
                "\nDificuldade = " + this.getNivel();

    }

    public boolean somar(int valor) {
        this.resultado = this.getValor1() + this.getValor2();
        boolean estaCerto = false;

        if (valor == this.resultado) {
            estaCerto = true;
            System.out.println("Parabéns você acertou");
            System.out.println(this.getValor1() + " + " + this.getValor2() + " = " + this.getResultado());
        } else {
            System.out.println("Resposta errada, estude um pouco mais!");
            System.out.println(this.getValor1() + " + " + this.getValor2() + " = " + this.getResultado());
        }
        return estaCerto;
    }

    public boolean subtrair(int valor) {
        this.resultado = this.getValor1() - this.getValor2();
        boolean estaCerto = false;

        if (valor == this.resultado) {
            estaCerto = true;
            System.out.println("Parabéns você acertou");
            System.out.println(this.getValor1() + " - " + this.getValor2() + " = " + this.getResultado());
        } else {
            System.out.println("Resposta errada, estude um pouco mais!");
            System.out.println(this.getValor1() + " - " + this.getValor2() + " = " + this.getResultado());
        }
        return estaCerto;
    }

    public boolean multiplicar(int valor) {
        this.resultado = this.getValor1() * this.getValor2();
        boolean estaCerto = false;

        if (valor == this.resultado) {
            estaCerto = true;
            System.out.println("Parabéns você acertou");
            System.out.println(this.getValor1() + " * " + this.getValor2() + " = " + this.getResultado());
        } else {
            System.out.println("Resposta errada, estude um pouco mais!");
            System.out.println(this.getValor1() + " * " + this.getValor2() + " = " + this.getResultado());
        }
        return estaCerto;
    }


    public boolean dividir(Double valor) {
        Double resultado = (this.getValor1() / (double) this.getValor2());
        boolean estaCerto = false;

        if (arredonda(valor).equals(arredonda(resultado))) {
            estaCerto = true;
            System.out.println("Parabéns você acertou");
            System.out.println(this.getValor1() + " / " + this.getValor2() + " = " + arredonda(resultado));
        } else {
            System.out.println("Resposta errada, estude um pouco mais!");
            System.out.println(this.getValor1() + " / " + this.getValor2() + " = " + arredonda(resultado));

        }
        return estaCerto;
    }

    private String arredonda(Double numero) {
        NumberFormat formatter = new DecimalFormat("#.###");
        return formatter.format(numero);
    }
}