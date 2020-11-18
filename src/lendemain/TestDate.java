package lendemain;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import jdk.jfr.Description;

class TestDate {
	@Test
    @Description("Testing `Lendemain` exception")

	void testValiditeDate() {
		 Throwable exception ;
	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(-1,1,2020)));
	        assertEquals("jour < 1", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(32,1,2020)));
	        assertEquals("jour > 31", exception.getMessage());

	        exception = assertThrows(Exception.class, () ->Date.Lendemain(new Date(1,0,2020)));
	        assertEquals("mois < 1", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(4,14,2025)));
	        assertEquals("mois > 12", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(1,1,400)));
	        assertEquals("annee < 1000", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(1,4,4000)));
	        assertEquals("annee > 3000", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(29,2,2017)));
	        assertEquals("Fevrier n'a que 28 jours", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(30,2,2020)));
	        assertEquals("Annee Bissextile Fevrier n'a que 29 jours", exception.getMessage());

	        exception = assertThrows(Exception.class, () -> Date.Lendemain(new Date(31,11,2020)));
	        assertEquals("ce mois ne contient que 30 jours ", exception.getMessage());
	}
	@Test
	void testbissextile1() {
		boolean expected = false;
		boolean result = Date.bissextile(2100);
		assertEquals(expected, result);
	}

	@Test
	void testbissextile2() {
		boolean expected = true;
		boolean result = Date.bissextile(2016);
		;
		assertEquals(expected, result);
	}

	@Test
	void testbissextile3() {
		boolean expected = false;
		boolean result = Date.bissextile(2018);
		;
		assertEquals(expected, result);
	}

	@Test
	void testLendemain() throws Exception{
		Date jourCourant = new Date(1, 1, 2018);
		Date expected = new Date(2, 1, 2018);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain1() throws Exception{
		Date jourCourant = new Date(31, 1, 2018);
		Date expected = new Date(1, 2, 2018);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain2() throws Exception{
		Date jourCourant = new Date(30, 4, 2018);
		Date expected = new Date(1, 5, 2018);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain3() throws Exception{
		Date jourCourant = new Date(28, 2, 2018);
		Date expected = new Date(1, 3, 2018);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain4() throws Exception{
		Date jourCourant = new Date(29, 2, 2020);
		Date expected = new Date(1, 3, 2020);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain5() throws Exception{
		Date jourCourant = new Date(31, 12, 2019);
		Date expected = new Date(1, 1, 2020);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testLendemain6() throws Exception{
		Date jourCourant = new Date(29, 2, 2020);
		Date expected = new Date(1, 3, 2020);
		Date result = Date.Lendemain(jourCourant);
		assertEquals(expected.getJour(), result.getJour());
		assertEquals(expected.getMois(), result.getMois());
		assertEquals(expected.getAnnee(), result.getAnnee());
	}

	@Test
	void testbissextile() {
		boolean expected = true;
		boolean result = Date.bissextile(2000);
		assertEquals(expected, result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestDate.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("[OK] " + result.wasSuccessful());
	}
}
