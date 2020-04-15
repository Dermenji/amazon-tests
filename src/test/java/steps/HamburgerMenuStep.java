package steps;

import io.cucumber.java.en.Given;
import pages.HamburgerMenu;

import static com.codeborne.selenide.Selenide.page;

public class HamburgerMenuStep {
  private HamburgerMenu hamburgerMenu = page(HamburgerMenu.class);

  @Given("From the hamburger menu in the upper left-hand corner select {string}")
  public void fromTheHamburgerMenuInTheUpperLeftHandCornerSelect(String type) {
    hamburgerMenu.expand();
    hamburgerMenu.selectFromMainMenu(type);
  }

  @Given("From the following menu select {string}")
  public void fromTheFollowingMenuSelect(String type) {
    hamburgerMenu.selectFromFollowingMenu(type);
  }
}
