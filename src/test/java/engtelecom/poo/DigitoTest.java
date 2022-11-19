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

/**
 * The type Digito test.
 */
public class DigitoTest {

	/**
	 * Test of null values of the attributes for Digito.
	 */
	@Test
	public void Digito() {
		Segmento a = null;
		Segmento b = null;
		Segmento c = null;
		Segmento d = null;
		Segmento e = null;
		Segmento f = null;
		Segmento g = null;
		Digito expected = new Digito(null,null,null,null,null,null,null);
		Digito actual = new Digito(a, b, c, d, e, f, g);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets a.
	 */
	@Test
	public void getA() {
		Digito d = new Digito(null,null,null,null,null,null,null); ;
		Segmento expected = null;
		Segmento actual = d.getA();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets b.
	 */
	@Test
	public void getB() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getB();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets c.
	 */
	@Test
	public void getC() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getC();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets d.
	 */
	@Test
	public void getD() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getD();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets e.
	 */
	@Test
	public void getE() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getE();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets f.
	 */
	@Test
	public void getF() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getF();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	/**
	 * Test of null values of Gets g.
	 */
	@Test
	public void getG() {
		Digito d = new Digito(null,null,null,null,null,null,null);
		Segmento expected = null;
		Segmento actual = d.getG();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}


}
