package pages;

import static framework.Browser.clickElement;
import static framework.Browser.fluentClickElement;
import static framework.Browser.getTextFromElement;
import static framework.Browser.sendKeysToElement;
import static framework.Browser.waitElementToBeVisible;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MailPageYandex extends BasePage {


  private static final String LETTER_ERROR_MASSAGE = "Поле не заполнено. Необходимо ввести адрес.";
  private static final String DEFAULT_SUBJECT = "(Без темы)";
  private static final String PAGE_URL = "https://mail.yandex.by/";
  private static final String COMPOSE_BUTTON = "//*[@class=\"mail-ComposeButton js-main-action-compose\"]";
  private static final String REFRESH_BUTTON = "//*[@title=\"Проверить, есть ли новые письма (F9)\"]";
  private static final String SEND_LETTER_BUTTON = "//*[@class=\"mail-Compose-Field-Actions-Footer-Main\"]//span[text()=\"Отправить\"]";
  private static final String INBOX_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#inbox\"]";
  private static final String SENT_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#sent\"]";
  private static final String DELETE_BUTTON = "//*[@title=\"Удалить (Delete)\"]";
  private static final String USER_NAME_BUTTON = "//*[@class=\"mail-User-Name\"]";
  private static final String DRAFT_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#draft\"]";
  private static final String TRASH_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#trash\"]";
  private static final String LAST_LETTER_SUBJECT = "//*[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]/div[1]//*[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]/span";
  private static final String LAST_LETTER_FLAG = "//*[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]/div[1]//*[@class=\"_nb-checkbox-flag _nb-checkbox-normal-flag\"]";
  private static final String ALL_LETTER_FLAG = "//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/label/span";
  private static final String RECIPIENT_FIELD = "//*[@name=\"to\"]";
  private static final String SUBJECT_INPUT_FIELD = "//*[@class=\"mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev\"]";
  private static final String LETTER_INPUT_FIELD = "//*[@role=\"textbox\"]";
  private static final String ERROR_FIELD = "//*[@data-key=\"view=compose-field-to-error\"]";
  private static final String LETTER_DONE_MASSAGE = "//*[@class=\"mail-Done-Title js-title-info\"]";
  private static final String SAVE_AND_LEAVE_BUTTON = "//span[text()=\"Сохранить и перейти\"]";

  public MailPageYandex(WebDriver driver) {
    super(driver);
  }

  public static String getDefaultSubject() {
    return DEFAULT_SUBJECT;
  }

  public static String getLetterErrorMassage() {
    return LETTER_ERROR_MASSAGE;
  }

  public MailPageYandex clickRefreshButton() {
    clickElement(REFRESH_BUTTON);
    return this;
  }

  public MailPageYandex clickDeleteButton() {
    clickElement(DELETE_BUTTON);
    return this;
  }

  public MailPageYandex clickDraftButton() {
    clickElement(DRAFT_BUTTON);
    return this;
  }

  public MailPageYandex clickTrashButton() {
    clickElement(TRASH_BUTTON);
    return this;
  }

  public MailPageYandex clickLastLetterFlag() {
    clickElement(LAST_LETTER_FLAG);
    return this;
  }

  public MailPageYandex clickAllLettersFlag() {
    clickElement(ALL_LETTER_FLAG);
    return this;
  }

  public MailPageYandex clickSaveAndLeaveButton() {
    clickElement(SAVE_AND_LEAVE_BUTTON);
    return this;
  }


  public MailPageYandex clickComposeLetterButton() {
    clickElement(COMPOSE_BUTTON);
    return this;
  }

  public MailPageYandex sendKeysToRecipientField(String recipient) {
    sendKeysToElement(RECIPIENT_FIELD, recipient);
    return this;
  }

  public MailPageYandex sendKeysToSubjectInputField(String subject) {
    sendKeysToElement(SUBJECT_INPUT_FIELD, subject);
    return this;
  }

  public MailPageYandex sendKeysToLetterInputField(String content) {
    sendKeysToElement(LETTER_INPUT_FIELD, content);
    return this;
  }

  public MailPageYandex clickSendLetterButton() {
    clickElement(SEND_LETTER_BUTTON);
    return this;
  }

  public MailPageYandex clickInboxButton() {
    WebElement inboxButton = waitElementToBeVisible(LETTER_DONE_MASSAGE)
        .findElement(By.xpath(INBOX_BUTTON));
    inboxButton.click();
    return this;
  }

  public MailPageYandex clickSentButton() {
    fluentClickElement(SENT_BUTTON);
    return this;
  }

  public String getLastLetterSubject() {
    return getTextFromElement(LAST_LETTER_SUBJECT);
  }

  public String getErrorMassage() {
    return getTextFromElement(ERROR_FIELD);
  }


  public String getUserName() {
    return getTextFromElement(USER_NAME_BUTTON);
  }
}
