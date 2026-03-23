package es.upo.cal.selenium_tests.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import es.upo.cal.selenium_tests.eps.EpsWebPage;

public class MainTest {

    protected EpsWebPage epswebpage;
    private WebDriver driver;

    @BeforeClass
    public void setUp () {
	driver = new ChromeDriver();
	epswebpage = new EpsWebPage(driver);
    }

    @AfterClass
    public void tearDown () {
	epswebpage = null;

	driver.quit();
	driver = null;
    }

}
