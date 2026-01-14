package ChatGPT.ResponsePayLoad.ResponsePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class output {

    private String type;
    private String status;

    @JsonProperty("content")
    private List<content> contents;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<content> getContents() {
        return contents;
    }

    public void setContents(List<content> contents) {
        this.contents = contents;
    }
}
