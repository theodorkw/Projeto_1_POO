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
 * The type Segmento test.
 */
public class SegmentoTest {
	/**
	 * Test of null values of the attributes of Segmento.
	 */
	@Test
	public void Segmento() {
		double xInicial = 0.0;
		double yInicial = 0.0;
		int fator = 0;
		Color corSegmentoLigado = null;
		Color corSegmentoDesligado = null;
		Segmento expected = new Segmento(0,0,0,null,null);
		Segmento actual = new Segmento(xInicial, yInicial, fator, corSegmentoLigado, corSegmentoDesligado);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of instantiation of values of Gets cor segmento desligado.
	 */
	@Test
	public void getCorSegmentoDesligado() {
		Segmento s = new Segmento(0,0,200,Color.green,Color.lightGray);
		Color expected = Color.lightGray;
		Color actual = s.getCorSegmentoDesligado();

		assertEquals(expected, actual);
	}

	/**
	 * Test of instantiation of values of Gets cor segmento ligado.
	 */
	@Test
	public void getCorSegmentoLigado() {
		Segmento s = new Segmento(0,0,200,Color.green,Color.lightGray);
		Color expected = Color.green;
		Color actual = s.getCorSegmentoLigado();
		assertEquals(expected, actual);
	}

	/**
	 * Test of instantiation of values of Gets fator.
	 */
	@Test
	public void getFator() {
		Segmento s = new Segmento(0,0,200,Color.green,Color.lightGray);

		int expected = 200;
		int actual = s.getFator();

		assertEquals(expected, actual);
	}

	/**
	 * Test of instantiation of values of Gets xinicial.
	 */
	@Test
	public void getxInicial() {
		Segmento s = new Segmento(0,0,200,Color.green,Color.lightGray);

		double expected = 0.0;
		double actual = s.getxInicial();

		assertEquals(expected, actual, 0.0000001D);
	}

	/**
	 * Test of instantiation of values of Gets yinicial.
	 */
	@Test
	public void getyInicial() {
		Segmento s = new Segmento(0,0,200,Color.green,Color.lightGray);

		double expected = 0.0;
		double actual = s.getyInicial();

		assertEquals(expected, actual, 0.0000001D);
	}


}
