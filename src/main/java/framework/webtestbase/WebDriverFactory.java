package framework.webtestbase;

import com.codeborne.selenide.Configuration;
import framework.configuration.TestsConfig;


public class WebDriverFactory {

  public static void startBrowser() {

    Browser browser = TestsConfig.getConfig().getBrowser();
    System.out.println("Start browser " + TestsConfig.getConfig().getBrowser());

    Boolean useProxy = Boolean.valueOf(TestsConfig.getConfig().getUseProxy());
    Boolean useProxyParam = Boolean.valueOf(System.getProperty("proxy"));

    if (useProxy || useProxyParam) {
      String proxyAddress = TestsConfig.getConfig().getProxyAddress();
      Configuration.browserCapabilities = BrowserCapabilities.getBrowserCapabilities(browser, proxyAddress);
    }

    switch (browser) {
      case FIREFOX:
        Configuration.browser = "firefox";
        break;
      case CHROME:
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        break;
      case IE11:
        Configuration.browser = "ie";
        break;
      case EDGE:
        Configuration.browser = "edge";
        break;
      case SAFARI:
        Configuration.browser = "safari";
        break;
      default:
        throw new IllegalStateException("Unsupported browser type");
    }
  }
}