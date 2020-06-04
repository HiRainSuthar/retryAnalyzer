import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class SwitchTab {

    @Test(enabled = false)
    public void openNewTab() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Go to URL
        driver.get("http://www.google.com");
        String currentHandle= driver.getWindowHandle();
        // Open new tab
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open()");

        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //switching to the opened tab
                driver.switchTo().window(actual);
                //opening the URL saved.
                driver.get("http://gmail.com");
                driver.close();
            }
        }
        Thread.sleep(1000);
        driver.switchTo().window(currentHandle);
        driver.close();
    }

    @Test
    public void HandlingMultipleTabs() {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            //Navigating to google
            driver.get("http://www.google.com");
            driver.manage().window().maximize();

        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_T);

//            //switch using actions class
//            Actions action= new Actions(driver);
//            action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
            Set<String> currentHandle = driver.getWindowHandles();

        }

    }



