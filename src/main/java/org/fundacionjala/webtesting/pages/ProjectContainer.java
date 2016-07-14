package org.fundacionjala.webtesting.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;
import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.isElementPresent;
import static org.fundacionjala.webtesting.pages.TaskSteps.PROJECT;
import static org.fundacionjala.webtesting.pages.TaskSteps.TASK_NAME;

public class ProjectContainer extends AbstractBasePage {

    @FindBy(xpath = "//a[@class='project_link']")
    private WebElement projectName;

    @FindBy(linkText = "Add Task")
    private WebElement addTaskLink;

    @FindBy(xpath = "//div[@class='AmiMenu' and not(contains(@style, 'none'))]/descendant::div[contains(.,'Delete task')]")
    private WebElement deleteTaskOption;

    @FindBy(css = ".text_cursor.content.task_content_item")
    private WebElement lastTaskName;

    @FindBy(css = ".project_link")
    private WebElement projectLabel;

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

    public String getLastTaskName() {
        wait.until(ExpectedConditions.visibilityOf(lastTaskName));
        return lastTaskName.getText();
    }

    public String getProjectLabel() {
        wait.until(ExpectedConditions.visibilityOf(projectLabel));
        return projectLabel.getText();
    }

    public Map<TaskSteps,String> getAssertionMap() {
        final Map<TaskSteps, String> assertionMap = new HashMap<>();
        assertionMap.put(TASK_NAME, getLastTaskName());
        assertionMap.put(PROJECT, getProjectLabel());
        return assertionMap;
    }

}
