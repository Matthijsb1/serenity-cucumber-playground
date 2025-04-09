package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://duckduckgo.com/")
public class DuckDuckGoHomePage extends PageObject {
        public static final Target AI_BUTTON = Target
                        .the("AI button")
                        .locatedBy("//a[contains(@class, 'aiChatButton')]");

        public static final Target DEFAULT_BUTTON = Target
                        .the("Set as Default Search button")
                        .locatedBy("//a[contains(@class, 'button') and text()='Instellen als standaard zoekmachine']");

        public static final Target GOT_IT_BUTTON = Target
                        .the("Got It button")
                        .locatedBy("//button[text()='Ik snap het']");

        public static final Target DOWNLOAD_BROWSER_BUTTON = Target
                        .the("Download Browser button")
                        .locatedBy("//a[contains(@class, 'button') and text()='Browser downloaden']");

        public static final Target SEARCH_FIELD = Target
                        .the("Search field")
                        .locatedBy("#searchbox_input");

        public static final Target SEARCH_BUTTON = Target
                        .the("Search button")
                        .locatedBy("#search_button_homepage");

        public static final Target BODY = Target
                        .the("article identifier")
                        .locatedBy("//article");

        // public static boolean isLogoVisible() {
        //         return WebElementQuestion
        //                         .the(LOGO)
        //                         .answeredBy(null)
        //                         .isVisible();
        // }
}