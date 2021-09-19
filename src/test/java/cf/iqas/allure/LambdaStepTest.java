package cf.iqas.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private final static String REPO = "eroshenkoam/allure-example";
    private final static Integer ISSUENUM = 74;
    @Test
    public void testGit() {
        step("Open Main Page", () -> {
            open("https://github.com");
        });
        step("Search4Repo" + REPO,() -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO);
            $(".header-search-input").submit();
        });
        step("OpenRepo"+ REPO, () -> {
            $(linkText(REPO)).click();
        });
        step("OpenIssues",() ->{
            $(partialLinkText("Issues")).click();
        });
        step("CheckIssue"+ ISSUENUM, () -> {
            $(byText("#" + ISSUENUM)).should(Condition.visible);
        });
    }
}
