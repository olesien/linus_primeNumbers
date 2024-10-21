package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Prime Calculator 1000!");
        var calc = new CalculatePrimes();
        var primes = calc.calculate(0, 1000);
        calc.printCount(primes);
        calc.printSum(primes);
    }
}