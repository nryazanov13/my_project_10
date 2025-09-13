package lesson10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public static final String REPOSITORY = "nryazanov13/my_project_10";
    public static final int ISSUE = 1;

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    public void setUpListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }
}
