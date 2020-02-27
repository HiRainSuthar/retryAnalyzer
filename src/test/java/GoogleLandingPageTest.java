import BaseClass.BrowserLaunch;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleLandingPageTest extends BrowserLaunch  {

    @BeforeClass
    public void GoToUrl() {
        initialization();
        driver.get("https://www.google.com/");
    }

    @Test
    public void verifyTitle(){
        Assert.assertEquals("Google", "Google");
    }

    @AfterTest
    public void closeTestBrowserInstance(){
        tearDown();
    }
}
