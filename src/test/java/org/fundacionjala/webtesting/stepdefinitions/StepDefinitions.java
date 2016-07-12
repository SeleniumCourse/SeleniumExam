package org.fundacionjala.webtesting.stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.webtesting.pages.IAutomationStep;
import org.fundacionjala.webtesting.pages.LoginPage;
import org.fundacionjala.webtesting.pages.MainApp;
import org.fundacionjala.webtesting.pages.ProjectContainer;
import org.fundacionjala.webtesting.pages.QuickAddTask;
import org.fundacionjala.webtesting.pages.TaskSteps;
import org.fundacionjala.webtesting.pages.TopBar;

import static org.fundacionjala.webtesting.pages.TaskSteps.PRIORITY;
import static org.fundacionjala.webtesting.pages.TaskSteps.PROJECT;
import static org.fundacionjala.webtesting.pages.TaskSteps.TASK_NAME;

public class StepDefinitions {

    private MainApp mainApp;

    private QuickAddTask quickAddTask;

    private ProjectContainer projectContainer;

    @Given("I login as Primary User")
    public void iLoginAsPrimaryUser() {
        mainApp = LoginPage.loginAsPrimaryUser();
    }

    @When("I create a Quick Task :")
    public void iCreateAQuickTask(Map<TaskSteps, Object> values) {

        TopBar topBar = mainApp.goToTopBar();
        quickAddTask = topBar.clickAddTaskIcon();

        executeSteps(values, quickAddTask);

        projectContainer = quickAddTask.clickAddTaskBtn();
    }

    private void executeSteps(Map<TaskSteps, Object> values, QuickAddTask quickAddTask) {
        Map<TaskSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(TASK_NAME, () -> quickAddTask.setTaskNameTxt(values.get(TASK_NAME).toString()));
        strategyMap.put(PRIORITY, () -> quickAddTask.selectPriority(Integer.parseInt(values.get(PRIORITY).toString())));
        strategyMap.put(PROJECT, () -> quickAddTask.selectProject(values.get(PROJECT).toString()));

        for (TaskSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

}
