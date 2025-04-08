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
                Open.browserOn().the(DuckDuckGoHomePage.class));
    }
    
    @Then("{actor} should see the logo of DuckDuckGo")
    public void theLogoShouldBeVisible() {
        HomepageSteps.verifyLogoIsVisible();
    }

    @Given("{actor} is researching things on the internet")
    @Given("{actor} is on the homepage")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(HomepageStepDefinitions.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
            HomepageSteps.about(term)
        );
    }
    
    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }
}
