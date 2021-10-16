package pages;

import configurations.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AdminPageAndBlogTest {
    public static AdminPage adminPage;
    public static LoginPage loginPage;
    public static BlogPage blogPage;
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
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);
        blogPage = new BlogPage(driver);
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
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void adminPageAndAddEntryTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        adminPage.checkControlPanelTitle();
        adminPage.clickAddEntries();
        adminPage.checkAddPanelTitle();
        adminPage.inputTitle(ConfProperties.randomString(10));
        adminPage.clearSlug();
        adminPage.inputSlug(ConfProperties.randomString(10));
        String titleText = adminPage.getTitleText();
        String slugText = adminPage.getSlugText();
        adminPage.inputMarkdownField(slugText);
        adminPage.inputTextField(slugText);
        adminPage.clickSaveButton();
        driver.get(ConfProperties.getProperty("blogpage"));
        blogPage.searchTitle(titleText);
        driver.get(ConfProperties.getProperty("loginpage"));
        adminPage.clickEntriesList();
        adminPage.searchTitle(titleText);
        adminPage.deleteTitle();
        adminPage.deleteTitleSure();
    }
}
