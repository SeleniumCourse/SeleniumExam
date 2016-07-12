package org.fundacionjala.webtesting.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.fundacionjala.webtesting.pages.AddTask;
import org.fundacionjala.webtesting.pages.LeftMenu;
import org.fundacionjala.webtesting.pages.LoginPage;
import org.fundacionjala.webtesting.pages.MainApp;
import org.fundacionjala.webtesting.pages.ProjectContainer;

import static org.testng.Assert.assertTrue;

public class AddTaskFromInboxTest {

    private static final String TASK_NAME = "my task";

    private LeftMenu leftMenu;

    private ProjectContainer projectContainer;

    @BeforeClass
    public void setUp() {
        MainApp mainApp = LoginPage.loginAsPrimaryUser();
        leftMenu = mainApp.goToLeftMenu();
        projectContainer = leftMenu.goToInbox();
    }

    @Test
    public void testAddTaskFromInbox() {
        final int priority = 1;

        AddTask addTask = projectContainer.clickAddTaskLnk();
        projectContainer = addTask.setTaskNameTxt(TASK_NAME)
                .selectPriority(priority)
                .clickAddTaskBtn();

        assertTrue(projectContainer.isTaskAdded(TASK_NAME), "Task should be added");
    }

    @AfterClass
    public void tearDown() {
        projectContainer.clickTaskMenu(TASK_NAME);
        projectContainer.clickDeleteTask();
    }

}
