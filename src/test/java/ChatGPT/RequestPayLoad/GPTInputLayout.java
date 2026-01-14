package ChatGPT.RequestPayLoad;


import Utility.FrameworkUtilities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class GPTInputLayout {

    private String input = "Hi";
    private final String baseUrl = "https://api.openai.com";
    private final String uri = "/v1/responses";
    public static Response chatGptResponse = null;

    public static Response sendMessage(String message) {
        GPTInputLayout gptInputLayout = new GPTInputLayout();
        try {
            chatGptResponse = gptInputLayout.requestPayLoad(message);
            return chatGptResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chatGptResponse;
    }

    private Response requestPayLoad(String inputMessage) throws IOException {

//        this.model = (model.isEmpty() || model.equals(" ")) ? this.model : model;
//        System.out.println("Model: " + model);

        this.input = (inputMessage.isEmpty() || inputMessage.equals(" ")) ? this.input : inputMessage;
        System.out.println("Input Message: " + input);

        return RestAssured.given()
                .spec(resPec())
                .when().post(uri)
                .then().extract().response();

    }

    private RequestSpecification resPec() throws IOException {

        RequestPojo requestPojo = new RequestPojo();
        requestPojo.setModel(FrameworkUtilities.getValueFromProperties("CHAT_MODEL"));
        requestPojo.setMaxOutputTokens(Integer.parseInt(FrameworkUtilities.getValueFromProperties("MAX_TOKEN")));
        requestPojo.setInput(input);


        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .addHeader("Authorization", FrameworkUtilities.getValueFromProperties("API_KEY"))
                .setBody(requestPojo, ObjectMapperType.JACKSON_2)
                .build();

    }
}
