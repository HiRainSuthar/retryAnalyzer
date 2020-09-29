import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksWithSelenium {

    @Test
    public void findBrokenLinks() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://admin:admin@the-internet.herokuapp.com/");

        //get the list of all links and images
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total links are " + elementList.size());

        //create empty webelement list
        List<WebElement> activeList = new ArrayList<WebElement>();

        //iterate through the list
        for (WebElement element : elementList) {
            //add all the link to list does not have null value
            if (element.getAttribute("href") != null) {
                activeList.add(element);
            }
        }

        System.out.println("count of active links are " + activeList.size());

        for (WebElement activeElement : activeList) {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(activeElement.getAttribute("href")).openConnection();
            urlConnection.connect();
            String response = urlConnection.getResponseMessage();
            urlConnection.disconnect();
            System.out.println("response of link " + activeElement.getAttribute("href") + " is " + response);
        }
    }
}
