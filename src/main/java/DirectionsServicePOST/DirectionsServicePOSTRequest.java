package DirectionsServicePOST;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DirectionsServicePOSTRequest {
    /**
     * Point A Latitude
     */
    private Double latA;

    /**
     * Point A Longitude
     */
    private Double lonA;

    /**
     * Point B Latitude
     */
    private Double latB;

    /**
     * Point B Longitude
     */
    private Double lonB;

    /**
     * Maximum fraction of the route that alternatives may share with the optimal route. The default value of 0.6 means alternatives can share up to 60% of path segments with the optimal route.
     */
    private Double alternative_routes_share_factor;

    /**
     * Target number of alternative routes to compute. Service returns up to this number of routes that fulfill the share-factor and weight-factor constraints.
     */
    private Integer alternative_routes_target_count;

    /**
     * Maximum factor by which route weight may diverge from the optimal route. The default value of 1.4 means alternatives can be up to 1.4 times longer (costly) than the optimal route.
     */
    private Double alternative_routes_weight_factor;

    /**
     * TRUE: Include average speed along a segment.
     * FALSE: Do not include.
     */
    private Boolean avgspeed;

    /**
     * TRUE: Include elevation data in the response body.
     * FALSE: DO not Include
     */
    private Boolean elevation;

    /**
     * Units of distance to use in response body.
     * Options "m", "km", "mi"
     */
    private String units;

    /**
     * Shared connection to use from Java net package.
     */
    private HttpClient clientConn;

    public DirectionsServicePOSTRequest(Double latA, Double lonA, Double latB, Double lonB, HttpClient clientConn) {
        this.latA = latA;
        this.lonA = lonA;
        this.latB = latB;
        this.lonB = lonB;
        this.clientConn = clientConn;
        this.avgspeed = false;
        this.elevation = false;
        this.units = null;
        this.alternative_routes_target_count = null;
        this.alternative_routes_weight_factor = null;
        this.alternative_routes_share_factor = null;
    }

    public DirectionsServicePOSTRequest(Double latA, Double lonA, Double latB, Double lonB, Double alternative_routes_share_factor, Integer alternative_routes_target_count, Double alternative_routes_weight_factor, Boolean avgspeed, Boolean elevation, String units, HttpClient clientConn) {
        this.latA = latA;
        this.lonA = lonA;
        this.latB = latB;
        this.lonB = lonB;
        this.alternative_routes_share_factor = alternative_routes_share_factor;
        this.alternative_routes_target_count = alternative_routes_target_count;
        this.alternative_routes_weight_factor = alternative_routes_weight_factor;
        this.avgspeed = avgspeed;
        this.elevation = elevation;
        this.units = units;
        this.clientConn = clientConn;
    }

    public  DirectionsServicePOSTResult postDirections() throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("{\"coordinates\":[[%s,%s],[%s,%s]]", lonA, latA, lonB, latB);

        if(alternative_routes_share_factor != null && alternative_routes_target_count != null && alternative_routes_weight_factor != null)
        {
            requestBody += String.format(",\"alternative_routes\":{\"share_factor\":%s,\"target_count\":%s,\"weight_factor\":%s}"
                   // "\"alternative_routes\":{\"share_factor\":0.6,\"target_count\":2,\"weight_factor\":1.4}"

                    , alternative_routes_share_factor
                    , alternative_routes_target_count
                    , alternative_routes_weight_factor);
        }

        if(avgspeed)
        {
            requestBody += ",\"attributes\":[\"avgspeed\"]";
        }

        if(elevation)
        {
            requestBody += ",\"elevation\":\"true\"";
        }

        if(units != null)
        {
            requestBody+= String.format(",\"units\":\"%s\"", units);
        }

        requestBody += "}";


        HttpRequest orsReq = HttpRequest.newBuilder(
                        new URI("http://localhost:8080/ors/v2/directions/driving-car"))
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

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
            System.err.println("Directions POST request failed with Status Code " + orsResp.statusCode());
            System.err.println(orsResp.body());
            return null;
        }
    }



}
