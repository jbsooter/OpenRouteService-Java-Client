import DirectionsServiceGET.DirectionsServiceGETResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DirectionsServiceGETRequest {
    private ORSConnection connection;

    private double[] start;

    private double[] end;

    public DirectionsServiceGETRequest(ORSConnection connection, double[] start, double[] end) {
        this.connection = connection;
        this.start = start;
        this.end = end;
    }

    public DirectionsServiceGETResult build() throws ExecutionException, InterruptedException, TimeoutException, JsonProcessingException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format("%sv2/directions/driving-car?&start=%s,%s&end=%s,%s",connection.getORSBaseURL(), start[0], start[1], end[0], end[1])))
                .build();


        CompletableFuture<HttpResponse<String>> response =
                connection.getHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        ObjectMapper objectMapper = new ObjectMapper();

        DirectionsServiceGETResult resultObject = objectMapper.readValue(result, DirectionsServiceGETResult.class);

        return resultObject;
    }
}
