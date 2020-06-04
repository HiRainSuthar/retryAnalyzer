import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium4test {

    @Test
    public void openNewTab() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");
        driver.switchTo().defaultContent();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.swtestacademy.com");

        Thread.sleep(50);
        driver.close();
    }


}


