package ChatGPT.ResponsePayLoad;


import ChatGPT.RequestPayLoad.GPTInputLayout;
import ChatGPT.ResponsePayLoad.ResponsePojos.ResponsePojo;

import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.Test;

public class GptOutputLayout extends GPTInputLayout {

    @Test
    public void ResponseData() {

        GPTInputLayout.sendMessage("why you dont have access to real time weather updates?");
//        chatGptResponse.prettyPrint();

        ResponsePojo responsePojo = chatGptResponse.as(ResponsePojo.class, ObjectMapperType.JACKSON_2);
        System.out.println("Output Message: " + responsePojo
                .getOutputs().getFirst()
                .getContents().getFirst()
                .getText());

        System.out.println("Incomplete Status: " + responsePojo.getStatus());
        if (responsePojo.getStatus().equalsIgnoreCase("incomplete")) {
            System.out.println("Reason: " + responsePojo.getIncompleteDetails().getReason());
        }
    }
}
