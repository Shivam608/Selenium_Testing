package ChatGPT.RequestPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPojo {

    @JsonProperty("model")
    private String model;

    @JsonProperty("input")
    private String input;

    @JsonProperty("max_output_tokens")
    private int maxOutputTokens;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @JsonProperty("max_output_tokens")
    public int getMaxOutputTokens() {
        return maxOutputTokens;
    }

    @JsonProperty("max_output_tokens")
    public void setMaxOutputTokens(int maxOutputTokens) {
        this.maxOutputTokens = maxOutputTokens;
    }
}
