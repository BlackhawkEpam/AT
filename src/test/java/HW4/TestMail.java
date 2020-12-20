package HW4;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Класс автотеста для Яндекс почты
 */
public class TestMail extends BaseTest{
    private WebDriver driver;

    /**
     * Объявление драйвера
     */
    @BeforeTest(alwaysRun = true)
    public void browserSetUp() {
        driver = new FirefoxDriver();
    }

    /**
     * Класс автотеста
     */
    @Test
    public void ramblerMailTest() throws InterruptedException {

        /*Блок объявления икс-пассов*/
        String login = "MaxTest333";
        String password = "SSlazio2000!";
        String recipient = "maxtest123@rambler.ru";
        String subject = "Тестовая тема";
        String message = "Тестовый текст";
        String xPathLogin = "//*[@name='login']";
        String xPathPass = "//*[@name='passwd']";
        String xPathAccount = "//*[contains(@class,'user-account_has-ticker_yes')]/div";
        String xPathMessageButton = "//*[contains(@class,'mail-ComposeButton-Text')]";
        String xPathDraftCheckbox = "//*[contains(@class,'nb-checkbox-normal-flag')]";
        String xPathRecipient = "//*[contains(@class,'ComposeYabble-Text')]";
        String xPathSendMessage = "//*[contains(@class,'ns-view-messages-item-wrap')]";
        String xPathVerifySubject = "//*[contains(@class,'mail-Message-Toolbar-Subject_message')]";
        String xPathLoginFormTittle = "//*[contains(@class,'passp-title')]/span";

        /*Переход на главную страницу Яндекса, ожидание загрузки страницы и нажатие на кнопку "войти в почту"*/
        driver.get("https://yandex.ru/");
        driver.manage().
                timeouts().
                pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(text(), 'Войти в почту')]/..")).
                click();

        Thread.sleep(3000);

        switchTab(driver);

        /*Ввод логина*/
        driver.findElement(By.xpath(xPathLogin)).sendKeys(login);
        driver.findElement(By.xpath("//*[contains(@class,'passp-sign-in-button')]")).click();

        Thread.sleep(3000);

        /*Ввод пароля*/
        driver.findElement(By.xpath(xPathPass)).sendKeys(password);
        driver.findElement(By.xpath("//*[contains(@class,'passp-sign-in-button')]")).click();

        Thread.sleep(5000);

        WebElement account = driver.findElement(By.xpath(xPathAccount));    //Поиск иконки аккаунта
        account.click();

        /*Проверка того, что произошла корректная авторизация, через сверку введенного логина и имени, отображаемого в аккаунте*/
        WebElement username = driver.
                findElement(By.xpath("//*[contains(@class,'light-popup_autoclosable_yes')]/ul/div[1]/div/span/span"));
        Assert.assertEquals(username.getText(), login+"@yandex.ru", "Пользователь отображается некорректно!");
        driver.findElement(By.xpath("//*[contains(@class,'yandex-header__logo-service_lang_ru')]")).
                click();    //Переход из поп-апа аккаунта в Яндекс почту

        Thread.sleep(3000);

        driver.findElement(By.xpath(xPathMessageButton)).click();   //Нажатие на кнопку "Написать письмо"

        List<WebElement> toWho  = driver.findElements(By.xpath("//*[contains(@class,'composeYabbles')]"));
        toWho.get(0).sendKeys(recipient);   //Ввод адресата
        toWho.get(0).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(@class,'composeTextField')]")).
                sendKeys(subject);  //Ввод темы письма
        driver.findElement(By.xpath("//*[contains(@class,'htmlplaceholder')]")).
                sendKeys(message);  //Ввод самого сообщения

        driver.findElement(By.xpath("//a[@data-title='Черновики']/span[@class='mail-NestedList-Item-Name']")).
                click();    //Переход в Черновики

        Thread.sleep(3000);

        /*Подсчет чекбоксов черновиков, их количество гарантированно должно быть больше 0*/
        List<WebElement> checkboxMail = driver.findElements(By.xpath(xPathDraftCheckbox));
        int draftSize = checkboxMail.size();
        Assert.assertTrue(draftSize>0);
        checkboxMail.get(0).click();

        driver.findElements(By.xpath("//*[contains(@class,'mail-MessageSnippet-Content')]")).
                get(0).
                click();    //Переход в последний сохраненный черновик

        Thread.sleep(3000);

        /*Блок проверки адресата, темы и сообщения в письме*/
        List<WebElement> checkToWho = driver.findElements(By.xpath(xPathRecipient));
        Assert.assertEquals(checkToWho.get(0).getText(), recipient, "Адресанты не совпадают!");
        WebElement checkSubject = driver.findElement(By.xpath("//*[contains(@class,'composeTextField')]"));
        Assert.assertEquals(checkSubject.getAttribute("value"), subject, "Темы не совпадают!");
        WebElement checkTextBody = driver.findElement(By.xpath("//*[contains(@class,'composeReact__message-body')]"));
        Assert.assertEquals(checkTextBody.getText(), message, "Сообщения не совпадают!");

        driver.findElement(By.xpath("//*[contains(@class,'ComposeControlPanelButton-Button_action')]")).
                click();    //Отправка письма

        Thread.sleep(3000);

        /*Необходимое условие для доказательства отправки письма - количество чекбоксов писем должно уменьшиться на 1*/
        List<WebElement> checkboxMailAfterSend = driver.findElements(By.xpath(xPathDraftCheckbox));
        int draftSizeAfterSend = checkboxMailAfterSend.size();
        Assert.assertEquals(draftSizeAfterSend,(draftSize-1));

        driver.findElement(By.xpath("//a[@data-title='Отправленные']/span[@class='mail-NestedList-Item-Name']")).
                click();    //Переход в отправленные

        Thread.sleep(3000);

        driver.findElements(By.xpath(xPathSendMessage)).get(0).click(); //Переход в последнее отправленное письмо

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[contains(@class,'mail-Message-Head-Recievers-More')]/span")).
                click();    //Раскрытие адресатов во вью

        /*Блок проверки адресата, темы и сообщения - аналогично как для черновиков, но в разделе Отправленные*/
        WebElement verifyRecipient = driver.findElement(By.xpath("//*[contains(@class,'mail-User_small')]"));
        Assert.assertEquals(verifyRecipient.getAttribute("data-email"),recipient, "Адресанты не совпадают!");
        WebElement verifySubject = driver.findElement(By.xpath(xPathVerifySubject));
        Assert.assertEquals(verifySubject.getText(), subject, "Темы не совпадают!");
        WebElement verifyMessage = driver.findElement(By.xpath("//*[contains(@class,'js-message-body-content')]"));
        Assert.assertEquals(verifyMessage.getText(), message, "Сообщения не совпадают!");

        account.click();    //Раскрытие поп-апа с аккаунтом
        driver.findElement(By.xpath("//*[contains(@aria-label,'Выйти из аккаунта')]/span")).
                click();    //Нажатие на кнопку выхода из почты

        Thread.sleep(3000);

        /*Проверка выхода из Яндекс почты - на новой странице должна появиться надпись "Войдите, чтобы перейти к Почте"*/
        WebElement checkLogout = driver.findElement(By.xpath(xPathLoginFormTittle));
        Assert.assertEquals(checkLogout.getText(), "Войдите, чтобы перейти к Почте", "Выход из почты произошел некорректно!");
    }

    /**
     * Закрытие браузера и зануление драйвера
     */
    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }


}