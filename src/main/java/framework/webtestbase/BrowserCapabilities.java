package framework.webtestbase;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

class BrowserCapabilities {

  static DesiredCapabilities getBrowserCapabilities(Browser browser, String proxyAddress) {
    // Set proxy
    Proxy proxy = new Proxy();
    proxy.setHttpProxy(proxyAddress).setSslProxy(proxyAddress);

    // Set Desired Capabilities 
    //private static Proxy proxy;
    DesiredCapabilities capabilities;
    switch (browser) {
      case FIREFOX:
        capabilities = DesiredCapabilities.firefox();
        break;
      case CHROME:
        capabilities = DesiredCapabilities.chrome();
        break;
      case IE11:
        capabilities = DesiredCapabilities.internetExplorer();
        break;
      case EDGE:
        capabilities = DesiredCapabilities.edge();
        break;
      case SAFARI:
        capabilities = DesiredCapabilities.safari();
        break;
      default:
        throw new IllegalStateException("Unsupported browser type");
    }

    capabilities.setCapability(CapabilityType.PROXY, proxy);
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

    return capabilities;
  }
}