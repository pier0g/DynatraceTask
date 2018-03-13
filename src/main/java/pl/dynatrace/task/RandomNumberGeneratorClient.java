package pl.dynatrace.task;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class RandomNumberGeneratorClient {
    private static final String sURL = "http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task";


    public RandomNumbersResponse readRandomNumbers() throws IOException {

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("candidate", "abc123".toCharArray());
            }
        });

        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        Gson gson = new Gson();
        RandomNumbersResponse response = gson.fromJson(new InputStreamReader((InputStream) request.getContent()), RandomNumbersResponse.class);

        return response;
    }

}
