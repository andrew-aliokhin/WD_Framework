package framework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

  public static void clickElement(String locator) {
    WebElement element = fluentWaitElement(locator).findElement(By.xpath(locator));
    element.click();
  }

  public static void fluentClickElement(String locator) {
    WebElement element = fluentWaitElement(locator).findElement(By.xpath(locator));
    element.click();
  }

  public static WebElement waitElementToBeClickable(String locator) {
    return (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
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
    WebElement element = fluentWaitElement(locator);
    return element.getText();
  }

  public static void openTab(String url) {
    driver.get(url);
  }

  public static void refreshTab() {
    driver.navigate().refresh();
  }

  public static WebElement waitElementToBeVisible(String locator) {
    return new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  public static WebElement fluentWaitElement(String locator) {
    Wait wait = new FluentWait(getDriver()).withTimeout(Duration.ofSeconds(10)).
        pollingEvery(Duration.ofMillis(50)).ignoring(StaleElementReferenceException.class);

    WebElement foo = (WebElement) wait.until(
        (Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath(locator)));
    return foo;
  }

}

