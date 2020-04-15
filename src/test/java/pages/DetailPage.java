package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DetailPage {

  public SelenideElement getProperty(String prop) {
    return $(byText(prop)).sibling(0);
  }

}
