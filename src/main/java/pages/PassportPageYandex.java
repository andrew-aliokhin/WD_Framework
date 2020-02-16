package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PassportPageYandex extends BasePage {

  private static final String USER_ACCOUNT_NAME = "//*[@class=\"user2\"]/a[1]";
  private static final String OPEN_MAIL_BUTTON = "//*[@class=\"menu__group\"]//*[@class=\"menu__list-item\"][1]";


  WebElement openMailButton;
  WebElement userAccountName;


  public PassportPageYandex(WebDriver driver) {
    super(driver);
  }

  public MailPageYandex openMail() throws InterruptedException {
    userAccountName = driver.findElement(By.xpath(USER_ACCOUNT_NAME));
    Thread.sleep(4000);
    userAccountName.click();
    openMailButton = driver.findElement(By.xpath(OPEN_MAIL_BUTTON));
    openMailButton.click();
    return new MailPageYandex(driver);
  }

}
