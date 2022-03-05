package DirectionsServicePOST;

import java.util.HashMap;
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
    "ascent",
    "descent"
})

public class Summary {

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("duration")
    private Double duration;
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

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }
    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Summary{" +
                "amount=" + amount +
                ", distance=" + distance +
                ", duration=" + duration +
                ", ascent=" + ascent +
                ", descent=" + descent +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
