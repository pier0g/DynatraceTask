package pl.dynatrace.task;

import org.apache.commons.math3.primes.Primes;

import java.io.IOException;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PrimeNumbers {

    RandomNumberGeneratorClient randomNumberGeneratorClient = new RandomNumberGeneratorClient();
    RandomNumbersResponse response = randomNumberGeneratorClient.readRandomNumbers();

    public TreeSet extractPrimes(RandomNumbersResponse response) {
        return response.getData().stream().filter(Primes::isPrime).collect(Collectors.toCollection(TreeSet::new));
    }

    public PrimeNumbers() throws IOException {
    }
}