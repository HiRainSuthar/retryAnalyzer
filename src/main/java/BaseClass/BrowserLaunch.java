package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

public class BrowserLaunch {

//    public WebDriver driver;

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private FileInputStream fis;
    private Properties prop;

    @Parameters(value = {"browser"})
    @BeforeMethod
    public void initialization(String Browser) {

//        fis = new FileInputStream("./src/main/java/configuration/config.properties");
//        prop = new Properties();
//
//        prop.load(fis);
//        String Browser = prop.getProperty("browser");
//        System.out.println(Browser);

        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else {
            System.out.println("No browser provided");
        }
        getDriverThreadLocal().manage().window().maximize();
    }

    public WebDriver getDriverThreadLocal() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
//        driver.close();
        getDriverThreadLocal().close();
    }
}
