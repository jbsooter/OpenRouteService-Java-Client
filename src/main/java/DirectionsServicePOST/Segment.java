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
    "distance",
    "duration",
    "steps",
    "detourfactor",
    "percentage",
    "avgspeed",
    "ascent",
    "descent"
})

public class Segment {

    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("steps")
    private List<Step> steps = null;
    @JsonProperty("detourfactor")
    private Double detourfactor;
    @JsonProperty("percentage")
    private Double percentage;
    @JsonProperty("avgspeed")
    private Double avgspeed;
    @JsonProperty("ascent")
    private Double ascent;
    @JsonProperty("descent")
    private Double descent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @JsonProperty("steps")
    public List<Step> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @JsonProperty("detourfactor")
    public Double getDetourfactor() {
        return detourfactor;
    }

    @JsonProperty("detourfactor")
    public void setDetourfactor(Double detourfactor) {
        this.detourfactor = detourfactor;
    }

    @JsonProperty("percentage")
    public Double getPercentage() {
        return percentage;
    }

    @JsonProperty("percentage")
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @JsonProperty("avgspeed")
    public Double getAvgspeed() {
        return avgspeed;
    }

    @JsonProperty("avgspeed")
    public void setAvgspeed(Double avgspeed) {
        this.avgspeed = avgspeed;
    }

    @JsonProperty("ascent")
    public Double getAscent() {
        return ascent;
    }

    @JsonProperty("ascent")
    public void setAscent(Double ascent) {
        this.ascent = ascent;
    }

    @JsonProperty("descent")
    public Double getDescent() {
        return descent;
    }

    @JsonProperty("descent")
    public void setDescent(Double descent) {
        this.descent = descent;
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
        return "Segment{" +
                "distance=" + distance +
                ", duration=" + duration +
                ", steps=" + steps +
                ", detourfactor=" + detourfactor +
                ", percentage=" + percentage +
                ", avgspeed=" + avgspeed +
                ", ascent=" + ascent +
                ", descent=" + descent +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
