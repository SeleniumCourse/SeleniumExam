package com.jalasoft.webtesting.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jalasoft.webtesting.pages.HomePage;
import com.jalasoft.webtesting.pages.LoginPage;
import com.jalasoft.webtesting.pages.MainApp;
import com.jalasoft.webtesting.pages.ProjectContainer;
import com.jalasoft.webtesting.pages.QuickAddTask;
import com.jalasoft.webtesting.pages.TopBar;

import static org.testng.Assert.assertTrue;

public class QuickAddTaskTest {

    private MainApp mainApp;

    private ProjectContainer projectContainer;

    private static final String TASK_NAME = "my task";

    @BeforeClass
    public void setUp() {
        final String userName = "carledriss@gmail.com";
        final String password = "P@ssw0rd";

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLoginBtn();
        mainApp = loginPage.loginAs(userName, password);
    }

    @Test
    public void testQuickAddTak() {
        final int priority = 1;
        final String projectName = "Errands";

        TopBar topBar = mainApp.goToTopBar();
        QuickAddTask quickAddTask = topBar.clickAddTaskIcon();
        quickAddTask.setTaskNameTxt(TASK_NAME);
        quickAddTask.selectProject(projectName);
        quickAddTask.selectPriority(priority);
        projectContainer = quickAddTask.clickAddTaskBtn();

        assertTrue(projectContainer.isTaskAdded(TASK_NAME), "Task should be added");
}

    @AfterMethod
    public void tearDown() {
        projectContainer.clickTaskMenu(TASK_NAME);
        projectContainer.clickDeleteTask();
    }

}
