package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

  private static Browser instance;
  private static WebDriver driver;

  private Browser() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public static Browser getInstance() {
    if (instance == null) {
      return new Browser();
    }
    return instance;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static boolean isElementPresent(String locator) {
    return getDriver().findElements(By.xpath(locator)).size() > 0;
  }

  public static void clickElement(String locator) {
    try {
      if (isElementPresent(locator)) {
        getDriver().findElement(By.xpath(locator)).click();
      }
    } catch (StaleElementReferenceException e) {
      if (isElementPresent(locator)) {
        getDriver().findElement(By.xpath(locator)).click();
      }
    }
  }

  public static void closeBrowser() {
    driver.quit();
    instance = null;
  }

  public static void sendKeysToElement(String locator, String text) {
    WebElement element = waitElementToBeVisible(locator);
    element.sendKeys(text);
  }

  public static String getTextFromElement(String locator) {
    String string = "";
    try {
      if (isElementPresent(locator)) {
        string = getDriver().findElement(By.xpath(locator)).getText();
      }
    } catch (StaleElementReferenceException e) {
      if (isElementPresent(locator)) {
        string = getDriver().findElement(By.xpath(locator)).getText();
      }
    }
    return string;
  }

  public static void openTab(String url) {
    driver.get(url);
  }

  public static void refreshTab() {
    driver.navigate().refresh();
  }

  public static WebElement waitElementToBeVisible(String locator) {
    return new WebDriverWait(driver, 15)
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }
}

