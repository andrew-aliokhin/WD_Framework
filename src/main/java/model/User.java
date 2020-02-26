package model;

public class User {

  private static final String USER_NAME = "user.it.academy";
  private static final String PASSWORD = "it.academy.user";
  private static final String DOMAIN_NAME = "@yandex.ru";

  private static final String FALSE_USER_NAME = "invalidUserNameItAcademy";
  private static final String FALSE_PASSWORD = "InvalidPassword";

  public static String getUserName() {
    return USER_NAME;
  }

  public static String getPassword() {
    return PASSWORD;
  }

  public static String getFalseUserName() {
    return FALSE_USER_NAME;
  }

  public static String getFalsePassword() {
    return FALSE_PASSWORD;
  }

  public static String getFullName() {
    return USER_NAME + DOMAIN_NAME;
  }
}
