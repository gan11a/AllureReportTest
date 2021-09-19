package cf.iqas.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step ("Open Main Page")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Search4Repo {repo}" )
    public void search4Repo(String repo){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }
    @Step("OpenRepo {repo}")
    public void openRepo(String repo){
        $(linkText(repo)).click();
    }
    @Step("OpenIssues")
    public void openIssues(){
        $(partialLinkText("Issues")).click();
    }
    @Step("CheckIssue {number}")
    public void checkIssue(int number){
        $(byText("#" + number)).should(Condition.visible);
    }
}
