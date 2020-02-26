package tests;

import static framework.Browser.refreshTab;
import static model.User.getFalsePassword;
import static model.User.getFalseUserName;
import static model.User.getFullName;
import static model.User.getPassword;
import static model.User.getUserName;
import static pages.LoginPageYandex.getLoginErrorMassage;
import static pages.LoginPageYandex.getPasswordErrorMassage;
import static services.LoginServices.enterLogin;
import static services.LoginServices.enterPassword;
import static services.LoginServices.logIn;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageYandex;
import services.LoginServices;

public class LogInTest extends BaseTest {

  private static LoginPageYandex loginPageYandex;

  public static LoginPageYandex getLoginPageYandex() {
    return loginPageYandex;
  }


  public static void setLoginPageYandex(LoginPageYandex loginPageYandex) {
    LogInTest.loginPageYandex = loginPageYandex;
  }

  @BeforeClass
  public void openLoginPage() {
    LoginServices.openLoginPage();
  }

  @Test(groups = "Negative tests")
  public void invalidLoginTest() {
    refreshTab();
    Assert.assertEquals(enterLogin(getFalseUserName()).getErrorMassage(),
        getLoginErrorMassage(), "test failed");
  }

  @Test(groups = "Negative tests")
  public void invalidPasswordTest() {
    refreshTab();
    enterLogin(getFullName());
    Assert.assertEquals(enterPassword(getFalsePassword()).getErrorMassage(),
        getPasswordErrorMassage(), "test failed");
  }

  @Test(dependsOnGroups = "Negative tests")
  public void logInTest() {
    refreshTab();
    Assert.assertEquals(logIn(getFullName(), getPassword()).getUserName(),
        getUserName(), "test failed");
  }


}
