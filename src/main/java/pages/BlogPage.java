package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
    public WebDriver driver;

    public BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Поиск заголовка элемента на всей странице (как один из методов)
     */
    public void searchTitle(String title) {
        driver.findElement(By.xpath("//div[@id='entries']//a[text()='" + title + "']")).isDisplayed();
    }
}

