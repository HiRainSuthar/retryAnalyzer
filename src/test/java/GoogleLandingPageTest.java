import BaseClass.BrowserLaunch;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.Retry;

public class GoogleLandingPageTest extends BrowserLaunch  {


    public void GoToUrl() {
//        driver = initialization();
//        driver.get("https://www.google.com/");
        getDriverThreadLocal().get("https://www.google.com/");
    }

    @Test(retryAnalyzer = Retry.class)
    public void verifyTitle(){
        getDriverThreadLocal().get("https://www.google.com/");
        String actualTitle = getDriverThreadLocal().getTitle();
        Assert.assertEquals(actualTitle, "Google");
    }


}
