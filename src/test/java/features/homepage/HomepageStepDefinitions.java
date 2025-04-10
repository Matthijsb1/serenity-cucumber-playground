package features.homepage;

import features.homepage.steps.HomepageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import pages.DuckDuckGoHomePage;

public class HomepageStepDefinitions {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn()
                        .the(DuckDuckGoHomePage.class));
    }

    @Then("{actor} is on the {string} page")
    public void isOnPageX(Actor actor, String expectedPageName) {
        String actualPageName = TheWebPage.title().answeredBy(actor);

        if (expectedPageName.equalsIgnoreCase("AI")) {
            actor.attemptsTo(
                    Ensure.that(actualPageName)
                            .containsIgnoringCase("Duck.ai"));
        } else if (expectedPageName.equalsIgnoreCase("download")) {
            actor.attemptsTo(
                    Ensure.that(actualPageName)
                            .containsIgnoringCase("DuckDuckGo voor Windows downloaden"));
        } else {
            throw new IllegalArgumentException("Your test is broken, the page title was: " + actualPageName);
        }
    }

    @When("{actor} opens the AI Chat")
    public void clickOnAiButton(Actor actor) {
        actor.attemptsTo(
                HomepageSteps.openAiChat());
    }

    @When("{actor} sets DuckDuckGo as his default search engine")
    public void setDefaultSearchEgine(Actor actor) {
        actor.attemptsTo(
                HomepageSteps.setSearchEngine());
    }

    @Then("{actor} should see instructions on how to do this")
    public void should_see_instructions_on_default_search_engine(Actor actor) {
        actor.attemptsTo(
                HomepageSteps.seeInstructions());
    }

    @When("{actor} want to download the browser")
    public void downloadBrowser(Actor actor) {
        actor.attemptsTo(
                HomepageSteps.downloadBrowser());
    }

    @Given("{actor} is researching things on the internet")
    @Given("{actor} is on the homepage")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(HomepageStepDefinitions.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                HomepageSteps.about(term));
    }

    @Then("{actor} should see information about {string}")
    public void shouldSeeInformationAbout(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term));
    }
}
