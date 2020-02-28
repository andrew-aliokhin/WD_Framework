package services;

import static tests.LogInTest.getLoginPageYandex;
import static tests.MailTest.getMailPageYandex;
import static tests.MailTest.setMailPageYandex;

import framework.Browser;
import pages.LoginPageYandex;
import pages.MailPageYandex;
import tests.LogInTest;

public class LoginServices {

  public static void openLoginPage() {
    LogInTest.setLoginPageYandex(new LoginPageYandex(Browser.getDriver()));
    LogInTest.getLoginPageYandex().open().clickEnterButton();
  }

  public static LoginPageYandex enterLogin(String login) {
    getLoginPageYandex().sendKeysToLogin(login).clickSignInButton();
    return getLoginPageYandex();
  }

  public static LoginPageYandex enterPassword(String password) {
    getLoginPageYandex().sendKeysToPassword(password).openMailPageYandex();
    return getLoginPageYandex();
  }

  public static MailPageYandex logIn(String login, String password) {
    setMailPageYandex(new MailPageYandex(Browser.getDriver()));
    enterLogin(login);
    enterPassword(password);
    return getMailPageYandex();
  }

}
