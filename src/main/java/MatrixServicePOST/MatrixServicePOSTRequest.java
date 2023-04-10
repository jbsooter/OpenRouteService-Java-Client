package MatrixServicePOST;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class MatrixServicePOSTRequest {
    /**
     *Example: driving-car
     */
    private String profile;

    private String units;

    private String metrics;

    /**
     * coordinates of every node in lat, lon format.
     */
    double[][] coordinates;

    /**
     * Shared connection to use from Java net package.
     */
    private HttpClient clientConn;

    /**
     * Base URL
     * LOCAL Example: http://localhost:8080/ors/v2/directions/
     * OpenRouteService Hosted Example: https://api.openrouteservice.org/v2/directions/
     */
    private String baseURL;

    /**
     * API Key
     * LOCAL Example: your-api-key
     */
    private String apiKey;

    public MatrixServicePOSTRequest(String profile, double[][] coordinates, HttpClient clientConn, String baseURL, String apiKey) {
        this.profile = profile;
        this.coordinates = coordinates;
        this.clientConn = clientConn;
        this.baseURL = baseURL;
        this.apiKey = apiKey;
    }

    public MatrixServicePOSTResponse postMatrix() throws URISyntaxException, IOException, InterruptedException {
        //make lon, lat
        double[][] converted_coords = new double[coordinates.length][coordinates[0].length];
        for(int i = 0; i < coordinates.length;i++)
        {
                converted_coords[i][1] = coordinates[i][0];
                converted_coords[i][0] = coordinates[i][1];

        }
        String requestBody = String.format("{\"locations\":%s}", Arrays.deepToString(converted_coords));

        HttpRequest orsReq = HttpRequest.newBuilder(
                        new URI(String.format("%s%s", baseURL, profile)))
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Authorization", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        HttpResponse<String> orsResp = clientConn.send(orsReq,HttpResponse.BodyHandlers.ofString());
        //if request successful, map to object with Jackson
        if(orsResp.statusCode() == 200)
        {
            ObjectMapper objectMapper = new ObjectMapper();

            MatrixServicePOSTResponse result = objectMapper.readValue(orsResp.body(), MatrixServicePOSTResponse.class);

            return result;
        }
        //o.w., return null object
        else
        {
            System.err.println("Directions POST request failed with Status Code " + orsResp.statusCode());
            System.err.println(orsResp.body());
            return null;
        }
    }
}

