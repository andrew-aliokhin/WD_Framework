package pages;

import static framework.Browser.clickElement;
import static framework.Browser.getTextFromElement;
import static framework.Browser.openTab;
import static framework.Browser.sendKeysToElement;

import org.openqa.selenium.WebDriver;


public class LoginPageYandex extends BasePage {

  private static final String LOGIN_ERROR_MASSAGE = "Такого аккаунта нет";
  private static final String PASSWORD_ERROR_MASSAGE = "Неверный пароль";

  private static final String PAGE_URL = "https://mail.yandex.by/";
  private static final String LOGIN_FIELD_LOCATOR = "//*[@id=\"passp-field-login\"]";
  private static final String SIGN_IN_BUTTON_LOCATOR =
      "//*[@class=\"passp-button passp-sign-in-button\"]"
          + "//*[@type=\"submit\"]";
  private static final String PASSWORD_FIELD_LOCATOR = "//*[@id=\"passp-field-passwd\"]";
  private static final String ENTER_BUTTON = "//*[@class=\"HeadBanner-ButtonsWrapper\"]//*[2]";
  private static final String ERROR_FIELD = "//*[@class=\"passp-form-field__error\"]";


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
    clickElement(ENTER_BUTTON);
    return this;
  }

  public LoginPageYandex sendKeysToLogin(String login) {
    sendKeysToElement(LOGIN_FIELD_LOCATOR, login);
    return this;
  }

  public LoginPageYandex clickSignInButton() {
    clickElement(SIGN_IN_BUTTON_LOCATOR);
    return this;
  }

  public MailPageYandex openMailPageYandex() {
    clickElement(SIGN_IN_BUTTON_LOCATOR);
    return new MailPageYandex(driver);
  }

  public LoginPageYandex sendKeysToPassword(String password) {
    sendKeysToElement(PASSWORD_FIELD_LOCATOR, password);
    return this;
  }

  public String getErrorMassage() {
    return getTextFromElement(ERROR_FIELD);
  }

  public LoginPageYandex open() {
    openTab(PAGE_URL);
    return this;
  }
}
