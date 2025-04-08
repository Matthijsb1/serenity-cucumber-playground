package features.homepage.steps;

import pages.DuckDuckGoHomePage;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;


public class HomepageSteps {

    public static Performable verifyLogoIsVisible() {
        return Task.where("checks if the logo is visible", actor -> {
            actor.attemptsTo(Ensure.that(DuckDuckGoHomePage.LOGO).isDisplayed());
        });
    }

    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
            Enter.theValue(searchTerm)
                 .into(DuckDuckGoHomePage.SEARCH_FIELD)
                 .thenHit(Keys.ENTER)
        );
    }

    public static Performable lookforInformation(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
            Enter.theValue(searchTerm)
                    .into(DuckDuckGoHomePage.SEARCH_FIELD)
                    .thenHit(Keys.ENTER));
    }
}
