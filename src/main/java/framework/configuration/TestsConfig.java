package framework.configuration;

import framework.configuration.properties.PropertiesLoader;
import framework.configuration.properties.Property;
import framework.configuration.properties.PropertyFile;
import framework.webtestbase.Browser;


@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("browser.name")
    private String browser = "firefox";

    @Property("page.url")
    private String url = "";

    @Property("use.proxy")
    private String useProxy;

    @Property("proxy.address")
    private String proxyAddress;

    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUseProxy() {
        return useProxy;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }
}