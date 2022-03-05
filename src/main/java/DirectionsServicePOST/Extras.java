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
    "waycategory",
    "surface",
    "waytypes",
    "steepness",
    "suitability",
    "roadaccessrestrictions",
    "traildifficulty"
})

public class Extras {

    @JsonProperty("waycategory")
    private Waycategory waycategory;
    @JsonProperty("surface")
    private Surface surface;
    @JsonProperty("waytypes")
    private Waytypes waytypes;
    @JsonProperty("steepness")
    private Steepness steepness;
    @JsonProperty("suitability")
    private Suitability suitability;
    @JsonProperty("roadaccessrestrictions")
    private Roadaccessrestrictions roadaccessrestrictions;
    @JsonProperty("traildifficulty")
    private Traildifficulty traildifficulty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("waycategory")
    public Waycategory getWaycategory() {
        return waycategory;
    }

    @JsonProperty("waycategory")
    public void setWaycategory(Waycategory waycategory) {
        this.waycategory = waycategory;
    }

    @JsonProperty("surface")
    public Surface getSurface() {
        return surface;
    }

    @JsonProperty("surface")
    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    @JsonProperty("waytypes")
    public Waytypes getWaytypes() {
        return waytypes;
    }

    @JsonProperty("waytypes")
    public void setWaytypes(Waytypes waytypes) {
        this.waytypes = waytypes;
    }

    @JsonProperty("steepness")
    public Steepness getSteepness() {
        return steepness;
    }

    @JsonProperty("steepness")
    public void setSteepness(Steepness steepness) {
        this.steepness = steepness;
    }

    @JsonProperty("suitability")
    public Suitability getSuitability() {
        return suitability;
    }

    @JsonProperty("suitability")
    public void setSuitability(Suitability suitability) {
        this.suitability = suitability;
    }

    @JsonProperty("roadaccessrestrictions")
    public Roadaccessrestrictions getRoadaccessrestrictions() {
        return roadaccessrestrictions;
    }

    @JsonProperty("roadaccessrestrictions")
    public void setRoadaccessrestrictions(Roadaccessrestrictions roadaccessrestrictions) {
        this.roadaccessrestrictions = roadaccessrestrictions;
    }

    @JsonProperty("traildifficulty")
    public Traildifficulty getTraildifficulty() {
        return traildifficulty;
    }

    @JsonProperty("traildifficulty")
    public void setTraildifficulty(Traildifficulty traildifficulty) {
        this.traildifficulty = traildifficulty;
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
        return "Extras{" +
                "waycategory=" + waycategory +
                ", surface=" + surface +
                ", waytypes=" + waytypes +
                ", steepness=" + steepness +
                ", suitability=" + suitability +
                ", roadaccessrestrictions=" + roadaccessrestrictions +
                ", traildifficulty=" + traildifficulty +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
