package features.homepage.steps;

import pages.DuckDuckGoHomePage;
import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

public class HomepageSteps {

    public static Performable setSearchEngine() {
        return Task.where("{0} clicks set as Default Search",
                Click.on(
                        DuckDuckGoHomePage.DEFAULT_BUTTON));
    }

    public static Performable downloadBrowser() {
        return Task.where("{0} clicks download browser",
                Click.on(
                        DuckDuckGoHomePage.DOWNLOAD_BROWSER_BUTTON));
    }

    public static Performable openAiChat() {
        return Task.where("{0} clicks on AI Chat Button",
                Click.on(
                        DuckDuckGoHomePage.VISIBLE_CHAT_BUTTON));
    }

    public static Performable seeInstructions() {
        return Task.where("{0} sees instructions to set DDG as default search}", actor -> {
            actor.attemptsTo(
                    Ensure.that(
                            DuckDuckGoHomePage.GOT_IT_BUTTON)
                            .isDisplayed());
        });
    }

    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(DuckDuckGoHomePage.SEARCH_FIELD)
                        .thenHit(Keys.ENTER));
    }

    public static Performable lookforInformation(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(DuckDuckGoHomePage.SEARCH_FIELD)
                        .thenHit(Keys.ENTER));
    }
}
