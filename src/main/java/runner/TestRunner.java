package runner;

import java.util.Collections;
import java.util.List;
import org.testng.TestNG;

public class TestRunner {

  public static void main(String[] args) {
    TestNG testNG = new TestNG();
    List<String> file = Collections.singletonList("src/main/resources/LoginSuite.xml");
    testNG.setTestSuites(file);
    testNG.run();
  }
}
