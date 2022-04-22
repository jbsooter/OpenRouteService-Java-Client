package DirectionsServicePOST;

import DirectionsServiceGET.DirectionsServiceGETResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DirectionsServicePOSTRequest {
    public static DirectionsServicePOSTResult postDirections(double latA, double lonA,double latB, double lonB, String profile, HttpClient clientConn) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest orsReq = HttpRequest.newBuilder(
                        new URI("http://localhost:8080/ors/v2/directions/driving-car"))
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString("{\"coordinates\":[[-94.0,36.2],[-94.09,36.2]],\"geometry\":\"false\",\"alternative_routes\":{\"target_count\":2,\"weight_factor\":1.6},\"elevation\":\"true\",\"extra_info\":[\"steepness\"]}")).build();

        HttpResponse<String> orsResp = clientConn.send(orsReq,HttpResponse.BodyHandlers.ofString());
        //if request successful, map to object with Jackson
        if(orsResp.statusCode() == 200)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(orsResp.body());
            return objectMapper.readValue(orsResp.body(), DirectionsServicePOSTResult.class);
        }
        //o.w., return null object
        else
        {
            return null;
        }
    }

}
