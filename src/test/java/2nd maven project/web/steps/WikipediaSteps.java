package 2nd maven project.web.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import 2nd maven project.web.pages.wikipedia.WikipediaHomePage;
import 2nd maven project.web.pages.wikipedia.WikipediaResultsPage;

public class WikipediaSteps extends PageSteps {

    @Given("The user is in wikipedia page")
    public void goToWikipediaHomePage() {
        Injector._page(WikipediaHomePage.class).goToHomePage();
    }

    @When("The user search for (.*)")
    public void doSearchProcess(String word) {
        Injector._page(WikipediaHomePage.class).setSearchInput(word);
        Injector._page(WikipediaHomePage.class).clickSearchButton();
    }

    @Then("The (.*) is searched correctly")
    public void verifyCorrectSearch(String word) {
        Assert.assertEquals(word, Injector._page(WikipediaResultsPage.class).getResultTitle());
    }
}
