package pages;

import model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.MailTest;


public class MailPageYandex extends BasePage {

  private static final String EMAIL_ERROR_MASSAGE = "Поле не заполнено. Необходимо ввести адрес.";
  private static final String DEFAULT_SUBJECT = "(Без темы)";
  private static final String PAGE_URL = "https://mail.yandex.by/";
  private static final String COMPOSE_BUTTON = "//*[@class=\"mail-ComposeButton js-main-action-compose\"]";
  private static final String REFRESH_BUTTON = "//*[@title=\"Проверить, есть ли новые письма (F9)\"]";
  private static final String SEND_EMAIL_BUTTON = "//*[@class=\"mail-Compose-Field-Actions-Footer-Main\"]//span[text()=\"Отправить\"]";
  private static final String INBOX_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#inbox\"]";
  private static final String SENT_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#sent\"]";
  private static final String DELETE_BUTTON = "//*[@title=\"Удалить (Delete)\"]";
  private static final String USER_NAME_BUTTON = "//*[@class=\"mail-User-Name\"]";
  private static final String DRAFT_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#draft\"]";
  private static final String TRASH_BUTTON = "//*[@class=\"mail-Layout-Inner\"]//*[@href=\"#trash\"]";
  private static final String LAST_EMAIL_SUBJECT = "//*[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]/div[1]//*[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]/span";
  private static final String LASE_EMAIL_FLAG = "//*[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]/div[1]//*[@class=\"_nb-checkbox-flag _nb-checkbox-normal-flag\"]";
  private static final String RECIPIENT_FIELD = "//*[@name=\"to\"]";
  private static final String SUBJECT_INPUT_FIELD = "//*[@class=\"mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev\"]";
  private static final String EMAIL_INPUT_FIELD = "//*[@role=\"textbox\"]";
  private static final String ERROR_FIELD = "//*[@data-key=\"view=compose-field-to-error\"]";
  private static final String EMAIL_DONE_MASSAGE = "//*[@class=\"mail-Done-Title js-title-info\"]";
  private static final String SAVE_AND_LEAVE_BUTTON = "//span[text()=\"Сохранить и перейти\"]";
  WebElement recipientField;
  WebElement subjectInputField;
  WebElement emailInputField;
  WebElement sendEmailButton;
  WebElement inboxButton;
  WebElement sentButton;
  WebElement lastEmailSubject;

  public MailPageYandex(WebDriver driver) {
    super(driver);
  }

  public static String getDefaultSubject() {
    return DEFAULT_SUBJECT;
  }

  public static String getEmailErrorMassage() {
    return EMAIL_ERROR_MASSAGE;
  }

  public MailPageYandex clickRefreshButton() throws InterruptedException {
    Thread.sleep(2000);
    WebElement refreshButton = driver.findElement(By.xpath(REFRESH_BUTTON));
    refreshButton.click();
    Thread.sleep(2000);
    return this;
  }

  public MailPageYandex clickDeleteButton() {
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE_BUTTON)));
    WebElement deleteButton = explicitWait.findElement(By.xpath(DELETE_BUTTON));
    deleteButton.click();
    return this;
  }

  public MailPageYandex clickDraftButton() {
    WebElement draftButton = driver.findElement(By.xpath(DRAFT_BUTTON));
    draftButton.click();
    return this;
  }

  public MailPageYandex clickTrashButton() {
    WebElement trashButton = driver.findElement(By.xpath(TRASH_BUTTON));
    trashButton.click();
    return this;
  }

  public MailPageYandex clickLastEmailFlag() {
    WebElement lastEmailFlag = driver.findElement(By.xpath(LASE_EMAIL_FLAG));
    lastEmailFlag.click();
    return this;
  }

  public MailPageYandex clickSaveAndLeaveButton() {
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SAVE_AND_LEAVE_BUTTON)));
    WebElement saveAndLeaveButton = explicitWait.findElement(By.xpath(SAVE_AND_LEAVE_BUTTON));
    saveAndLeaveButton.click();
    return MailTest.mailPageYandex;
  }

  public MailPageYandex composeMail() {
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMPOSE_BUTTON)));
    WebElement composeButton = explicitWait.findElement(By.xpath(COMPOSE_BUTTON));
    composeButton.click();
    return this;
  }

  public MailPageYandex enterRecipient(Email email) {
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(RECIPIENT_FIELD)));
    recipientField = explicitWait.findElement(By.xpath(RECIPIENT_FIELD));
    recipientField.sendKeys(email.getRecipient().getFullName());
    return this;
  }

  public MailPageYandex enterSubject(Email email) {
    subjectInputField = driver.findElement(By.xpath(SUBJECT_INPUT_FIELD));
    subjectInputField.sendKeys(email.getSubject());
    return this;
  }

  public MailPageYandex enterContent(Email email) {
    emailInputField = driver.findElement(By.xpath(EMAIL_INPUT_FIELD));
    emailInputField.sendKeys(email.getContent());
    return this;
  }

  public MailPageYandex clickSendEmailButton() {
    sendEmailButton = driver.findElement(By.xpath(SEND_EMAIL_BUTTON));
    sendEmailButton.click();
    return this;

  }

  public MailPageYandex clickInboxButton() {
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_DONE_MASSAGE)));
    inboxButton = explicitWait.findElement(By.xpath(INBOX_BUTTON));
    inboxButton.click();
    return this;
  }

  public MailPageYandex clickSentButton() {
    sentButton = driver.findElement(By.xpath(SENT_BUTTON));
    sentButton.click();
    return this;
  }


  public String getLastEmailSubject() throws InterruptedException {
    Thread.sleep(2000);
    WebElement explicitWait = (new WebDriverWait(driver, 20))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(LAST_EMAIL_SUBJECT)));
    lastEmailSubject = explicitWait.findElement(By.xpath(LAST_EMAIL_SUBJECT));
    return lastEmailSubject.getText();

  }

  public String getErrorMassage() {
    WebElement errorField = driver.findElement(By.xpath(ERROR_FIELD));
    return errorField.getText();

  }

  public String getUserName() {
    WebElement userNameButton = driver.findElement(By.xpath(USER_NAME_BUTTON));
    return userNameButton.getText();
  }

  public MailPageYandex open() {
    driver.get(PAGE_URL);
    return this;
  }


}
