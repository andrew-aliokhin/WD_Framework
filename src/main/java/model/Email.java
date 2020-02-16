package model;

public class Email {
  private User recipient;
  private String subject;
  private String content;

  public Email(User massageRecipient, String subject, String content) {
    this.recipient = massageRecipient;
    this.subject = subject;
    this.content = content;
  }

  public User getRecipient() {
    return recipient;
  }

  public void setRecipient(User recipient) {
    this.recipient = recipient;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
