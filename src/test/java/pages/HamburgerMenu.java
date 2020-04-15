package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;

public class HamburgerMenu {
  @FindBy(css = "*[aria-label='Open Menu']")
  private SelenideElement burger;

  @FindBy(id = "hmenu-content")
  private SelenideElement hmenuContent;


  public void expand() {
    burger.click();
  }

  public void selectFromMainMenu(String type) {
    hmenuContent.$(byText(type)).click();
  }

  public void selectFromFollowingMenu(String type) {
    hmenuContent.$(byClassName("hmenu-translateX")).$(byText(type)).click();
  }
}
