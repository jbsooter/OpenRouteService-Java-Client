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
    "version",
    "build_date",
    "graph_date"
})

public class Engine {

    @JsonProperty("version")
    private String version;
    @JsonProperty("build_date")
    private String buildDate;
    @JsonProperty("graph_date")
    private String graphDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("build_date")
    public String getBuildDate() {
        return buildDate;
    }

    @JsonProperty("build_date")
    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    @JsonProperty("graph_date")
    public String getGraphDate() {
        return graphDate;
    }

    @JsonProperty("graph_date")
    public void setGraphDate(String graphDate) {
        this.graphDate = graphDate;
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
        return "Engine{" +
                "version='" + version + '\'' +
                ", buildDate='" + buildDate + '\'' +
                ", graphDate='" + graphDate + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
