package PageObjects;

import BaseClass.BrowserLaunch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageObjects extends BrowserLaunch {

    @FindBy(xpath = "//input[@name ='q']")
    private WebElement SearchBox;

    @FindBy(xpath = "//input[@name ='btnK']")
    private WebElement SearchBtn;

    public GooglePageObjects() {
        PageFactory.initElements(getDriverThreadLocal(), this);
    }

    public void sendDataToSearchBtn(String dataToSend) {
        SearchBox.sendKeys(dataToSend);
    }

    public void clickOnSearchBtn() {
        SearchBtn.click();
    }

    public String getCurrentUrl() {
        return getDriverThreadLocal().getTitle();
    }
}
