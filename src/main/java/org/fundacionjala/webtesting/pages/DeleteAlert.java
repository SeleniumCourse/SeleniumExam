package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class DeleteAlert extends AbstractBasePage {

    @FindBy(css = "div.GB_Window_holder")
    private WebElement deleteAlertContainer;

    @FindBy(xpath = "//span[contains(.,'Ok')]")
    private WebElement okBtn;

    public void clickOkBtn() {
        wait.until(ExpectedConditions.visibilityOf(deleteAlertContainer));
        clickWebElement(okBtn);
    }

}
