package services;

import static tests.MailTest.getMailPageYandex;

import pages.MailPageYandex;

public class MailServices {


  public static MailPageYandex deleteLetter() {
    getMailPageYandex().clickLastLetterFlag().clickDeleteButton();
    return getMailPageYandex();
  }

  public static MailPageYandex deleteAllLetter() {
    getMailPageYandex().clickAllLettersFlag().clickDeleteButton();
    return getMailPageYandex();
  }

  public static MailPageYandex deleteLettersAfterTest() {
//    goToSent();
    getMailPageYandex().clickRefreshButton();
    deleteLetter();
    return getMailPageYandex();
  }

  public static MailPageYandex sendLetter(String recipient, String subject, String content) {
    fillInLetterFields(recipient, subject, content).clickSendLetterButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToInbox() {
    getMailPageYandex().clickInboxButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToSent() {
    getMailPageYandex().clickSentButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToTrash() {
    getMailPageYandex().clickTrashButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToDrafts() {
    getMailPageYandex().clickDraftButton();
    return getMailPageYandex();
  }

  public static MailPageYandex fillInLetterFields(String recipient, String subject,
      String content) {
    getMailPageYandex().clickComposeLetterButton().sendKeysToRecipientField(recipient)
        .sendKeysToSubjectInputField(subject).sendKeysToLetterInputField(content);
    return getMailPageYandex();
  }

  public static String getSubjectOfLastSentLetter() {

    return getMailPageYandex().clickSentButton().clickRefreshButton().getLastLetterSubject();
  }

  public static String getSubjectOfLastInboxLetter() {
    return getMailPageYandex().clickInboxButton().clickRefreshButton()
        .getLastLetterSubject();
  }

  public static String getSubjectOfLastDraftLetter() {
    return getMailPageYandex().clickDraftButton().clickRefreshButton().getLastLetterSubject();
  }

  public static String getSubjectOfLastTrashLetter() {
    return getMailPageYandex().clickTrashButton().clickRefreshButton().getLastLetterSubject();
  }


}
