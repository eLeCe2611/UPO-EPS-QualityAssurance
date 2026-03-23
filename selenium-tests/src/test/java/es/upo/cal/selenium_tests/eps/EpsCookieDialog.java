package es.upo.cal.selenium_tests.eps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpsCookieDialog {

    private final WebDriver driver;

    EpsCookieDialog(WebDriver driver) {
	this.driver = driver;
    }

    public WebElement consentGiveButton () {
	return driver.findElement(By.cssSelector("#cconsent-bar .consent-give"));
    }

}
