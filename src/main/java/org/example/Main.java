package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Väkommen till primkalkylator 1000!");
        var calc = new CalculatePrimes();
        Scanner sc = new Scanner(System.in);
        int from = 0;
        int to = 0;

        try {
            System.out.print("Skriv in från (min 0): ");
            from = sc.nextInt();
            System.out.print("Skriv in till (max 100): ");
            to = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ogiltig input! Var god skriv in ett heltal.");
            return; // Exit the program if input is not an integer.
        } finally {
            sc.close();
        }
        try {
            var primes = calc.calculate(from, to);
            calc.printCount(primes, from, to);
            calc.printSum(primes);
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }

    }
}