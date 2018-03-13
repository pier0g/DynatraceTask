package pl.dynatrace.task;

import org.apache.commons.math3.primes.Primes;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class PrimeNumbers {

    public TreeSet extractPrimes(RandomNumbersResponse response) {
        return response.getData().stream().filter(Primes::isPrime).collect(Collectors.toCollection(TreeSet::new));
    }
}
