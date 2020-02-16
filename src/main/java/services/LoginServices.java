package services;

import model.User;
import pages.LoginPageYandex;
import pages.MailPageYandex;
import tests.MailTest;

public class LoginServices {

  public static User negativeUser = new User("incorrect.name.it.academy", "incorrect.password", "");
  public static User trueUser = new User("user.it.academy", "it.academy.user", "@yandex.ru");

  public static LoginPageYandex enterIncorrectLogin() {
    MailTest.loginPageYandex = MailTest.loginPageYandex.open().clickEnterButton()
        .enterLogin(LoginServices.negativeUser).
            clickSignInButton().clearLoginField();
    return MailTest.loginPageYandex;
  }

  public static LoginPageYandex enterIncorrectPassword() {
    MailTest.loginPageYandex = MailTest.loginPageYandex.enterLogin(trueUser).
        clickSignInButton().enterPassword(negativeUser).clickSignInButton().clearPasswordField();
    return MailTest.loginPageYandex;
  }

  public static MailPageYandex LogIn() {
    MailTest.mailPageYandex = MailTest.loginPageYandex.enterPassword(trueUser).openMailPageYandex();
    return MailTest.mailPageYandex;
  }

}
