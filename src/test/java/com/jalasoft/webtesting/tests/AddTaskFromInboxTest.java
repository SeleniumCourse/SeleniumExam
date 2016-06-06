package com.jalasoft.webtesting.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jalasoft.webtesting.pages.AddTask;
import com.jalasoft.webtesting.pages.HomePage;
import com.jalasoft.webtesting.pages.LeftMenu;
import com.jalasoft.webtesting.pages.LoginPage;
import com.jalasoft.webtesting.pages.MainApp;
import com.jalasoft.webtesting.pages.ProjectContainer;

import static org.testng.Assert.assertTrue;

public class AddTaskFromInboxTest {

    private LeftMenu leftMenu;

    private ProjectContainer projectContainer;

    private static final String TASK_NAME = "my task";

    @BeforeClass
    public void setUp() {
        final String userName = "carledriss@gmail.com";
        final String password = "P@ssw0rd";

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLoginBtn();
        MainApp mainApp = loginPage.loginAs(userName, password);
        leftMenu = mainApp.goToLeftMenu();
        projectContainer = leftMenu.goToInbox();
    }

    @Test
    public void testAddTaskFromInbox() {
        final int priority = 1;

        AddTask addTask = projectContainer.clickAddTaskLnk();
        addTask.setTaskNameTxt(TASK_NAME);
        addTask.selectPriority(priority);
        projectContainer = addTask.clickAddTaskBtn();

        assertTrue(projectContainer.isTaskAdded(TASK_NAME), "Task should be added");
    }

    @AfterClass
    public void tearDown() {
        projectContainer.clickTaskMenu(TASK_NAME);
        projectContainer.clickDeleteTask();
    }

}
