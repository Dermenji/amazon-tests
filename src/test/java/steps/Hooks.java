package steps;

import com.codeborne.selenide.Selenide;
import framework.configuration.TestsConfig;
import framework.webtestbase.WebDriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

  @Before
  public void before() {
    WebDriverFactory.startBrowser();
    open(TestsConfig.getConfig().getUrl());
  }

  @After
  public void after(Scenario scenario) {
    try {
      if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
      }
    } catch (Exception ignore) {

    } finally {
      Selenide.clearBrowserLocalStorage();
      Selenide.clearBrowserCookies();
      // closeWebDriver();
    }
  }

}