package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_WAIT_FOR =
            "//div[contains(@class, \"_10 _9o-w uiLayer _4-hy _3thl _3qw\")]/div[2]/div/div/div/div/div[3]";
    public static final String XPATH_CLICK_COOKIES =
            "//div[contains(@class, \"_10 _9o-w uiLayer _4-hy _3thl _3qw\")]/div[2]/div/div/div/div/div[3]/button[2]";
    public static final String XPATH_CREATE_NEW_ACCOUNT =
            "//div[contains(@class, \"_li\")]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get( "https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());
        WebElement facebookButton = driver.findElement(By.xpath(XPATH_CLICK_COOKIES));
        facebookButton.click();

        while (!driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT)).isDisplayed());
        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        createAccountButton.click();

        Thread.sleep(3000L);

        WebElement daySelect = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(daySelect);
        selectDay.selectByValue("20");

        WebElement monthSelect = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(monthSelect);
        selectMonth.selectByValue("9");

        WebElement yearSelect = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue("1976");
    }
}