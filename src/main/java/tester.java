import DirectionsServiceGET.DirectionsServiceGETResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class tester {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, JsonProcessingException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/ors/v2/directions/driving-car?api_key=your-api-key&start=-91.2,35.2&end=-91.3,35.3"))
                .build();


        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        ObjectMapper objectMapper = new ObjectMapper();

        DirectionsServiceGETResult trial = objectMapper.readValue(result, DirectionsServiceGETResult.class);

        System.out.println(trial.getBbox());
    }
}
