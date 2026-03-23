package es.upo.cal.selenium_tests.test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestAgenda extends MainTest {

    @Test
    public void verifyAgendaShowsEventsForEveryDay () {

	epswebpage.gotoEpsWebPage();
	epswebpage.consentCookies();

	epswebpage.scrollToAgenda();

	List<WebElement> days = epswebpage.getAgendaDays();
	assertTrue(days != null);
	assertTrue(days.size() > 0, "No se han encontrado días en la agenda.");

	for (int i = 0; i < days.size(); ++i) {

	    days = epswebpage.getAgendaDays();
	    WebElement day = days.get(i);

	    if (!day.isEnabled()) {

		continue;
	    }

	    String dayText = epswebpage.getDayName(day).trim();

	    epswebpage.clickAgendaDay(day);

	    String headerText = epswebpage.getAgendaEventsHeaderText().trim().split("\\s+")[2];
	    System.out.println(headerText);
	    System.out.println(dayText);
	    assertTrue(dayText.toUpperCase().contains(headerText.toUpperCase()),
		    "La cabecera de eventos no se ha actualizado correctamente para el día " + dayText);

	    assertTrue(epswebpage.agendaHasEventsOrNoEventsMessage(),
		    "El panel de eventos no muestra ni eventos ni el mensaje de 'No hay eventos para este periodo' para el día "
			    + dayText);
	}
    }

}
