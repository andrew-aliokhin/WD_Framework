package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageYandex extends BasePage {

  private static final String LOGIN_ERROR_MASSAGE = "Такого аккаунта нет";
  private static final String PASSWORD_ERROR_MASSAGE = "Неверный пароль";

  private static final String PAGE_URL = "https://mail.yandex.by/";
  private static final String LOGIN_FIELD_LOCATOR = "//*[@id=\"passp-field-login\"]";
  private static final String SIGN_IN_BUTTON_LOCATOR = "//*[@class=\"passp-button passp-sign-in-button\"]//*[@type=\"submit\"]";
  private static final String PASSWORD_FIELD_LOCATOR = "//*[@id=\"passp-field-passwd\"]";
  private static final String ENTER_BUTTON = "//*[@class=\"HeadBanner-ButtonsWrapper\"]//*[2]";
  private static final String ERROR_FIELD = "//*[@class=\"passp-form-field__error\"]";

  @FindBy(xpath = LOGIN_FIELD_LOCATOR)
  public WebElement loginField;

  @FindBy(xpath = SIGN_IN_BUTTON_LOCATOR)
  public WebElement signInButton;


  WebElement passwordField;

  public LoginPageYandex(WebDriver driver) {
    super(driver);
  }

  public static String getLoginErrorMassage() {
    return LOGIN_ERROR_MASSAGE;
  }

  public static String getPasswordErrorMassage() {
    return PASSWORD_ERROR_MASSAGE;
  }

  public LoginPageYandex clickEnterButton() {
    WebElement explicitWait = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTER_BUTTON)));
    WebElement interButton = explicitWait.findElement(By.xpath(ENTER_BUTTON));
    interButton.click();
    return this;
  }

  public LoginPageYandex enterLogin(User user) {
    loginField = driver.findElement(By.xpath(LOGIN_FIELD_LOCATOR));
    loginField.sendKeys(user.getUserName());
    return this;
  }

  public LoginPageYandex clickSignInButton() {
    signInButton = driver.findElement(By.xpath(SIGN_IN_BUTTON_LOCATOR));
    signInButton.click();
    return this;
  }

  public MailPageYandex openMailPageYandex() {

    signInButton = driver.findElement(By.xpath(SIGN_IN_BUTTON_LOCATOR));
    signInButton.click();
    return new MailPageYandex(driver);
  }

  public LoginPageYandex enterPassword(User user) {
    passwordField = driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR));
    passwordField.sendKeys(user.getPassword());
    return this;
  }

  public String getErrorMassage() {
    WebElement errorField = driver.findElement(By.xpath(ERROR_FIELD));
    return errorField.getText();
  }

  public LoginPageYandex open() {
    driver.get(PAGE_URL);
    return this;
  }

  public LoginPageYandex clearLoginField() {
    loginField.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"
        + "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
    return this;
  }

  public LoginPageYandex clearPasswordField() {
    passwordField.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"
        + "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
    return this;
  }
}
