package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TestBackToTop extends MainTest {

    @Test
    public void verifyBackToTop () {

	epswebpage.gotoEpsWebPage();
	epswebpage.consentCookies();

	epswebpage.scrollToTop();
	assertTrue(epswebpage.getCurrentScrollY() == 0);

	epswebpage.scrollToBottom();
	assertTrue(epswebpage.getCurrentScrollY() > 0);

	epswebpage.backToTop();
	assertTrue(epswebpage.getCurrentScrollY() < 20);

    }
}
