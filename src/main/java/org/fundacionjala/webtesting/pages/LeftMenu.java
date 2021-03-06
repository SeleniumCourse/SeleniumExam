package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class LeftMenu extends AbstractBasePage {

    @FindBy(id = "filter_inbox")
    private WebElement inboxLink;

    public ProjectContainer goToInbox() {
        clickWebElement(inboxLink);
        return new ProjectContainer();
    }

}
