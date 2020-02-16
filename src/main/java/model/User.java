package model;

public class User {
  private String userName;
  private String password;
  private String domainName;
//  private  String TRUE_USER_NAME = "user.it.academy";
//  private  String TRUE_PASSWORD = "it.academy.user";
//  private  String FALSE_USER_NAME = "login";
//  private  String FALSE_PASSWORD = "password";

  public User(String userName, String password, String domainName) {
    this.userName = userName;
    this.password = password;
    this.domainName=domainName;
  }

  public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public String getFullName(){
    return userName+domainName;
  }
}
