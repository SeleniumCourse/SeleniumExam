package com.jalasoft.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.webtesting.framework.selenium.CommonMethods.clickWebElement;

public class QuickAddTask extends AddTask {

    @FindBy(css = "a > .project_select_item > span")
    private WebElement projectSelector;

    public void selectProject(String projectName) {
        clickWebElement(projectSelector);
        By projectOption = By.xpath("//span[@class='project_select_item' and contains(., '" + projectName + "')]");
        driver.findElement(projectOption).click();
    }

}
