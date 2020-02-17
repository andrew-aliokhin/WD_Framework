package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

  WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    PageFactory.initElements(driver, this);
  }
}
