package org.fundacionjala.webtesting.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.fundacionjala.webtesting.pages.LoginPage;
import org.fundacionjala.webtesting.pages.MainApp;
import org.fundacionjala.webtesting.pages.ProjectContainer;
import org.fundacionjala.webtesting.pages.QuickAddTask;
import org.fundacionjala.webtesting.pages.TopBar;

import static org.testng.Assert.assertTrue;

public class QuickAddTaskTest {

    private static final String TASK_NAME = "my task";

    private MainApp mainApp;

    private ProjectContainer projectContainer;

    @BeforeClass
    public void setUp() {
        mainApp = LoginPage.loginAsPrimaryUser();
    }

    @Test
    public void testQuickAddTak() {
        final int priority = 1;
        final String projectName = "Errands";

        TopBar topBar = mainApp.goToTopBar();
        QuickAddTask quickAddTask = topBar.clickAddTaskIcon();
        projectContainer = quickAddTask.setTaskNameTxt(TASK_NAME)
                .selectPriority(priority)
                .selectProject(projectName)
                .clickAddTaskBtn();

        assertTrue(projectContainer.isTaskAdded(TASK_NAME), "Task should be added");
}

    @AfterMethod
    public void tearDown() {
        projectContainer.clickTaskMenu(TASK_NAME);
        projectContainer.clickDeleteTask();
    }

}
