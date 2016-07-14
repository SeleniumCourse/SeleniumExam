package org.fundacionjala.webtesting.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;
import static org.fundacionjala.webtesting.pages.TaskSteps.PRIORITY;
import static org.fundacionjala.webtesting.pages.TaskSteps.PROJECT;
import static org.fundacionjala.webtesting.pages.TaskSteps.TASK_NAME;

public class QuickAddTask extends AddTask<QuickAddTask> {

    @FindBy(css = ".cmp_dark_highlight_project.form_action_icon")
    private WebElement projectSelector;

    public QuickAddTask selectProject(String projectName) {
        clickWebElement(projectSelector);
        final By projectOption = By.xpath("//span[@class='project_select_item' and contains(., '" + projectName + "')]");
        driver.findElement(projectOption).click();
        return getThis();
    }

    public Map<TaskSteps,IAutomationStep> getStrategyStepMap(Map<TaskSteps, Object> valuesMap) {
        final Map<TaskSteps, IAutomationStep> strategyStepMap = new HashMap<>();
        strategyStepMap.put(TASK_NAME, () -> setTaskNameTxt(String.valueOf(valuesMap.get(TASK_NAME))));
        strategyStepMap.put(PROJECT, () -> selectProject(String.valueOf(valuesMap.get(PROJECT))));
        strategyStepMap.put(PRIORITY, () -> selectPriority(Integer.parseInt(String.valueOf(valuesMap.get(PRIORITY)))));
        return strategyStepMap;
    }

    @Override
    protected QuickAddTask getThis() {
        return this;
    }

}
