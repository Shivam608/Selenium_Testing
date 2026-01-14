package ChatGPT.ResponsePayLoad.ResponsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class usage {

    private int input_tokens;

    public int getInput_tokens() {
        return input_tokens;
    }

    public void setInput_tokens(int input_tokens) {
        this.input_tokens = input_tokens;
    }
}
