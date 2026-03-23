package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestAcademicOffers extends MainTest {

    private static final String GIISI_LINK_URL = "https://www.upo.es/escuela-politecnica-superior/es/oferta-academica/grados/grado-en-ingenieria-informatica-mencion-en-sistemas-de-informacion/portada/";

    @Test
    public void verifyGiisi () {
	epswebpage.gotoEpsWebPage();

	epswebpage.clickAcademicDropdrown();

	WebElement giisiLink = epswebpage.getGiisiLink();

	assertTrue(giisiLink != null);

	epswebpage.clickLink(giisiLink);
	String giisiLinkUrl = epswebpage.getUrl();

	assertTrue(giisiLinkUrl.contains(GIISI_LINK_URL));
    }

}
