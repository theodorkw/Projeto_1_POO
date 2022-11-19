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

/**
 * The type Digito, a digit with seven segments.
 * Receive all seven segments.
 * @author Theodor Konrad Wojcikiewicz
 */
public class Digito {

    private Segmento a;
    private Segmento b;
    private Segmento c;
    private Segmento d;
    private Segmento e;
    private Segmento f;
    private Segmento g;

    /**
     * Instantiates a new Digito, a Digit with seven segments.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     * @param e the e
     * @param f the f
     * @param g the g
     */
    public Digito(Segmento a, Segmento b, Segmento c, Segmento d, Segmento e, Segmento f, Segmento g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public Segmento getA() {
        return a;
    }

    /**
     * Sets a.
     *
     * @param a the a
     */
    public void setA(Segmento a) {
        this.a = a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public Segmento getB() {
        return b;
    }

    /**
     * Sets b.
     *
     * @param b the b
     */
    public void setB(Segmento b) {
        this.b = b;
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public Segmento getC() {
        return c;
    }

    /**
     * Sets c.
     *
     * @param c the c
     */
    public void setC(Segmento c) {
        this.c = c;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public Segmento getD() {
        return d;
    }

    /**
     * Sets d.
     *
     * @param d the d
     */
    public void setD(Segmento d) {
        this.d = d;
    }

    /**
     * Gets e.
     *
     * @return the e
     */
    public Segmento getE() {
        return e;
    }

    /**
     * Sets e.
     *
     * @param e the e
     */
    public void setE(Segmento e) {
        this.e = e;
    }

    /**
     * Gets f.
     *
     * @return the f
     */
    public Segmento getF() {
        return f;
    }

    /**
     * Sets f.
     *
     * @param f the f
     */
    public void setF(Segmento f) {
        this.f = f;
    }

    /**
     * Gets g.
     *
     * @return the g
     */
    public Segmento getG() {
        return g;
    }

    /**
     * Sets g.
     *
     * @param g the g
     */
    public void setG(Segmento g) {
        this.g = g;
    }
}
