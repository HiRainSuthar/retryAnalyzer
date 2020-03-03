package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserLaunch {

    public WebDriver driver;
    private FileInputStream fis;
    private Properties prop;

    public void initialization() throws IOException {

        fis = new FileInputStream("./src/main/java/configuration/config.properties");
        prop = new Properties();

        prop.load(fis);
        String Browser =  prop.getProperty("browser");
        System.out.println(Browser);

        if(Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("No browser provided");
        }
        driver.manage().window().maximize();
    }

    public void tearDown(){
        driver.close();
    }
}
