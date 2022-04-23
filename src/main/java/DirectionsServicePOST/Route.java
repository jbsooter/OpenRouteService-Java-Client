package DirectionsServicePOST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "summary",
    "segments",
    "bbox",
    "geometry",
    "way_points",
    "warnings",
    "extras"
})

public class Route {

    @JsonProperty("summary")
    private Summary summary;
    @JsonProperty("segments")
    private List<Segment> segments = null;
    @JsonProperty("bbox")
    private List<Double> bbox = null;
    @JsonProperty("geometry")
    private String geometry;

    /**
     * [Lat,Lon,Elevation] for each waypoint in order
     */
    private List<List<Double>> decodedGeometry;

    @JsonProperty("way_points")
    private List<Integer> wayPoints = null;
    @JsonProperty("warnings")
    private List<Warning> warnings = null;
    @JsonProperty("extras")
    private Extras extras;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("summary")
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    @JsonProperty("bbox")
    public List<Double> getBbox() {
        return bbox;
    }

    @JsonProperty("bbox")
    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    @JsonProperty("geometry")
    public String getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("way_points")
    public List<Integer> getWayPoints() {
        return wayPoints;
    }

    @JsonProperty("way_points")
    public void setWayPoints(List<Integer> wayPoints) {
        this.wayPoints = wayPoints;
    }

    @JsonProperty("warnings")
    public List<Warning> getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }

    @JsonProperty("extras")
    public Extras getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<List<Double>> getDecodedGeometry() {
        return decodedGeometry;
    }

    public void setDecodedGeometry(List<List<Double>> decodedGeometry) {
        this.decodedGeometry = decodedGeometry;
    }

    @Override
    public String toString() {
        return "Route{" +
                "summary=" + summary +
                ", segments=" + segments +
                ", bbox=" + bbox +
                ", geometry='" + geometry + '\'' +
                ", wayPoints=" + wayPoints +
                ", warnings=" + warnings +
                ", extras=" + extras +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
