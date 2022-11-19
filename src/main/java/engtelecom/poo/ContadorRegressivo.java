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
 * The type Contador regressivo.
 * It's a timer to count hour, minutes and seconds.
 * Receive the initial hour, minute and second as initial number.
 * Receive the seize of the timer, x and y initial coordinates in the canvas.
 * Receive the segment color of the segment when it's on and off.
 * @author Theodor Konrad Wojcikiewicz
 */
public class ContadorRegressivo {

    private int hora;
    private int minuto;
    private int segundo;

    private int fator;
    private double xInicial;
    private double yInicial;
    private Color corSegmentoLigado;
    private Color corSegmentoDesligado;




    private static final int DIMENSAO_MAX=100;
    private static final int DIMENSAO_MIN=20;
    private static final int DIMENSAO_PADRAO=40;

    /**
     * Instantiates a new Contador regressivo, a timer to count hours, minutes and seconds
     *
     * @param hora                 the hour
     * @param minuto               the minute
     * @param segundo              the second
     * @param fator                the factor(size of the draw)
     * @param xInicial             the initial x position on screen
     * @param yInicial             the initial y position on screen
     * @param corSegmentoLigado    the color of the segment on
     * @param corSegmentoDesligado the color of the segment off
     */
    public ContadorRegressivo(int hora, int minuto, int segundo, int fator, double xInicial, double yInicial, Color corSegmentoLigado, Color corSegmentoDesligado) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.fator = fator;
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.corSegmentoLigado = corSegmentoLigado;
        this.corSegmentoDesligado = corSegmentoDesligado;
    }


    /**
     * The method for count the timer in hour, minutes and seconds
     *
     * @return the int [ ] with hour, minute and second
     * @throws InterruptedException the interrupted exception for every 1000 miliseconds that passed
     */
    public int[] contador() throws InterruptedException {


        int[] horario = new int[3];
        horario[0]= hora;
        horario[1]= minuto;
        horario[2]= segundo;


        while (hora <= 100) {
               /*
            if(hora==0&&minuto==0&&segundo==0){
                hora=99;
                minuto=60;
                segundo=60;
                setHora(hora);
                setMinuto(minuto);
                setSegundo(segundo);


            }

                */

            if (hora == 0) {
                hora = 99;
                setHora(hora);



            }
             if (minuto == 0) {
                hora--;
                minuto = 60;
                setHora(hora);
                setMinuto(minuto);
                 System.out.println("Hora no Regressivo: "+hora);
                return horario;


            }
            if (segundo == 0) {
                minuto--;
                segundo = 59;
                setMinuto(minuto);
                setSegundo(segundo);
                System.out.println("Minutos no Regressivo: "+minuto);
                return horario;


            } else {

                Thread.sleep(1000);
                segundo--;
                setSegundo(segundo);
                System.out.println("Segundos no Regressivo: "+segundo);
                return horario;

            }

        }

        return horario;
    }


    /*
    public int contadorRegressivoSegundos() throws InterruptedException {


        while (hora <= 99) {

            if (hora == 0) {
                hora = 99;
                setHora(hora);
                System.out.println("Hora: "+getHora());

            }
            if (minuto == 0) {
                hora--;
                minuto = 60;
                setHora(hora);
                setMinuto(minuto);
                System.out.println("Hora: "+getHora());



            }
            if (segundo == 0) {
                minuto--;
                segundo = 60;
                setMinuto(minuto);
                setSegundo(segundo);
                System.out.println("Minutos: "+getMinuto());
                System.out.println("Segundo: "+getSegundo());


            }
            else {

                Thread.sleep(1000);
                segundo--;
                setSegundo(segundo);
                System.out.println("Seg "+getSegundo());
                return segundo;

            }

        }
       //this.segundo = segundo;
        return segundo;
    }


    public int contadorRegressivoHora() throws InterruptedException {

        while (hora <= 99) {

            if (hora == 0) {
                hora = 99;
                setHora(hora);


            }
            if (minuto == 0) {
                hora--;
                minuto = 60;
                setHora(hora);
                setMinuto(minuto);
                return hora;

            }
            if (segundo == 0) {
                minuto--;
                segundo = 60;
                setMinuto(minuto);
                setSegundo(segundo);


            }
            else {

                Thread.sleep(1000);
                segundo--;
                setSegundo(segundo);

            }

        }
        return hora;
    }
    */

    /**
     * Gets hour.
     *
     * @return the hour
     */
    public int getHora() {
        return hora;
    }

    /**
     * Sets hour.
     *
     * @param hora the hour
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Gets minute.
     *
     * @return the minute
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Sets minute.
     *
     * @param minuto the minute
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Gets second.
     *
     * @return the second
     */
    public int getSegundo() {

        return segundo;
    }

    /**
     * Sets second.
     *
     * @param segundo the second
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * Gets x initial.
     *
     * @return the xinitial
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
     * Gets the color of the segment when the power is on.
     *
     * @return the color of the segment when the power is on.
     */
    public Color getCorSegmentoLigado() {
        return corSegmentoLigado;
    }

    /**
     * Sets the color of the segment when the power is on.
     *
     * @param corSegmentoLigado the color of the segment when the power is on.
     */
    public void setCorSegmentoLigado(Color corSegmentoLigado) {
        this.corSegmentoLigado = corSegmentoLigado;
    }

    /**
     * Gets the color of the segment when the power is off.
     *
     * @return the color of the segment when the power is off.
     */
    public Color getCorSegmentoDesligado() {
        return corSegmentoDesligado;
    }

    /**
     * Sets the color of the segment when the power is off.
     *
     * @param corSegmentoDesligado the color of the segment when the power is off.
     */
    public void setCorSegmentoDesligado(Color corSegmentoDesligado) {
        this.corSegmentoDesligado = corSegmentoDesligado;
    }


    /**
     * Gets the size of the draw.
     *
     * @return the size of the draw
     */
    public int getFator() {
        return fator;
    }

    /**
     * Sets the size of the draw
     *
     * @param fator the size of the draw.
     */
    public void setFator(int fator) {
        this.fator = fator;
    }
}
