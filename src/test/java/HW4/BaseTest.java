package HW4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public abstract class BaseTest {

    private String login = "MaxTest333";
    private String password = "SSlazio2000!";
    private String recipient = "maxtest123@rambler.ru";
    private String subject = "Тестовая тема";
    private String message = "Тестовый текст";
    private String xPathLogin = "//*[@name='login']";
    private String xPathPass = "//*[@name='passwd']";
    private String xPathAccount = "//*[contains(@class,'user-account_has-ticker_yes')]/div";
    private String xPathMessageButton = "//*[contains(@class,'mail-ComposeButton-Text')]";
    private String xPathDraftCheckbox = "//*[contains(@class,'nb-checkbox-normal-flag')]";
    private String xPathRecipient = "//*[contains(@class,'ComposeYabble-Text')]";
    private String xPathSendMessage = "//*[contains(@class,'ns-view-messages-item-wrap')]";
    private String xPathVerifySubject = "//*[contains(@class,'mail-Message-Toolbar-Subject_message')]";
    private String xPathLoginFormTittle = "//*[contains(@class,'passp-title')]/span";

    public void switchTab(WebDriver driver) throws InterruptedException {

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        Thread.sleep(3000);
    }

    public void logPass(WebDriver driver, String credential) throws InterruptedException {

        driver.findElement(By.xpath(xPathLogin)).sendKeys(login);
        driver.findElement(By.xpath("//*[contains(@class,'passp-sign-in-button')]")).click();

        Thread.sleep(3000);
    }


}
