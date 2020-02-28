package pages;

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


}
