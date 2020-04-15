package steps;

import io.cucumber.java.en.And;
import pages.FilterAndSort;

import static com.codeborne.selenide.Selenide.page;

public class FilterAndSortStep {
  private FilterAndSort filterAndSort = page(FilterAndSort.class);

  @And("Select (Display Size|CPU Type|Storage Type) /(.*?)/$")
  public void selectDisplaySize(String type, String param) {
    filterAndSort.select(type, param);
  }

  @And("Sort by {string}")
  public void sortBy(String param) {
    filterAndSort.sort(param);
  }
}
