package es.upo.cal.selenium_tests.eps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpsHeader {

    private WebDriver driver;

    public EpsHeader(WebDriver driver) {
	this.driver = driver;
    }

    public List<WebElement> getSocialLinks () {
	String socialLinksXPath = "//ul[@id='social-header']/li/a";

	List<WebElement> socialLinks = driver.findElements(By.xpath(socialLinksXPath));
	socialLinks.remove(0); // drop unwanted link

	return socialLinks;
    }

    public WebElement getGiisiLink () {
	String giisiLinkXPath = "//*[@id='navmain']/ul/li[2]/ul/li/div/div[1]/div[1]/ul/li[1]/a";
	return driver.findElement(By.xpath(giisiLinkXPath));
    }

    public WebElement clickAcademicDropdown () {
	String academicDropdownXPath = "//*[@id='navmain']/ul/li[2]/a";
	return driver.findElement(By.xpath(academicDropdownXPath));
    }

    public WebElement getSearchInput () {
	String SearchInputXPath = "//*[@id='headerquery']";
	return driver.findElement(By.xpath(SearchInputXPath));
    }

    public WebElement getSearchButton () {
	String SearchButton = "//*[@id='searchForm']/div/span";
	return driver.findElement(By.xpath(SearchButton));
    }

    public WebElement getNewsPortalLink () {
	String newsPortalXPath = "//*[@id=\"navmain\"]/ul/li[8]/a";
	return driver.findElement(By.xpath(newsPortalXPath));
    }

}
