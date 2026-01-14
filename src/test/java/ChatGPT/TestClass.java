package ChatGPT;

import ChatGPT.RequestPayLoad.GPTInputLayout;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void chatGPT() {
        Response res = GPTInputLayout.sendMessage("Weather is California in Degree Centigrade");
        assert res != null;
        res.prettyPrint();


    }
}
