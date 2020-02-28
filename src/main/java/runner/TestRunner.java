package runner;

import java.util.Arrays;
import java.util.List;
import org.testng.TestNG;

public class TestRunner {

  public static void main(String[] args) {
    TestNG testNG = new TestNG();
    List<String> file = Arrays.asList("src/main/resources/LoginSuite.xml");
    testNG.setTestSuites(file);
    testNG.run();
  }
}
