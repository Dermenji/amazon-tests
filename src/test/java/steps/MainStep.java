package steps;

import com.codeborne.selenide.Condition;
import framework.utils.CucumberUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DetailPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;

public class MainStep {

  private DetailPage detailPage = page(DetailPage.class);

  @When("Select a {int} stared item")
  public void selectAStaredItem(int stars) {
    $$x("//*[contains (@class, 'a-star-small-" + stars + "')]/ancestor::div[@class='sg-col-inner'][1]//h2/a").first().click();
  }

  @Then("Once the details page for the laptop is opened, verify it's the selected laptop")
  public void onceTheDetailsPageForTheLaptopIsOpenedVerifyItSTheSelectedLaptop(DataTable table) {
    CucumberUtil.ConvertDataTableToList(table);

    detailPage.getProperty("Hard Disk Technology")
            .shouldHave(Condition.text(CucumberUtil.GetCellValueWithRowIndex("Storage", 1)));

    detailPage.getProperty("Screen Size")
            .shouldHave(Condition.text(CucumberUtil.GetCellValueWithRowIndex("Size", 1)));

    detailPage.getProperty("Processor Type")
            .shouldHave(Condition.text(CucumberUtil.GetCellValueWithRowIndex("CPU", 1)));

  }
}
