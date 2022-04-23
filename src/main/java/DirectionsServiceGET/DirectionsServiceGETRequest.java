package DirectionsServiceGET;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DirectionsServiceGETRequest {
    /**
     * Point A Latitude
     */
    Double latA;

    /**
     * Point A Longitude
     */
    Double lonA;

    /**
     * Point B Latitude
     */
    Double latB;

    /**
     * Point B Longitude
     */
    Double lonB;

    /**
     * Shared connection to use from Java net package.
     */
    HttpClient clientConn;

    public DirectionsServiceGETRequest(Double latA, Double lonA, Double latB, Double lonB, HttpClient clientConn) {
        this.latA = latA;
        this.lonA = lonA;
        this.latB = latB;
        this.lonB = lonB;
        this.clientConn = clientConn;
    }

    public DirectionsServiceGETResult getDirections() throws URISyntaxException, IOException, InterruptedException {
        //request route
        HttpRequest orsReq = HttpRequest.newBuilder(
                new URI(String.format(
                                "http://localhost:8080/ors/v2/directions/%s?api_key=your-api-key&start=%s,%s&end=%s,%s",
                        "driving-car",lonA, latA, lonB, latB))).build();
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
            System.out.println(orsResp.statusCode());
            return null;
        }
    }
}
