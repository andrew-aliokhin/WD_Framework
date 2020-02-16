package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageYandex;

public class TestRanner {

  public static void main(String[] args) throws InterruptedException {
    User trueUSer = new User("user.it.advssdcademy","it.academy.user","@yandex.ru");
    Email email = new Email(trueUSer,"'Есть в 2-х папках","123456");
    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
   WebDriver webDriver = new ChromeDriver();
   LoginPageYandex loginPageYandex =new LoginPageYandex(webDriver);
   loginPageYandex.open().clickEnterButton().enterLogin(trueUSer).clickSignInButton().clearLoginField().enterLogin(trueUSer);

  }

}
