import BaseClass.BrowserLaunch;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retryAnalyzer.Retry;

public class GoogleLandingPageTest extends BrowserLaunch  {

    @BeforeClass
    public void GoToUrl() {
        initialization();
        driver.get("https://www.google.com/");
    }

    @Test(retryAnalyzer = Retry.class)
    public void verifyTitle(){
        Assert.assertEquals("Google", "Joogle");
    }

    @AfterTest
    public void closeTestBrowserInstance(){
        tearDown();
    }
}
