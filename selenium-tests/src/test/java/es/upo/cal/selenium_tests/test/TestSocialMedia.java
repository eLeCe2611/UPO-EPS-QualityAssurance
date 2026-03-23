package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSocialMedia extends MainTest {

    private static final String[] EXPECTED_SOCIAL_LINKS_URL = { "https://www.facebook.com/red.eps.upo/",
	    "https://x.com/EPSUPO", "https://www.instagram.com/eps.upo/" };

    private void verifySocialLink (WebElement socialLink, String expectedSocialLinkUrl) {

	String socialLinkUrl = epswebpage.clickLinkAndGetNewWindowUrl(socialLink);

	String message = new StringBuilder().append("El enlace \"").append(socialLinkUrl)
		.append("\" no coincide con el esperado \"").append(expectedSocialLinkUrl).append("\".").toString();

	assertTrue(socialLinkUrl.contains(expectedSocialLinkUrl), message);
    }

    @Test
    public void verifySocialLinks () {
	epswebpage.gotoEpsWebPage();
	List<WebElement> socialLinks = epswebpage.getSocialLinks();

	assertTrue(socialLinks != null);
	assertTrue(EXPECTED_SOCIAL_LINKS_URL.length == socialLinks.size());

	for (int linkIdx = 0; linkIdx < socialLinks.size(); ++linkIdx) {
	    verifySocialLink(socialLinks.get(linkIdx), EXPECTED_SOCIAL_LINKS_URL[linkIdx]);

	}

    }

}
