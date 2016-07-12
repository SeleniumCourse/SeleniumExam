package org.fundacionjala.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.clickWebElement;
import static org.fundacionjala.webtesting.framework.selenium.CommonMethods.setWebElement;

public class AddTask<T extends AddTask<T>> extends AbstractBasePage {

    @FindBy(css = ".richtext_editor.sel_richtext_editor")
    private WebElement taskNameTxt;

    @FindBy(xpath = "//img[contains(@class,'cmp_priority') " +
            "and contains(@class, 'form_action_icon menu_icon')]")
    private WebElement priorityIcon;

    @FindBy(css = ".amibutton.amibutton_red.submit_btn")
    private WebElement addTaskBtn;

    @FindBy(css = ".AmiMenu.priority_menu")
    private WebElement priorityMenu;

    public T setTaskNameTxt(String newNameTask){
        setWebElement(taskNameTxt, newNameTask);
        return getThis();
    }

    public T selectPriority(int priority){
        clickWebElement(priorityIcon);
        priorityMenu.findElement(By.cssSelector("img.cmp_priority" + priority)).click();
//        //Another implementation using xpath
//        driver.findElement(By.xpath("//div[@class='AmiMenu priority_menu']/descendant::img[@class='cmp_priority" + priority + "']")).click();
        return getThis();
    }

    public ProjectContainer clickAddTaskBtn(){
        clickWebElement(addTaskBtn);
        return new ProjectContainer();
    }

    protected T getThis() {
        return (T) this;
    }

}
