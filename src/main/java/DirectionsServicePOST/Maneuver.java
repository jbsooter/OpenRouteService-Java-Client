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
    "location",
    "bearing_before",
    "bearing_after"
})

public class Maneuver {

    @JsonProperty("location")
    private List<Double> location = null;
    @JsonProperty("bearing_before")
    private Integer bearingBefore;
    @JsonProperty("bearing_after")
    private Integer bearingAfter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("location")
    public List<Double> getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(List<Double> location) {
        this.location = location;
    }

    @JsonProperty("bearing_before")
    public Integer getBearingBefore() {
        return bearingBefore;
    }

    @JsonProperty("bearing_before")
    public void setBearingBefore(Integer bearingBefore) {
        this.bearingBefore = bearingBefore;
    }

    @JsonProperty("bearing_after")
    public Integer getBearingAfter() {
        return bearingAfter;
    }

    @JsonProperty("bearing_after")
    public void setBearingAfter(Integer bearingAfter) {
        this.bearingAfter = bearingAfter;
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
        return "Maneuver{" +
                "location=" + location +
                ", bearingBefore=" + bearingBefore +
                ", bearingAfter=" + bearingAfter +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
