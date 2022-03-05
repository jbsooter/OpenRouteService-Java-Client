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
    "coordinates",
    "profile",
    "id",
    "preference",
    "format",
    "units",
    "language",
    "geometry",
    "instructions",
    "instructions_format",
    "roundabout_exits",
    "attributes",
    "maneuvers",
    "continue_straight",
    "elevation",
    "extra_info",
    "maximum_speed"
})

public class Query {

    @JsonProperty("coordinates")
    private List<List<Double>> coordinates = null;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("id")
    private String id;
    @JsonProperty("preference")
    private String preference;
    @JsonProperty("format")
    private String format;
    @JsonProperty("units")
    private String units;
    @JsonProperty("language")
    private String language;
    @JsonProperty("geometry")
    private Boolean geometry;
    @JsonProperty("instructions")
    private Boolean instructions;
    @JsonProperty("instructions_format")
    private String instructionsFormat;
    @JsonProperty("roundabout_exits")
    private Boolean roundaboutExits;
    @JsonProperty("attributes")
    private List<String> attributes = null;
    @JsonProperty("maneuvers")
    private Boolean maneuvers;
    @JsonProperty("continue_straight")
    private Boolean continueStraight;
    @JsonProperty("elevation")
    private Boolean elevation;
    @JsonProperty("extra_info")
    private List<String> extraInfo = null;
    @JsonProperty("maximum_speed")
    private Double maximumSpeed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coordinates")
    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("preference")
    public String getPreference() {
        return preference;
    }

    @JsonProperty("preference")
    public void setPreference(String preference) {
        this.preference = preference;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("units")
    public String getUnits() {
        return units;
    }

    @JsonProperty("units")
    public void setUnits(String units) {
        this.units = units;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("geometry")
    public Boolean getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Boolean geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("instructions")
    public Boolean getInstructions() {
        return instructions;
    }

    @JsonProperty("instructions")
    public void setInstructions(Boolean instructions) {
        this.instructions = instructions;
    }

    @JsonProperty("instructions_format")
    public String getInstructionsFormat() {
        return instructionsFormat;
    }

    @JsonProperty("instructions_format")
    public void setInstructionsFormat(String instructionsFormat) {
        this.instructionsFormat = instructionsFormat;
    }

    @JsonProperty("roundabout_exits")
    public Boolean getRoundaboutExits() {
        return roundaboutExits;
    }

    @JsonProperty("roundabout_exits")
    public void setRoundaboutExits(Boolean roundaboutExits) {
        this.roundaboutExits = roundaboutExits;
    }

    @JsonProperty("attributes")
    public List<String> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("maneuvers")
    public Boolean getManeuvers() {
        return maneuvers;
    }

    @JsonProperty("maneuvers")
    public void setManeuvers(Boolean maneuvers) {
        this.maneuvers = maneuvers;
    }

    @JsonProperty("continue_straight")
    public Boolean getContinueStraight() {
        return continueStraight;
    }

    @JsonProperty("continue_straight")
    public void setContinueStraight(Boolean continueStraight) {
        this.continueStraight = continueStraight;
    }

    @JsonProperty("elevation")
    public Boolean getElevation() {
        return elevation;
    }

    @JsonProperty("elevation")
    public void setElevation(Boolean elevation) {
        this.elevation = elevation;
    }

    @JsonProperty("extra_info")
    public List<String> getExtraInfo() {
        return extraInfo;
    }

    @JsonProperty("extra_info")
    public void setExtraInfo(List<String> extraInfo) {
        this.extraInfo = extraInfo;
    }

    @JsonProperty("maximum_speed")
    public Double getMaximumSpeed() {
        return maximumSpeed;
    }

    @JsonProperty("maximum_speed")
    public void setMaximumSpeed(Double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
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
        return "Query{" +
                "coordinates=" + coordinates +
                ", profile='" + profile + '\'' +
                ", id='" + id + '\'' +
                ", preference='" + preference + '\'' +
                ", format='" + format + '\'' +
                ", units='" + units + '\'' +
                ", language='" + language + '\'' +
                ", geometry=" + geometry +
                ", instructions=" + instructions +
                ", instructionsFormat='" + instructionsFormat + '\'' +
                ", roundaboutExits=" + roundaboutExits +
                ", attributes=" + attributes +
                ", maneuvers=" + maneuvers +
                ", continueStraight=" + continueStraight +
                ", elevation=" + elevation +
                ", extraInfo=" + extraInfo +
                ", maximumSpeed=" + maximumSpeed +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
