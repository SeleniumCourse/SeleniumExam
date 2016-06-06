package com.jalasoft.webtesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class TopBar extends AbstractBasePage {

    @FindBy(id = "icon_add_task")
    private WebElement addTaskIcon;

    public QuickAddTask clickAddTaskIcon() {
        clickWebElement(addTaskIcon);
        return new QuickAddTask();
    }

}
