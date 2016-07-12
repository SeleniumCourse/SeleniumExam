package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class HomePage extends AbstractBasePage {

    private static final String baseUrl = "https://en.todoist.com/";

    @FindBy(className = "sel_login")
    private WebElement loginBtn;

    public HomePage() {
        driver.get(baseUrl);
    }

    public LoginPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new LoginPage();
    }

}
