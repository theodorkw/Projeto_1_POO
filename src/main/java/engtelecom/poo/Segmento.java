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

import java.awt.*;


/**
 * The type Segmento, a segment of the digit.
 * Receive the initial x and y coordinates.
 * Receive the size of the draw.
 * Receive the color of the segments when it's on or off.
 * @author Theodor Konrad Wojcikiewicz
 */
public class Segmento {

    private double xInicial;
    private double yInicial;

    private int fator;
    private Color corSegmentoLigado;
    private Color corSegmentoDesligado;


    /**
     * Instantiates a new Segmento, a segment of the digit.
     *
     * @param xInicial             the x initial
     * @param yInicial             the y initial
     * @param fator                the size
     * @param corSegmentoLigado    the color of the segment when it's on
     * @param corSegmentoDesligado the color of the segment when it's off
     */
    public Segmento(double xInicial, double yInicial, int fator, Color corSegmentoLigado, Color corSegmentoDesligado) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.fator = fator;
        this.corSegmentoLigado = corSegmentoLigado;
        this.corSegmentoDesligado = corSegmentoDesligado;

    }


    /**
     * Gets the size of the segment.
     *
     * @return the size
     */
    public int getFator() {
        return fator;
    }

    /**
     * Sets the size of the segment.
     *
     * @param fator the size
     */
    public void setFator(int fator) {
        this.fator = fator;
    }

    /**
     * Gets x initial.
     *
     * @return the x initial
     */
    public double getxInicial() {
        return xInicial;
    }

    /**
     * Sets x initial.
     *
     * @param xInicial the x initial
     */
    public void setxInicial(double xInicial) {
        this.xInicial = xInicial;
    }

    /**
     * Gets y initial.
     *
     * @return the y initial
     */
    public double getyInicial() {
        return yInicial;
    }

    /**
     * Sets y initial.
     *
     * @param yInicial the y initial
     */
    public void setyInicial(double yInicial) {
        this.yInicial = yInicial;
    }

    /**
     * Gets the color of the segment when it's on.
     *
     * @return the color of the segment when it's on.
     */
    public Color getCorSegmentoLigado() {


        return corSegmentoLigado;
    }

    /**
     * Sets the color of the segment when it's on.
     *
     * @param corSegmentoLigado the color of the segment when it's on.
     */
    public void setCorSegmentoLigado(Color corSegmentoLigado) {
        this.corSegmentoLigado = corSegmentoLigado;
    }

    /**
     * Gets the color of the segment when it's off.
     *
     * @return the color of the segment when it's off.
     */
    public Color getCorSegmentoDesligado() {
        return corSegmentoDesligado;
    }

    /**
     * Sets the color of the segment when it's off.
     *
     * @param corSegmentoDesligado the color of the segment when it's off.
     */
    public void setCorSegmentoDesligado(Color corSegmentoDesligado) {
        this.corSegmentoDesligado = corSegmentoDesligado;
    }




}
