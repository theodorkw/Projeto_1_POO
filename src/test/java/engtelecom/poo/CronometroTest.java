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
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

/**
 * The type Cronometro(Counter)test.
 */
public class CronometroTest {
	/**
	 * Test of null values of the attributes of the Cronometro.
	 */
	@Test
	public void Cronometro() {
		double xInicial = 0.0;
		double yInicial = 0.0;
		int dimensao = 0;
		Color corSegmentoLigado = null;
		Color corSegmentoDesligado = null;
		Cronometro expected = new Cronometro(0,0,0,null,null);
		Cronometro actual = new Cronometro(xInicial, yInicial, dimensao, corSegmentoLigado, corSegmentoDesligado);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of the Contador .
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void contador() throws InterruptedException {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		int[] expected = new int[3];
		int[] actual = c.contador();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of the Gets color when it's off.
	 */
	@Test
	public void getCorSegmentoDesligado() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		Color expected = Color.lightGray;
		Color actual = c.getCorSegmentoDesligado();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets color when it's on .
	 */
	@Test
	public void getCorSegmentoLigado() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		Color expected = Color.green;
		Color actual = c.getCorSegmentoLigado();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets size.
	 */
	@Test
	public void getDimensao() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		int expected = 0;
		int actual = c.getDimensao();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets hour.
	 */
	@Test
	public void getHora() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		int expected = 0;
		int actual = c.getHora();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets minute.
	 */
	@Test
	public void getMinuto() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		int expected = 0;
		int actual = c.getMinuto();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets second.
	 */
	@Test
	public void getSegundo() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		int expected = 0;
		int actual = c.getSegundo();

		assertEquals(expected, actual);
	}

	/**
	 * Test of null values of the Gets x initial.
	 */
	@Test
	public void getxInicial() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		double expected = 0.0;
		double actual = c.getxInicial();

		assertEquals(expected, actual, 0.0000001D);
	}

	/**
	 * Test of null values of the Gets y initial.
	 */
	@Test
	public void getyInicial() {
		Cronometro c = new Cronometro(0,0,0,Color.green, Color.lightGray);
		double expected = 0.0;
		double actual = c.getyInicial();

		assertEquals(expected, actual, 0.0000001D);
	}


}
