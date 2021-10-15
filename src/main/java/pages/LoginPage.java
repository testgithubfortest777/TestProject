package pages;

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
    @FindBy(xpath = "//input[@id='id_username']")
    private WebElement loginField;

    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//input[@id='id_password']")
    private WebElement passwdField;

    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//input[@type = 'submit']")
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
     * метод для осуществления нажатия кнопки входа в аккаунт, также можно использовать submit
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
