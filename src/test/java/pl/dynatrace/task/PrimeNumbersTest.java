package pl.dynatrace.task;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class PrimeNumbersTest {

    @Test
    public void extractPrimes() throws IOException {
        List<Integer> testData = new ArrayList<>();
        testData.addAll(Arrays.asList(8, 90, 130, 109, 13, 38, 60, 677, 13, 999));

        Set<Integer> testResult = new TreeSet<>();
        testResult.addAll(Arrays.asList(13, 109, 677));

        RandomNumbersResponse testResponse = new RandomNumbersResponse();
        testResponse.setData(testData);

        PrimeNumbers primeNumbers = new PrimeNumbers();

        assertEquals(testResult, primeNumbers.extractPrimes(testResponse));
    }

}