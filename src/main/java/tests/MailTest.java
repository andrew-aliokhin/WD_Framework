package tests;

import static model.Letter.getCONTENT;
import static model.Letter.getSUBJECT;
import static model.User.getFullName;
import static pages.MailPageYandex.getDefaultSubject;
import static pages.MailPageYandex.getLetterErrorMassage;
import static services.MailServices.deleteAllDrafts;
import static services.MailServices.deleteAllLetter;
import static services.MailServices.fillInLetterFields;
import static services.MailServices.getSubjectOfLastDraftLetter;
import static services.MailServices.getSubjectOfLastInboxLetter;
import static services.MailServices.getSubjectOfLastSentLetter;
import static services.MailServices.goToSent;
import static services.MailServices.sendLetter;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailPageYandex;

public class MailTest {

  private static MailPageYandex mailPageYandex;

  public static MailPageYandex getMailPageYandex() {
    return mailPageYandex;
  }

  public static void setMailPageYandex(MailPageYandex mailPageYandex) {
    MailTest.mailPageYandex = mailPageYandex;
  }

  @Test(priority = 1)
  public void sendLetterTest() {
    sendLetter(getFullName(), getSUBJECT(), getCONTENT());
    Assert.assertEquals(getSubjectOfLastInboxLetter(),
        getSubjectOfLastSentLetter(), "test is failed");
    deleteAllLetter();
  }

  @Test(priority = 2)
  public void sendLetterWithoutSubject() {
    sendLetter(getFullName(), "", getCONTENT());
    Assert.assertEquals(getSubjectOfLastInboxLetter(),
        getDefaultSubject(), "test is failed");
    goToSent();
    deleteAllLetter();
  }

  @Test(priority = 3)
  public void sendLetterWithoutRecipient() {
    Assert.assertEquals(sendLetter("", getSUBJECT(), getCONTENT()).getErrorMassage(),
        getLetterErrorMassage(), "test is failed");
    deleteAllDrafts();
  }

  @Test(priority = 4)
  public void saveDraftTest() {
    fillInLetterFields(getFullName(), getSUBJECT(), getCONTENT());
    Assert.assertEquals(getSubjectOfLastDraftLetter(), getSUBJECT(), "test is failed");

  }

}



