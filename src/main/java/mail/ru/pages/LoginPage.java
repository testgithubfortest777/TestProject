package mail.ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//input[contains(@class, email-input) and @placeholder='Имя ящика']")
    private WebElement loginField;

    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwdField;


    /**
     * определение локатора кнопки "Ввести пароль"
     */
    @FindBy(xpath = "//button[@data-testid='enter-password']")
    private WebElement enterThePasswordBtn;

    /**
     * определение локатора кнопки "Войти"
     */
    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    private WebElement loginBtn;

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    /**
     * метод для осуществления нажатия кнопки "Ввести пароль", также можно использовать submit
     */
    public void clickEnterThePasswordBtn() {
        enterThePasswordBtn.click();
    }

    /**
     * метод для осуществления нажатия кнопки "Войти", также можно использовать submit
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
