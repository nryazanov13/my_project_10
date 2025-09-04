package lesson10;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {

        open("");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}
