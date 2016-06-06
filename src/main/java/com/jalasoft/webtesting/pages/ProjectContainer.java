package com.jalasoft.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.webtesting.framework.selenium.CommonMethods.clickWebElement;
import static com.jalasoft.webtesting.framework.selenium.CommonMethods.isElementPresent;

public class ProjectContainer extends AbstractBasePage {

    @FindBy(xpath = "//a[@class='project_link']")
    private WebElement projectName;

    @FindBy(linkText = "Add Task")
    private WebElement addTaskLink;

    @FindBy(xpath = "//div[@class='AmiMenu' and not(contains(@style, 'none'))]/descendant::div[contains(.,'Delete task')]")
    private WebElement deleteTaskOption;

    public AddTask clickAddTaskLnk() {
        addTaskLink.click();
        return new AddTask();
    }

    public Boolean isTaskAdded(String taskName) {
        By task = By.xpath("//tr[contains(.,'" + taskName + "')]");
        return isElementPresent(driver.findElement(task));
    }

    public void clickTaskMenu(String taskName) {
        WebElement taskElement = driver.findElement(By.xpath("//tr[contains(.,'" + taskName + "')]"));

        Action rightClick = new Actions(driver)
                .contextClick(taskElement).build();
        rightClick.perform();
    }

    public void clickDeleteTask() {
        clickWebElement(deleteTaskOption);
        DeleteAlert deleteAlert = new DeleteAlert();
        deleteAlert.clickOkBtn();
    }

}
