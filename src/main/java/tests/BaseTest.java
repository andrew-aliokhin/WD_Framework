package tests;

import static framework.Browser.closeBrowser;
import static framework.Browser.getInstance;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  @BeforeSuite
  public void openBrowser() {
    System.out.println("Only ont time");
    getInstance();
  }

  @AfterSuite(enabled = false)
  public void stopBrowser() {
    closeBrowser();
  }
}
