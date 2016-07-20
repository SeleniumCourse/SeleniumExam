package org.fundacionjala.webtesting.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.webtesting.pages.MainApp;
import org.fundacionjala.webtesting.pages.ProjectContainer;
import org.fundacionjala.webtesting.pages.QuickAddTask;
import org.fundacionjala.webtesting.pages.TaskSteps;
import org.fundacionjala.webtesting.pages.TopBar;

import static org.fundacionjala.webtesting.pages.LoginPage.loginAsPrimaryUser;
import static org.testng.Assert.assertEquals;

public class StepDefinitions {

    private MainApp mainApp;

    private ProjectContainer projectContainer;

    private Map<TaskSteps, Object> valuesMap;

    @Given("I login as Primary User")
    public void iLoginAsPrimaryUser() {
        mainApp = loginAsPrimaryUser();
    }

    @When("I create a Quick Task :")
    public void iCreateAQuickTask(Map<TaskSteps, Object> values) {
        this.valuesMap = values;
        TopBar topBar = mainApp.goToTopBar();
        QuickAddTask quickAddTask = topBar.clickAddTaskIcon();

        valuesMap.keySet().stream().forEach((step) -> {
            quickAddTask.getStrategyStepMap(valuesMap).get(step).executeStep();
        });

        projectContainer = quickAddTask.clickAddTaskBtn();
    }

    @Then("I verify all fields")
    public void iVerifyAllFields() {
        valuesMap.keySet().forEach((step) -> {
            assertEquals(projectContainer.getAssertionMap().get(step), valuesMap.get(step));
        });
    }

    @Then("I verify fields:")
    public void iVerifyFields(Map<TaskSteps, Object> expectedValues) {
        expectedValues.keySet().forEach((step) -> {
            assertEquals(projectContainer.getAssertionMap().get(step), expectedValues.get(step));
        });
    }

}
