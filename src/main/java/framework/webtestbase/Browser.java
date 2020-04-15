package framework.webtestbase;

public enum Browser {
  FIREFOX("firefox"),
  CHROME("chrome"),
  IE11("ie11"),
  EDGE("edge"),
  SAFARI("safari");
  private String browserName;

  Browser(String browserName) {
    this.browserName = browserName;
  }

  public static Browser getByName(String name) {
    for (Browser browser : values()) {
      if (browser.getBrowserName().equalsIgnoreCase(name)) {
        return browser;
      }
    }
    return null;
  }

  public String getBrowserName() {
    return browserName;
  }
}
