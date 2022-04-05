import DirectionsServiceGET.DirectionsServiceGETRequest;
import DirectionsServiceGET.DirectionsServiceGETResult;
import DirectionsServicePOST.DirectionsServicePOSTResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class tester0315 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        HttpClient orsClient = HttpClient.newHttpClient();

        DirectionsServiceGETResult output = DirectionsServiceGETRequest.getDirections(35.2,-91.2,35.3,-91.3,"driving-car",orsClient);

        System.out.println(output.toString());
        /*
        //hit the basic GetDirectionsAPI 10000 times
        for(int i = 0; i < 10000;i++)
        {


            HttpRequest orsReq = HttpRequest.newBuilder(
                    new URI("http://localhost:8080/ors/v2/directions/driving-car?api_key=your-api-key&start=-91.2,35.2&end=-91.3,35.3")).build();

            HttpResponse<String> orsResp = orsClient.send(orsReq,HttpResponse.BodyHandlers.ofString());

            System.out.println(orsResp.body());
        }


         */

        /*
        //hit post service 10000 times
        for(int i = 0; i < 1; i++)
        {
            HttpRequest orsReq = HttpRequest.newBuilder(
                    new URI("http://localhost:8080/ors/v2/directions/driving-car"))
                    .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                    .header("Content-Type", "application/json; charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"coordinates\":[[-94.0,36.2],[-94.2,36.2]],\"geometry\":\"true\",\"alternative_routes\":{\"target_count\":2,\"weight_factor\":1.6},\"elevation\":\"true\"}")).build();


            HttpResponse<String> orsResp = orsClient.send(orsReq,HttpResponse.BodyHandlers.ofString());

            System.out.println(orsResp.body());


            //return object and print to string
            ObjectMapper objectMapper = new ObjectMapper();

            DirectionsServicePOSTResult trial = objectMapper.readValue(orsResp.body(), DirectionsServicePOSTResult.class);

            //System.out.println(trial.toString());
        }



         */

    }
}
