package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestSearchbar extends MainTest {

    private static final String SEARCH_URL_PART = "search";

    @Test
    public void verifySearchBar () {

	epswebpage.gotoEpsWebPage();

	epswebpage.search("ingeniería");

	String url = epswebpage.getUrl();

	assertTrue(url.contains(SEARCH_URL_PART) || url.contains("?s="),
		"La URL no corresponde a resultados de búsqueda: " + url);
    }
}
