package mail.ru.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки "Написать письмо"
     */
    @FindBy(xpath = "//span[contains(text(), 'Написать письмо')]")
    private WebElement writeLetterButton;

    /**
     * определение локатора поля ввода e-mail
     */
    @FindBy(xpath = "//div[contains(@class, 'input')]//div[contains(@class, 'input')]/input")
    private WebElement emailEntryField;

    /**
     * определение локатора поля ввода тела сообщения
     */
    @FindBy(xpath = "//div[@contenteditable='true' and @tabindex='505']")
    private WebElement textEntryField;

    /**
     * определение локатора кнопки "Отправить"
     */
    @FindBy(xpath = "//span[@title='Отправить']")
    private WebElement sendButton;

    /**
     * метод для нажатия на кнопку отправить
     */
    public void clickSendButton() {
        sendButton.click();
    }

    /**
     * метод для ввода в поле email
     */
    public void inputEmail(String title) {
        emailEntryField.sendKeys(title);
    }

    /**
     * метод для ввода тела сообщения
     */
    public void inputMessageText(String string) {
        textEntryField.sendKeys(string);
    }

    /**
     * метод для нажатия на кнопку "Написать письмо"
     */
    public void clickWriteLetterButton() {
        writeLetterButton.click();
    }
}

