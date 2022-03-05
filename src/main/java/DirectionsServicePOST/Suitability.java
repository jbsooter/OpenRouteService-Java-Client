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
    "values",
    "summary"
})

public class Suitability {

    @JsonProperty("values")
    private List<List<Integer>> values = null;
    @JsonProperty("summary")
    private List<Summary__5> summary = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("values")
    public List<List<Integer>> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<List<Integer>> values) {
        this.values = values;
    }

    @JsonProperty("summary")
    public List<Summary__5> getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(List<Summary__5> summary) {
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
        return "Suitability{" +
                "values=" + values +
                ", summary=" + summary +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
