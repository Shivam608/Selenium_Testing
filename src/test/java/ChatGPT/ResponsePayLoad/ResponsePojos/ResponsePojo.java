package ChatGPT.ResponsePayLoad.ResponsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo {

    private String id;
    private String status;

    @JsonProperty("incomplete_details")
    private incomplete_details incompleteDetails;

    @JsonProperty("billing")
    private billing billing;

    private int max_output_tokens;
    private String model;
    private usage usage;

    @JsonProperty("output")
    private List<output> outputs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public incomplete_details getIncompleteDetails() {
        return incompleteDetails;
    }

    public void setIncompleteDetails(incomplete_details incompleteDetails) {
        this.incompleteDetails = incompleteDetails;
    }

    public billing getBilling() {
        return billing;
    }

    public void setBilling(billing billing) {
        this.billing = billing;
    }

    public int getMax_output_tokens() {
        return max_output_tokens;
    }

    public void setMax_output_tokens(int max_output_tokens) {
        this.max_output_tokens = max_output_tokens;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public usage getUsage() {
        return usage;
    }

    public void setUsage(usage usage) {
        this.usage = usage;
    }

    public List<output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<output> outputs) {
        this.outputs = outputs;
    }
}
