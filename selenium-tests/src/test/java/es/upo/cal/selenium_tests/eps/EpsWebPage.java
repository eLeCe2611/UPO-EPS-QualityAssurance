package es.upo.cal.selenium_tests.eps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EpsWebPage {

    private final EpsHeader header;
    private final EpsBody body;
    private final EpsOverlay overlay;
    private final EpsCookieDialog cookiesDialog;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public EpsWebPage(WebDriver driver) {
	driver.manage().window().maximize();

	this.driver = driver;
	this.header = new EpsHeader(driver);
	this.body = new EpsBody(driver);
	this.overlay = new EpsOverlay(driver);
	this.cookiesDialog = new EpsCookieDialog(driver);
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickLink (WebElement link) {
	wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public List<WebElement> getSocialLinks () {
	return header.getSocialLinks();
    }

    public String getUrl () {
	return driver.getCurrentUrl();
    }

    public void gotoEpsWebPage () {
	driver.get("https://www.upo.es/escuela-politecnica-superior/es/");
    }

    public WebElement getGiisiLink () {
	return header.getGiisiLink();
    }

    public String clickLinkAndGetNewWindowUrl (WebElement link) {
	String originalWindow = driver.getWindowHandle();
	java.util.Set<String> oldWindows = driver.getWindowHandles();

	wait.until(ExpectedConditions.elementToBeClickable(link)).click();

	wait.until(d -> d.getWindowHandles().size() > oldWindows.size());

	String newWindow = null;
	for (String handle : driver.getWindowHandles()) {
	    if (!oldWindows.contains(handle)) {
		newWindow = handle;
		break;
	    }
	}

	if (newWindow == null) {
	    throw new RuntimeException("No se ha abierto ninguna nueva ventana al hacer clic en el enlace.");
	}

	driver.switchTo().window(newWindow);

	String url = driver.getCurrentUrl();

	driver.close();
	driver.switchTo().window(originalWindow);

	return url;
    }

    public void clickAcademicDropdrown () {
	clickLink(header.clickAcademicDropdown());
    }

    public WebElement getSearchInput () {
	return header.getSearchInput();
    }

    public WebElement getSearchButton () {
	return header.getSearchButton();
    }

    public void search (String text) {
	WebElement input = wait.until(ExpectedConditions.visibilityOf(getSearchInput()));
	input.clear();
	input.sendKeys(text);

	wait.until(ExpectedConditions.elementToBeClickable(getSearchButton())).click();
    }

    public WebElement getNewsPortalLink () {
	return header.getNewsPortalLink();
    }

    public void consentCookies () {

	WebElement consentBtn = wait.until(ExpectedConditions.elementToBeClickable(cookiesDialog.consentGiveButton()));

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", consentBtn);

	((JavascriptExecutor) driver).executeScript("arguments[0].click();", consentBtn);

    }

    public long getCurrentScrollY () {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Object result = js.executeScript("return window.pageYOffset;");
	return ((Number) result).longValue();
    }

    public void scrollToTop () {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom () {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void backToTop () {
	WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(overlay.backToTopButton()));
	btn.click();

	wait.until(driver -> {
	    Long y = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
	    return y < 20;
	});
    }

    public void scrollToAgenda () {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement agendaTitle = body.findAgendaContainer();

	js.executeScript("arguments[0].scrollIntoView(true);", agendaTitle);
    }

    public List<WebElement> getAgendaDays () {
	return body.getDays();
    }

    public void clickAgendaDay (WebElement day) {
	wait.until(ExpectedConditions.elementToBeClickable(day)).click();
    }

    public String getDayName (WebElement day) {
	return body.getDayName(day);
    }

    public String getAgendaEventsHeaderText () {
	return body.getAgendaEventsTitle();
    }

    public boolean agendaHasEventsOrNoEventsMessage () {
	return body.hasEvents();

    }

}
