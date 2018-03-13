package pl.dynatrace.task;

import java.io.IOException;


public class Task {
    public static void main(String[] args) throws IOException {

        PrimeNumbers primeNumbers = new PrimeNumbers();
        System.out.println("Data: " + primeNumbers.randomNumberGeneratorClient.readRandomNumbers().getData());
        System.out.println("Prime numbers: " + primeNumbers.extractPrimes(primeNumbers.response));
    }
}
