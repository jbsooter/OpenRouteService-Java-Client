import DirectionsServiceGET.DirectionsServiceGETResult;
import DirectionsServicePOST.DirectionsServicePOSTResult;
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

public class testertwo {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, JsonProcessingException {
        HttpRequest request = HttpRequest.newBuilder()
                //.GET()
                .uri(URI.create("http://localhost:8080/ors/v2/directions/driving-car"))
                //.setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString("{\"coordinates\":[[-94.0,36.2],[-94.1,36.2],[-94.2,36.4]],\"attributes\":[\"avgspeed\",\"detourfactor\",\"percentage\"],\"continue_straight\":\"true\",\"elevation\":\"true\",\"extra_info\":[\"steepness\",\"suitability\",\"surface\",\"waycategory\",\"tollways\",\"waytype\",\"traildifficulty\",\"osmid\",\"roadaccessrestrictions\",\"countryinfo\",\"green\",\"noise\"],\"id\":\"routing_request\",\"instructions\":\"true\",\"instructions_format\":\"text\",\"language\":\"en\",\"maneuvers\":\"true\",\"preference\":\"fastest\",\"roundabout_exits\":\"true\",\"suppress_warnings\":\"false\",\"units\":\"m\",\"geometry\":\"true\",\"maximum_speed\":90}"))
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        ObjectMapper objectMapper = new ObjectMapper();

        DirectionsServicePOSTResult trial = objectMapper.readValue(result, DirectionsServicePOSTResult.class);

        System.out.println(trial.getRoutes().get(0).getSegments().get(0).getDistance());
    }
}
