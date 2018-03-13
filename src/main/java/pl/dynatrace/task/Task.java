package pl.dynatrace.task;

import java.io.IOException;


public class Task {
    public static void main(String[] args) throws IOException {

        RandomNumberGeneratorClient randomNumberGeneratorClient = new RandomNumberGeneratorClient();
        RandomNumbersResponse response = randomNumberGeneratorClient.readRandomNumbers();

        PrimesExtractor primesExtractor = new PrimesExtractor();
        System.out.println("Data: " + response.getData());
        System.out.println("Prime numbers: " + primesExtractor.extract(response));
    }
}
