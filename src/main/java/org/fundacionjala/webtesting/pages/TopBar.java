package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class TopBar extends AbstractBasePage {

    @FindBy(id = "quick_add_task_holder")
    private WebElement addTaskIcon;

    public QuickAddTask clickAddTaskIcon() {
        clickWebElement(addTaskIcon);
        return new QuickAddTask();
    }

}
