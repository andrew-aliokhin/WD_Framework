package services;

import model.Email;
import pages.MailPageYandex;
import tests.MailTest;

public class MailServices {

  public static Email email = new Email(LoginServices.trueUser, "automationTest", "test");

  public static MailPageYandex sendEmail() {
    MailTest.mailPageYandex.composeMail().enterRecipient(email).enterContent(email)
        .enterSubject(email).clickSendEmailButton();
    return MailTest.mailPageYandex;
  }

  public static MailPageYandex sendInvalidEmail() {
    MailTest.mailPageYandex.composeMail().enterContent(email).clickSendEmailButton();
    return MailTest.mailPageYandex;
  }

  public static MailPageYandex sendEmailWithoutSubject() {
    MailTest.mailPageYandex.enterRecipient(email).clickSendEmailButton();
    return MailTest.mailPageYandex;
  }

  public static MailPageYandex createDraft() {
    MailTest.mailPageYandex.composeMail().enterContent(email).enterSubject(email);
    return MailTest.mailPageYandex;
  }

  public static MailPageYandex createTrash() {
    MailTest.mailPageYandex.clickLastEmailFlag().clickDeleteButton().clickTrashButton();
    return MailTest.mailPageYandex;
  }

  public static MailPageYandex deleteEmail() {
    MailTest.mailPageYandex.clickLastEmailFlag().clickDeleteButton();
    return MailTest.mailPageYandex;
  }


}
