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
 * The type Cronometro, a counter for hour, minutes and seconds.
 * Receive x and y initial coordinates, size of the canvas.
 * Receive the color of the segments when it's on or off.
 * @author Theodor Konrad Wojcikiewicz
 */
public class Cronometro {


    private int hora;
    private int minuto;
    private int segundo;



    private double xInicial;
    private double yInicial;
    private int dimensao;
    private Color corSegmentoLigado;
    private Color corSegmentoDesligado;

    /*
    private static final int DIMENSAO_MAX=100;
    private static final int DIMENSAO_MIN=20;
    private static final int DIMENSAO_PADRAO=40;
    */

    /**
     * Instantiates a new Cronometro, a counter for hour, minute and seconds.
     *
     * @param xInicial             the x initial
     * @param yInicial             the y initial
     * @param dimensao             the size
     * @param corSegmentoLigado    the color of the segment when it's on
     * @param corSegmentoDesligado the color of the segment when it's off
     */
    public Cronometro(double xInicial, double yInicial, int dimensao,Color corSegmentoLigado, Color corSegmentoDesligado) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.dimensao = dimensao;
        this.corSegmentoLigado = corSegmentoLigado;
        this.corSegmentoDesligado = corSegmentoDesligado;

    }

    /**
     * The method responsible for count hour, minute and second.
     *
     * @return the int [ ] with hour, minute and second
     * @throws InterruptedException the interrupted exception for every 1000 milliseconds that passed
     */
    public int[] contador() throws InterruptedException {

        int[] horario = new int[3];

        horario[0] = hora;
        horario[1] = minuto;
        horario[2] = segundo;


        while(hora<=100) {


            if (hora == 99) {
                hora = 0;
                setHora(hora);



            }
            if (minuto == 60) {
                hora++;
                minuto = 0;

                setHora(hora);
                setMinuto(minuto);
                System.out.println("Hora no Cronometro: "+hora);
                return horario;


            }
            if (segundo == 60) {
                minuto++;
                segundo = 0;

                setMinuto(minuto);
                setSegundo(segundo);
                System.out.println("Minutos no Cronometro: "+minuto);
                return horario;


            } else {

                Thread.sleep(1000);
                segundo++;
                setSegundo(segundo);
                System.out.println("Segundos no Cronometro: "+segundo);
                return horario;

            }
        }

        return horario;
    }





    /*
    public int contadorSegundos() throws InterruptedException {

        while (hora < 99) {

            Thread.sleep(1000);
            segundo++;
            setSegundo(segundo);

            if (minuto == 60) {
                hora++;
                setMinuto(0);
                setHora(hora);

            }
            if (segundo == 60) {
                minuto++;
                setSegundo(0);
                setMinuto(minuto);

            }

        }
        return segundo;
    }

    public int contadorHora() throws InterruptedException {

        while (hora < 99) {

            Thread.sleep(1000);
            segundo++;
            setSegundo(segundo);

            if (minuto == 60) {
                hora++;
                setMinuto(0);
                setHora(hora);


            }
            if (segundo == 60) {
                minuto++;
                setSegundo(0);
                setMinuto(minuto);

            }

        }
        return hora;
    }

     */


    /**
     * Gets x initial position in the canvas.
     *
     * @return the x initial
     */
    public double getxInicial() {
        return xInicial;
    }

    /**
     * Sets initial position in the canvas.
     *
     * @param xInicial the x initial
     */
    public void setxInicial(double xInicial) {
        this.xInicial = xInicial;
    }

    /**
     * Gets y initial position in the canvas.
     *
     * @return the y initial
     */
    public double getyInicial() {
        return yInicial;
    }

    /**
     * Sets y initial position in the canvas.
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
     * Sets color of the segment when it's on.
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

    /**
     * Gets the size of the canvas.
     *
     * @return the size of the canvas.
     */
    public int getDimensao() {
        return dimensao;
    }

    /**
     * Sets the size of the canvas.
     *
     * @param dimensao the size of the canvas.
     */
    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    /**
     * Gets hour.
     *
     * @return the hour.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Sets hour.
     *
     * @param hora the hour.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Gets minute.
     *
     * @return the minute.
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Sets minute.
     *
     * @param minuto the minute.
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Gets second.
     *
     * @return the second.
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * Sets second.
     *
     * @param segundo the second.
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
}




