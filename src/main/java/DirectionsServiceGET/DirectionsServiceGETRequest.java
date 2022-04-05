package DirectionsServiceGET;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DirectionsServiceGETRequest {
    public static DirectionsServiceGETResult getDirections(double latA, double lonA,double latB, double lonB, String profile, HttpClient clientConn) throws URISyntaxException, IOException, InterruptedException {
        //request route
        HttpRequest orsReq = HttpRequest.newBuilder(
                new URI(String.format("http://localhost:8080/ors/v2/directions/%s?api_key=your-api-key&start=%s,%s&end=%s,%s",
                        profile,lonA, latA, lonB, latB))).build();
        HttpResponse<String> orsResp = clientConn.send(orsReq, HttpResponse.BodyHandlers.ofString());

        //if request successful, map to object with Jackson
        if(orsResp.statusCode() == 200)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(orsResp.body(), DirectionsServiceGETResult.class);
        }
        //o.w., return null object
        else
        {
            return null;
        }
    }
}
