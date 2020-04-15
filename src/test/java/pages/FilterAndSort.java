package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FilterAndSort {

  @FindBy(id = "s-result-sort-select")
  private SelenideElement sortBy;

  public void select(String type, String param) {
    $(byXpath(String.format("//*[text()='%s']/../..//*[text()='%s']", type, param))).shouldBe(Condition.visible).click();
  }

  public void sort(String param) {
    sortBy.selectOption(param);
  }
}
