package pl.dynatrace.task;

import java.io.IOException;


public class Task {
    public static void main(String[] args) throws IOException {

        RandomNumberGeneratorClient randomNumberGeneratorClient = new RandomNumberGeneratorClient();
        RandomNumbersResponse response = randomNumberGeneratorClient.readRandomNumbers();

        PrimeNumbers primeNumbers = new PrimeNumbers();
        System.out.println("Data: " + response.getData());
        System.out.println("Prime numbers: " + primeNumbers.extractPrimes(response));
    }
}
