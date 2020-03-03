import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screenshotWebelement {

    @Test
    public void screenshotTest() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.swtestacademy.com");

        WebElement logo = driver.findElement(By.className("fusion-logo-link"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./TestReport/logo.png"));
        driver.close();
    }
}
