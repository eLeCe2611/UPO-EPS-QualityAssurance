package es.upo.cal.selenium_tests.eps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpsBody {

    private WebDriver driver;

    public EpsBody(WebDriver driver) {
	this.driver = driver;
    }

    public WebElement findAgendaContainer () {
	String agendaContainerXpath = "//div[contains(@class,'main-content')]//div[contains(@class,'agenda')]";
	WebElement agendaContainer = driver.findElement(By.xpath(agendaContainerXpath));
	return agendaContainer;
    }

    public List<WebElement> getDays () {
	String daysXPath = "//ul[contains(@class,'eventsCalendar-daysList')]/li/a";

	List<WebElement> days = driver.findElements(By.xpath(daysXPath));

	return days;
    }

    public String getDayName (WebElement day) {
	String dayNameXPath = "./span[1]";
	WebElement dayName = day.findElement(By.xpath(dayNameXPath));
	return dayName.getText();
    }

    public String getAgendaEventsTitle () {
	String headerXPath = "//*[@id='calendaragenda-eventsCalendar-subtitle']";
	WebElement headerAgendaContainer = driver.findElement(By.xpath(headerXPath));
	return headerAgendaContainer.getText();
    }

    public boolean hasEvents () {
	String noEventsMsgXPath = "//*[@class='eventsCalendar-noEvents']/p";
	String eventsListXPath = "//*[contains(@class,'eventsCalendar-completeList')]/a";

	boolean noEventsMsgVisible = !driver.findElements(By.xpath(noEventsMsgXPath)).isEmpty();
	boolean eventsVisible = !driver.findElements(By.xpath(eventsListXPath)).isEmpty();

	return noEventsMsgVisible || eventsVisible;
    }

}
