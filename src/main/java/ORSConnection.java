import java.net.http.HttpClient;
import java.time.Duration;

public class ORSConnection {
    private static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private String ORSBaseURL;

    public ORSConnection() {
        this.ORSBaseURL = "http://localhost:8080/ors/";
    }

    public ORSConnection(String ORSBaseURL) {
        this.ORSBaseURL = ORSBaseURL;
    }

    public String getORSBaseURL() {
        return ORSBaseURL;
    }

    public void setORSBaseURL(String ORSBaseURL) {
        this.ORSBaseURL = ORSBaseURL;
    }

    public static HttpClient getHttpClient() {
        return httpClient;
    }

    public static void setHttpClient(HttpClient httpClient) {
        ORSConnection.httpClient = httpClient;
    }

    @Override
    public String toString() {
        return "ORSConnection{" +
                "ORSBaseURL='" + ORSBaseURL + '\'' +
                '}';
    }
}
