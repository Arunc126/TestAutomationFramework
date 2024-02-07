package ui;

import org.common.BaseTest;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTest {

    @Test
    public void testGoogle()
    {
        driver.get("https://www.google.com/");
    }
}
