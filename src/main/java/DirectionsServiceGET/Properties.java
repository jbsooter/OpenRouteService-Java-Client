package DirectionsServiceGET;

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
    "segments",
    "way_points",
    "summary"
})

public class Properties {

    @JsonProperty("segments")
    private List<Segment> segments = null;
    @JsonProperty("way_points")
    private List<Integer> wayPoints = null;
    @JsonProperty("summary")
    private Summary summary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    @JsonProperty("way_points")
    public List<Integer> getWayPoints() {
        return wayPoints;
    }

    @JsonProperty("way_points")
    public void setWayPoints(List<Integer> wayPoints) {
        this.wayPoints = wayPoints;
    }

    @JsonProperty("summary")
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Properties{" +
                "segments=" + segments +
                ", wayPoints=" + wayPoints +
                ", summary=" + summary +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
