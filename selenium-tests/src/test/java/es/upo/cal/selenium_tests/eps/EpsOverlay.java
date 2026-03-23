package es.upo.cal.selenium_tests.eps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpsOverlay {

    private final WebDriver driver;

    EpsOverlay(WebDriver driver) {
	this.driver = driver;
    }

    public WebElement backToTopButton () {
	return driver.findElement(By.xpath("//*[@title='Top']"));
    }

}