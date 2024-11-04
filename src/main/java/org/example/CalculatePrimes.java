package org.example;

import java.util.ArrayList;

public class CalculatePrimes {

    void printCount(ArrayList<Integer> nums, Integer from, Integer to) {
        System.out.printf("Hej! det finns %d primtal mellan %d och %d", nums.size(), from, to);
    }

    Integer sumNumbers(ArrayList<Integer> nums) {
       return nums.stream()
                .mapToInt(a -> a)
                .sum();
    }

    void printSum(ArrayList<Integer> nums) {
        Integer sum = sumNumbers(nums);
        System.out.printf("\nOch den totala summan av dessa primtal är %d", sum);

    }
    ArrayList<Integer> calculate (int from, int to) throws IllegalArgumentException {
        ArrayList<Integer> primes = new ArrayList<>();
        if (from < 0 || to > 1000 || to < 0 || from > to) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }
        if (from < 2) {
            from = 2; //Min
        }
        if (to < 2) {
            return primes; //Early return empty array
        }
        System.out.println(from + " " + to);
        boolean notPrime;
       for (int i = from; i <= to; i++) {
           notPrime = false;
           for (int j = 2; j < i; j++) {
               if (i % j == 0) {
                   notPrime = true;
                   break; //We have our answer for this one.
               }
           }
           if (!notPrime) {
               primes.add(i);
           }
       }
        return primes;
    }
}
