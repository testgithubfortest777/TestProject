package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора заголовка
     */
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement controlPanelTitle;

    /**
     * определение локатора кнопки "добавить" для раздела "blog"
     */
    @FindBy(xpath = "//a[@href='/admin/blog/entry/add/']")
    private WebElement addEntriesLink;

    /**
     * определение локатора ссылки на список Entries
     */
    @FindBy(xpath = "//div[@class=\"dashboard-module-content\"]//a[@href=\"/admin/blog/entry/\" and text()]")
    private WebElement entriesListLink;

    /**
     * метод для проверки наличия заголовка на странице. Здесь долго побеждал кодировку для того, чтобы работал Assert Equals
     */
    public void checkControlPanelTitle() {
        controlPanelTitle.isDisplayed();
        String h1ControlPanelTitle = addPanelTitle.getAttribute("innerHTML");
        Assert.assertEquals("Панель управления", h1ControlPanelTitle);
    }

    /**
     * метод для нажатия на кнопку добавления новой записи
     */
    public void clickAddEntries() {
        addEntriesLink.click();
    }

    /**
     * метод для получения списка с записями
     */
    public void clickEntriesList() {
        entriesListLink.click();
    }

    /** Меню добавления новой записи **/

    /**
     * определение локатора заголовка
     */
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement addPanelTitle;

    /**
     * определение локатора поля title
     */
    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement titleField;

    /**
     * определение локатора поля slug
     */
    @FindBy(xpath = "//input[@id='id_slug']")
    private WebElement slugField;

    /**
     * определение локатора поля text markdown
     */
    @FindBy(xpath = "//textarea[@id='id_text_markdown']")
    private WebElement markdownField;

    /**
     * определение локатора поля text
     */
    @FindBy(xpath = "//textarea[@id='id_text']")
    private WebElement textField;

    /**
     * определение локатора кнопки "Сохранить"
     */
    @FindBy(xpath = "//input[@name='_save']")
    private WebElement saveButton;

    /**
     * определение локатора кнопки "Удалить"
     */
    @FindBy(xpath = "//a[@class=\"deletelink\"]")
    private WebElement deleteButton;

    /**
     * определение локатора кнопки "Да, я уверен"
     */
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement iAmSureButton;

    /**
     * метод для проверки наличия заголовка на странице добавления новой записи
     */
    public void checkAddPanelTitle() {
        addPanelTitle.isDisplayed();
        String h1AddPanelTitle = addPanelTitle.getAttribute("innerHTML");
        Assert.assertEquals("Добавить entry", h1AddPanelTitle);
    }

    /**
     * метод для ввода в поле title
     */
    public void inputTitle(String title) {
        titleField.sendKeys(title);
    }

    /**
     * метод получения значения поля text
     */
    public String getTitleText() {
        return titleField.getAttribute("value");
    }

    /**
     * метод для ввода в поле slug
     */
    public void inputSlug(String slug) {
        slugField.sendKeys(slug);
    }

    /**
     * метод получения значения поля slug
     */
    public String getSlugText() {
        return slugField.getAttribute("value");
    }

    /**
     * метод очистки поля slug
     */
    public void clearSlug() {
        slugField.clear();
    }

    /**
     * метод для ввода в area text markdown
     */
    public void inputMarkdownField(String markdown) {
        markdownField.sendKeys(markdown);
    }

    /**
     * метод для ввода в поле text
     */
    public void inputTextField(String text) {
        textField.sendKeys(text);
    }

    /**
     * метод для нажатия на кнопку "Сохранить"
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Поиск заголовка среди списка entries и нажатие на созданный entry
     */
    public void searchTitle(String title) {
        driver.findElement(By.xpath("//tbody//tr//a[text()='" + title + "']")).click();
    }

    /**
     * Нажатие на кнопку удаления entry
     */
    public void deleteTitle() {
        deleteButton.click();
    }

    /**
     * Нажатие на кнопку "Я уверен" при удалении записи
     */
    public void deleteTitleSure() {
        iAmSureButton.click();
    }
}