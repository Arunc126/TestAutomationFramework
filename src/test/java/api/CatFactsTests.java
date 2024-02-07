package api;

import io.restassured.response.Response;
import org.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.RestAssuredUtils;

public class CatFactsTests extends BaseTest {
    @Test
    public void testGoogleWeatherAPI()
    {
    restAssuredUtils=new RestAssuredUtils("https://catfact.ninja");
    Response res=restAssuredUtils.get("/fact");
    if(res.getStatusCode()==200)
        test.pass("Success");
    else
        test.fail("failed with status code "+res.getStatusCode());

        Assert.assertEquals(res.getStatusCode(),200);
    }
}
