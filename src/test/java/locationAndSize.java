import BaseClass.BrowserLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class locationAndSize extends BrowserLaunch {

    @Test
    public void location() {

//        WebDriver driver = initialization();
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        getDriverThreadLocal().navigate().to("https://www.swtestacademy.com");

        WebElement logo = getDriverThreadLocal().findElement(By.className("fusion-logo-link"));

        System.out.println("Height is " + logo.getRect().getDimension().getHeight());
        System.out.println("Width is " + logo.getRect().getDimension().getWidth());
        System.out.println("Location X is " + logo.getRect().getX());
        System.out.println("Location Y is " + logo.getRect().getY());
    }
}
