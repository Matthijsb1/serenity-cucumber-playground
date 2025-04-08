package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://duckduckgo.com/")
public class DuckDuckGoHomePage extends PageObject {
    public static final Target LOGO = 
            Target.the("DuckDuckGo Logo")
                  .locatedBy("img[alt='DuckDuckGo Logo']");

    public static final Target SEARCH_FIELD = 
            Target.the("Search field")
                  .locatedBy("#searchbox_input");

    public static final Target SEARCH_BUTTON = 
            Target.the("Search button")
                  .locatedBy("#search_button_homepage");

    public static final Target BODY =
            Target.the("article identifier")
                  .locatedBy("//article");
    
    public static boolean isLogoVisible() {
            return WebElementQuestion
                            .the(LOGO)
                            .answeredBy(null)
                            .isVisible();
    }
}