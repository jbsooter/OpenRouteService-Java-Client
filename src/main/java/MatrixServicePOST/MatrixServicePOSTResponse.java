package MatrixServicePOST;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MatrixServicePOSTResponse {

    @JsonProperty("durations")
    private List<List<Double>> durations;

    //TODO add distances

    @JsonProperty("destinations")
    private List<MatrixLocation> destinations;

    @JsonProperty("sources")
    private List<MatrixLocation> sources;

    @JsonProperty("metadata")
    private MatrixMetadata metadata;

    public List<List<Double>> getDurations() {
        return durations;
    }

    public void setDurations(List<List<Double>> durations) {
        this.durations = durations;
    }

    public List<MatrixLocation> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<MatrixLocation> destinations) {
        this.destinations = destinations;
    }

    public List<MatrixLocation> getSources() {
        return sources;
    }

    public void setSources(List<MatrixLocation> sources) {
        this.sources = sources;
    }

    public MatrixMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(MatrixMetadata metadata) {
        this.metadata = metadata;
    }

    // MatrixLocation class
    public static class MatrixLocation {

        @JsonProperty("location")
        private List<Double> location;

        @JsonProperty("snapped_distance")
        private double snappedDistance;

        public List<Double> getLocation() {
            return location;
        }

        public void setLocation(List<Double> location) {
            this.location = location;
        }

        public double getSnappedDistance() {
            return snappedDistance;
        }

        public void setSnappedDistance(double snappedDistance) {
            this.snappedDistance = snappedDistance;
        }

        @Override
        public String toString() {
            return "MatrixLocation{" +
                    "location=" + location +
                    ", snappedDistance=" + snappedDistance +
                    '}';
        }
    }

    // MatrixMetadata class
    public static class MatrixMetadata {

        @JsonProperty("attribution")
        private String attribution;

        @JsonProperty("service")
        private String service;

        @JsonProperty("timestamp")
        private long timestamp;

        @JsonProperty("query")
        private MatrixQuery query;

        @JsonProperty("engine")
        private MatrixEngine engine;

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public MatrixQuery getQuery() {
            return query;
        }

        public void setQuery(MatrixQuery query) {
            this.query = query;
        }

        public MatrixEngine getEngine() {
            return engine;
        }

        public void setEngine(MatrixEngine engine) {
            this.engine = engine;
        }

        @Override
        public String toString() {
            return "MatrixMetadata{" +
                    "attribution='" + attribution + '\'' +
                    ", service='" + service + '\'' +
                    ", timestamp=" + timestamp +
                    ", query=" + query +
                    ", engine=" + engine +
                    '}';
        }
    }

    // MatrixQuery class
    public static class MatrixQuery {

        @JsonProperty("locations")
        private List<List<Double>> locations;

        @JsonProperty("profile")
        private String profile;

        @JsonProperty("responseType")
        private String responseType;

        public List<List<Double>> getLocations() {
            return locations;
        }

        public void setLocations(List<List<Double>> locations) {
            this.locations = locations;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getResponseType() {
            return responseType;
        }

        public void setResponseType(String responseType) {
            this.responseType = responseType;
        }

        @Override
        public String toString() {
            return "MatrixQuery{" +
                    "locations=" + locations +
                    ", profile='" + profile + '\'' +
                    ", responseType='" + responseType + '\'' +
                    '}';
        }
    }

    // MatrixEngine class
    public static class MatrixEngine {

        @JsonProperty("version")
        private String version;

        @JsonProperty("build_date")
        private String buildDate;

        @JsonProperty("graph_date")
        private String graphDate;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getBuildDate() {
            return buildDate;
        }

        public void setBuildDate(String buildDate) {
            this.buildDate = buildDate;
        }

        public String getGraphDate() {
            return graphDate;
        }

        public void setGraphDate(String graphDate) {
            this.graphDate = graphDate;
        }

        @Override
        public String toString() {
            return "MatrixEngine{" +
                    "version='" + version + '\'' +
                    ", buildDate='" + buildDate + '\'' +
                    ", graphDate='" + graphDate + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MatrixResponse{" +
                "durations=" + durations +
                ", destinations=" + destinations +
                ", sources=" + sources +
                ", metadata=" + metadata +
                '}';
    }
}
