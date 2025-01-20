package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor converter = new Conversor();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        boolean running = true;

        while (running) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. USD para BRL");
            System.out.println("2. BRL para USD");
            System.out.println("3. EUR para USD");
            System.out.println("4. USD para EUR");
            System.out.println("5. BRL para EUR");
            System.out.println("6. EUR para BRL");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();
            if (choice == 0) {
                running = false;
                System.out.println("Obrigado por usar o Conversor de Moedas!");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            try {
                double result = converter.convert(choice, amount);
                System.out.printf("Resultado: %.2f\n", result);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}