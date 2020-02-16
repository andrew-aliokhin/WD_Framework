package tests;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageYandex;
import pages.MailPageYandex;
import services.LoginServices;
import services.MailServices;

public class MailTest {

  public static LoginPageYandex loginPageYandex;
  public static MailPageYandex mailPageYandex;
  private static WebDriver driver = null;

  @BeforeClass
  public void openBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    loginPageYandex = new LoginPageYandex(driver);
  }

  @AfterClass(enabled = false)
  public void closeBrowser() {
    driver.close();
  }

  @Test(priority = 0)
  public void enterInvalidLogInTest() {
    Assert.assertEquals(LoginServices.enterIncorrectLogin().getErrorMassage(),
        LoginPageYandex.getLoginErrorMassage(),
        "Testing of logging with invalid data is failed");
  }

  @Test(priority = 1)
  public void enterInvalidPasswordTest() {
    Assert.assertEquals(LoginServices.enterIncorrectPassword().getErrorMassage(),
        LoginPageYandex.getPasswordErrorMassage(),
        "Testing of logging with invalid data is failed");
  }

  @Test(priority = 2)
  public void logInTest() {
    Assert.assertEquals(LoginServices.LogIn().getUserName(), LoginServices.trueUser.getUserName(),
        "Testing of logging is failed");
  }

  @Test(priority = 3)
  public void sendEmailTest() throws InterruptedException {
    Assert.assertEquals(
        MailServices.sendEmail().clickInboxButton().clickRefreshButton().getLastEmailSubject(),
        mailPageYandex.clickSentButton().clickRefreshButton().getLastEmailSubject(),
        "Testing of sending email is failed");
  }

  @Test(priority = 4)
  public void sendInvalidEmail() {
    Assert.assertEquals(MailServices.sendInvalidEmail().getErrorMassage(),
        MailPageYandex.getEmailErrorMassage(), "Testing of sending invalid email is failed");
  }

  @Test(priority = 5)
  public void sendEmailWithoutSubject() throws InterruptedException {
    Assert.assertEquals(
        MailServices.sendEmailWithoutSubject().clickInboxButton().clickRefreshButton()
            .getLastEmailSubject(),
        MailPageYandex.getDefaultSubject(), "Testing of sending email without subject is failed");
  }

  @Test(priority = 6)
  public void draftTest() throws InterruptedException {
    Assert.assertEquals(
        MailServices.createDraft().clickDraftButton().clickSaveAndLeaveButton().clickRefreshButton()
            .getLastEmailSubject(),
        MailServices.email.getSubject(), "Testing of save draft email is failed");
  }

  @Test(priority = 7)
  public void trashTest() throws InterruptedException {
    Assert.assertEquals(MailServices.createTrash().getLastEmailSubject(),
        MailServices.email.getSubject(), "Testing of save trash email is failed");
  }

  @Test(priority = 8)
  public void deleteEmailTest() throws InterruptedException {
    Assert.assertThrows(
        TimeoutException.class,
        () -> MailServices.deleteEmail().clickRefreshButton().getLastEmailSubject());
  }


}



