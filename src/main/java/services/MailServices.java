package services;

import static tests.MailTest.getMailPageYandex;

import framework.Browser;
import pages.MailPageYandex;

public class MailServices {

  public static MailPageYandex deleteAllLetter() {
    getMailPageYandex().clickAllLettersFlag().clickDeleteButton();
    Browser.waitElementToBeVisible(MailPageYandex.getEmptyMassage());
    return getMailPageYandex();
  }

  public static MailPageYandex deleteAllDrafts() {
    goToDrafts();
    getMailPageYandex().clickSaveAndLeaveButton().clickRefreshButton().clickAllLettersFlag()
        .clickDeleteButton();
    Browser.waitElementToBeVisible(MailPageYandex.getEmptyMassage());
    return getMailPageYandex();
  }

  public static MailPageYandex sendLetter(String recipient, String subject, String content) {
    fillInLetterFields(recipient, subject, content).clickSendLetterButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToSent() {
    getMailPageYandex().clickSentButton();
    return getMailPageYandex();
  }

  public static MailPageYandex goToDrafts() {
    getMailPageYandex().clickDraftButton().clickSaveAndLeaveButton();
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
    goToDrafts();
    return getMailPageYandex().clickSaveAndLeaveButton().clickRefreshButton()
        .getLastLetterSubject();
  }
}
