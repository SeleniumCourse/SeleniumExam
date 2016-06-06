package com.jalasoft.webtesting.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.webtesting.framework.selenium.CommonMethods.clickWebElement;
import static com.jalasoft.webtesting.framework.selenium.CommonMethods.setWebElement;

public class LoginPage extends AbstractBasePage {

    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(css = ".amibutton.amibutton_red.sel_login")
    private WebElement loginBtn;

    @FindBy(className = "GB_frame")
    private WebElement frameClass;

    @FindBy(id = "GB_frame")
    private WebElement frameID;

    public void setEmailTxt(String email) {
        try {
            switchToFrames();
            setWebElement(emailTxt, email);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void setPasswordTxt(String password) {
        try {
            switchToFrames();
            setWebElement(passwordTxt, password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public MainApp clickLoginBtn() {
        try {
            switchToFrames();
            clickWebElement(loginBtn);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new MainApp();
    }

    public MainApp loginAs(String userName, String password) {
        setEmailTxt(userName);
        setPasswordTxt(password);
        return clickLoginBtn();
    }

    private void switchToFrames() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameClass));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
    }
}
