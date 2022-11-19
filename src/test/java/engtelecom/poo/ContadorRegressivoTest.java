/*
 * Copyright (c) 2022.
 * Theodor Konrad Wojcikiewicz
 *
 * Date of the start of the Project: 04/11/2022;
 * Date of the end of the Project: 20/11/2022;
 *
 * Time allocated daily for the project: more than ten hours.
 *  Daily schedule: Starting 15 hours, finishing 20,23 hours. Sometimes even going past 4 am.
 *
 *  Sadly, with that time i was unable to finish some things in the project.
 *
 *  TODO (some day)
 *
 *  --> The system don't allow the change of the x and y initial positions  (break the digit logic).
 *  --> The system don't allow the color change of the segments. (break the digit logic, don't receive the values of the counter and the timer)
 *        The digits are fixed at green when segments are on and light gray when segments are off.
 *  ---> The system don't allow the change in the size of the digits. (break the digits, only work at 200)
 *
 *  Don't change any value in the main, just run the program.
 *
 *
 */

package engtelecom.poo;

import org.apache.commons.lang3.builder.EqualsBuilder;

import org.testng.annotations.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Contador regressivo (Timer) test.
 */
public class ContadorRegressivoTest {

	/**
	 * Test of null values of the attributes of the Contador regressivo (Timer).
	 */
	@Test
	public void ContadorRegressivo() {
		int hora = 0;
		int minuto = 0;
		int segundo = 0;
		int fator = 0;
		double xInicial = 0.0;
		double yInicial = 0.0;
		Color corSegmentoLigado = null;
		Color corSegmentoDesligado = null;
		ContadorRegressivo expected = new ContadorRegressivo(0,0,0,0,0.0,0.0,null,null);
		ContadorRegressivo actual = new ContadorRegressivo(hora, minuto, segundo, fator, xInicial, yInicial, corSegmentoLigado, corSegmentoDesligado);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of the Contador.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void contador() throws InterruptedException {
		ContadorRegressivo c = new ContadorRegressivo(0,0,0,0,0,0,null,null);
		int[] expected = new int[3];
		int[] actual = c.contador();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of the Gets color when it's off.
	 */
	@Test
	public void getCorSegmentoDesligado() {
		ContadorRegressivo c = null;
		Color expected = null;
		Color actual = c.getCorSegmentoDesligado();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets color of when it's on.
	 */
	@Test
	public void getCorSegmentoLigado() {
		ContadorRegressivo c = null;
		Color expected = null;
		Color actual = c.getCorSegmentoLigado();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the  Gets size.
	 */
	@Test
	public void getFator() {
		ContadorRegressivo c = null;
		int expected = 0;
		int actual = c.getFator();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets hour.
	 */
	@Test
	public void getHora() {
		ContadorRegressivo c = null;
		int expected = 0; // TODO This is a fallback value due to incomplete analysis.
		int actual = c.getHora();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets minutes.
	 */
	@Test
	public void getMinuto() {
		ContadorRegressivo c = null;
		int expected = 0;
		int actual = c.getMinuto();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets seconds.
	 */
	@Test
	public void getSegundo() {
		ContadorRegressivo c = null;
		int expected = 0;
		int actual = c.getSegundo();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets x initial.
	 */
	@Test
	public void getxInicial() {
		ContadorRegressivo c = null;
		double expected = 0.0;
		double actual = c.getxInicial();

		assertEquals(expected, actual, 0.0000001D);
	}

	/**
	 * Test of null values of the Gets y initial.
	 */
	@Test
	public void getyInicial() {
		ContadorRegressivo c = null;
		double expected = 0.0D;
		double actual = c.getyInicial();

		assertEquals(expected, actual, 0.0000001D);
	}

}
