import DirectionsServicePOST.DirectionsServicePOSTResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DirectionServicePOSTRequest {
    private ORSConnection connection;

    private List<List<Double>> coordinates = null;

    private String profile = null;

    private String id = null;

    private String preference = null;

    private String format = null;

    private String units = null;

    private String language = null;

    private Boolean geometry = null;

    private Boolean instructions = null;

    private String instructionsFormat = null;

    private Boolean roundaboutExits = null;

    private List<String> attributes = null;

    private Boolean maneuvers = null;

    private Boolean continueStraight = null;

    private Boolean elevation = null;

    private List<String> extraInfo = null;

    private Double maximumSpeed = null;

    public DirectionServicePOSTRequest(ORSConnection connection, String profile, List<List<Double>> coordinates) {
        this.connection = connection;
        this.profile = profile;
        this.coordinates = coordinates;
    }

    public DirectionsServicePOSTResult build() throws ExecutionException, InterruptedException, TimeoutException, JsonProcessingException {
        String JSONQueryBody = "{";
        if(coordinates != null)
        {
            JSONQueryBody += "\"coordinates\":" + coordinates.toString();
        }
        //TODO: Add support for all fields
        //https://openrouteservice.org/dev/#/api-docs/v2/directions/{profile}/post


        JSONQueryBody += "}";

        HttpRequest request = HttpRequest.newBuilder()
                //.GET()
                .uri(URI.create("http://localhost:8080/ors/v2/directions/driving-car"))
                //.setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                //.POST(HttpRequest.BodyPublishers.ofString("{\"coordinates\":[[-94.0,36.2],[-94.1,36.2],[-94.2,36.4]],\"attributes\":[\"avgspeed\",\"detourfactor\",\"percentage\"],\"continue_straight\":\"true\",\"elevation\":\"true\",\"extra_info\":[\"steepness\",\"suitability\",\"surface\",\"waycategory\",\"tollways\",\"waytype\",\"traildifficulty\",\"osmid\",\"roadaccessrestrictions\",\"countryinfo\",\"green\",\"noise\"],\"id\":\"routing_request\",\"instructions\":\"true\",\"instructions_format\":\"text\",\"language\":\"en\",\"maneuvers\":\"true\",\"preference\":\"fastest\",\"roundabout_exits\":\"true\",\"suppress_warnings\":\"false\",\"units\":\"m\",\"geometry\":\"true\",\"maximum_speed\":90}"))
                .POST(HttpRequest.BodyPublishers.ofString(JSONQueryBody))

                .build();

        CompletableFuture<HttpResponse<String>> response =
                connection.getHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        ObjectMapper objectMapper = new ObjectMapper();

        DirectionsServicePOSTResult resultObject = objectMapper.readValue(result, DirectionsServicePOSTResult.class);

        return resultObject;
    }
    public ORSConnection getConnection() {
        return connection;
    }

    public void setConnection(ORSConnection connection) {
        this.connection = connection;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getGeometry() {
        return geometry;
    }

    public void setGeometry(Boolean geometry) {
        this.geometry = geometry;
    }

    public Boolean getInstructions() {
        return instructions;
    }

    public void setInstructions(Boolean instructions) {
        this.instructions = instructions;
    }

    public String getInstructionsFormat() {
        return instructionsFormat;
    }

    public void setInstructionsFormat(String instructionsFormat) {
        this.instructionsFormat = instructionsFormat;
    }

    public Boolean getRoundaboutExits() {
        return roundaboutExits;
    }

    public void setRoundaboutExits(Boolean roundaboutExits) {
        this.roundaboutExits = roundaboutExits;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public Boolean getManeuvers() {
        return maneuvers;
    }

    public void setManeuvers(Boolean maneuvers) {
        this.maneuvers = maneuvers;
    }

    public Boolean getContinueStraight() {
        return continueStraight;
    }

    public void setContinueStraight(Boolean continueStraight) {
        this.continueStraight = continueStraight;
    }

    public Boolean getElevation() {
        return elevation;
    }

    public void setElevation(Boolean elevation) {
        this.elevation = elevation;
    }

    public List<String> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(List<String> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
}
