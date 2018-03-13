package pl.dynatrace.task;

import com.google.gson.Gson;
import org.javalite.http.Http;

public class RandomNumberGeneratorClient {

    private static final String URL = "http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task";
    private static final String USERNAME = "candidate";
    private static final String PASSWORD = "abc123";

    private final Gson gson;

    RandomNumberGeneratorClient() {
        gson = new Gson();
    }

    public RandomNumbersResponse readRandomNumbers(){
        return gson.fromJson(Http.get(URL).basic(USERNAME, PASSWORD).text(), RandomNumbersResponse.class);
    }

}
