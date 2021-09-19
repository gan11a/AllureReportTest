package cf.iqas.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedStepTest {
    private final static String REPO = "eroshenkoam/allure-example";
    private final static Integer ISSUENUM = 74;
    @Test
    public void testGit() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.search4Repo(REPO);
        steps.openRepo(REPO);
        steps.openIssues();
        steps.checkIssue(ISSUENUM);
    }
}
