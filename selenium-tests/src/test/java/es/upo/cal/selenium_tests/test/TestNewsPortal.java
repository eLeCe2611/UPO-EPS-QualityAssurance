package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestNewsPortal extends MainTest {
    private static final String NEWS_PORTAL = "https://www.upo.es/escuela-politecnica-superior/es/de-interes/Noticias/";

    @Test
    public void verifyGiisi () {
	epswebpage.gotoEpsWebPage();

	WebElement newsportallink = epswebpage.getNewsPortalLink();

	assertTrue(newsportallink != null);

	epswebpage.clickLink(newsportallink);

	String newsportalUrl = epswebpage.getUrl();

	assertTrue(newsportalUrl.contains(NEWS_PORTAL));

    }

}
