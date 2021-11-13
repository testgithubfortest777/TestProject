package mail.ru.pages;

import configurations.ConfProperties;
import mail.ru.pages.LoginPage;
import mail.ru.pages.MailPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailPageTest {
    public static MailPage mailPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        mailPage = new MailPage(driver);
        loginPage = new LoginPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @AfterClass
    public static void quitClass() {
        driver.quit();
    }

    /**
     * тестовый метод для осуществления аутентификации, отправки сообщения
     */
    @Test
    public void adminPageAndAddEntryTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickEnterThePasswordBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        mailPage.clickWriteLetterButton();
        mailPage.inputEmail("eugenepilatov@gmail.com");
        mailPage.inputMessageText(ConfProperties.randomString(20));
        mailPage.clickSendButton();
    }
}
