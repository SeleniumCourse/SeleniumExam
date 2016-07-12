package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class QuickAddTask extends AddTask<QuickAddTask> {

    @FindBy(css = ".cmp_dark_highlight_project.form_action_icon")
    private WebElement projectSelector;

    public QuickAddTask selectProject(String projectName) {
        clickWebElement(projectSelector);
        By projectOption = By.xpath("//span[@class='project_select_item' and contains(., '" + projectName + "')]");
        driver.findElement(projectOption).click();
        return getThis();
    }

    protected QuickAddTask getThis() {
        return this;
    }

}
