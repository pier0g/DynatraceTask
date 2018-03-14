package pl.dynatrace.task;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PrimesExtractorTest {

    @Test
    public void extractPrimes() {
        List<Integer> testData = new ArrayList<>();
        testData.addAll(Arrays.asList(8, 90, 130, 109, 13, 38, 60, 677, 13, 999));

        Set<Integer> testResult = new TreeSet<>();
        testResult.addAll(Arrays.asList(13, 109, 677));

        RandomNumbersResponse testResponse = new RandomNumbersResponse();
        testResponse.setData(testData);

        PrimesExtractor primesExtractor = new PrimesExtractor();

        assertEquals(testResult, primesExtractor.extract(testResponse));
    }

}