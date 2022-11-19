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

import edu.princeton.cs.algs4.Draw;


import java.awt.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * The type Desenha, the class responsible for drawing in the screen all the others classes.
 * Receive size of the canvas.
 * Receive 6 digits.
 * Receive the drawing area.
 * @author Theodor Konrad Wojcikiewicz
 */
public class Desenha {

    private int dimensao;
    //private int fator;
    //private double xInicial;
    //private double yInicial;
    //private Segmento segmento;
    private Digito digito;
    private Digito digitoUm;
    private Digito digitoDois;
    private Digito digitoTres;

    private Digito digitoQuatro;
    private Digito digitoCinco;
    private Digito digitoSeis;

    private Draw desenho;


    /**
     * Instantiates a new Desenha, responsible for drawing all the others classes.
     *
     * @param dimensao     the size of the canvas.
     * @param digito       the digit
     * @param digitoUm     the first digit
     * @param digitoDois   the second digit
     * @param digitoTres   the third digit
     * @param digitoQuatro the fourth digit
     * @param digitoCinco  the fifth digit
     * @param digitoSeis   the sixth digit
     * @param desenho      the drawing
     */
    public Desenha(int dimensao, Digito digito, Digito digitoUm, Digito digitoDois, Digito digitoTres, Digito digitoQuatro, Digito digitoCinco, Digito digitoSeis, Draw desenho) {
        this.dimensao = dimensao;
        this.digito = digito;
        this.digitoUm = digitoUm;
        this.digitoDois = digitoDois;
        this.digitoTres = digitoTres;
        this.digitoQuatro = digitoQuatro;
        this.digitoCinco = digitoCinco;
        this.digitoSeis = digitoSeis;
        this.desenho = desenho;


    }

    /**
     * The method for drawing, at the same time both Cronometro class (counter) and ContadorRegressivo class(timer).
     *
     * @param cronometro         the counter
     * @param contadorRegressivo the timer
     * @param desenha            the drawing
     * @param desenhaum          the other drawing
     * @throws InterruptedException the interrupted exception for synchronized running
     */
    public void desenhoParalelo(Cronometro cronometro, ContadorRegressivo contadorRegressivo, Desenha desenha, Desenha desenhaum) throws InterruptedException {


        Executors.newSingleThreadExecutor();

        ExecutorService executor  = Executors.newCachedThreadPool();

        executor.execute(()-> {
            try {
                desenha.desenhaCronometro(cronometro);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.execute(()-> {
            try {
                desenhaum.desenhaContadoRegressivo(contadorRegressivo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();

    }

    /**
     * The method to draw only seconds (deprecated, not working anymore)
     * @deprecated
     * @param contadorRegressivo the timer
     * @throws InterruptedException the interrupted exception
     */
    public void desenhaSegundo(ContadorRegressivo contadorRegressivo) throws InterruptedException {

        while (true) {

            int[] horario = contadorRegressivo.contador();
            int segundo = horario[2];

                /*
                switch(segundo){
                    case 0:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroZero(desenho, digitoSeis);

                        desenho.pause(1000);
                    case 1:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroUm(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 2:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroDois(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 3:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroTres(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 4:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroQuatro(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 5:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroCinco(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 6:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroSeis(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 7:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroSete(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 8:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroOito(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 9:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroNove(desenho, digitoSeis);

                        desenho.pause(1000);

                }
                */


            if (segundo == 0) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroZero(desenho, digitoSeis);

                desenho.pause(1000);


            } else if (segundo == 1) {

                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroUm(desenho, digitoSeis);

                desenho.pause(1000);


            } else if (segundo == 2) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroDois(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (segundo == 3) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroTres(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (segundo == 4) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroQuatro(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (segundo == 5) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroCinco(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (segundo == 6) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroSeis(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (segundo == 7) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroSete(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (segundo == 8) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroOito(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (segundo == 9) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                desenhaNumeroNove(desenho, digitoSeis);

                desenho.pause(1000);

            }


        }
    }


    /**
     * The method to draw only minutes.(deprecated, not working anymore)
     * @deprecated
     * @param contadorRegressivo the timer
     * @throws InterruptedException the interrupted exception
     */
    public void desenhaMinuto(ContadorRegressivo contadorRegressivo) throws InterruptedException {

        while (true) {

            int[] horario = contadorRegressivo.contador();
            int minuto = horario[1];


                /*
                switch(segundo){
                    case 0:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroZero(desenho, digitoSeis);

                        desenho.pause(1000);
                    case 1:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroUm(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 2:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroDois(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 3:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroTres(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 4:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroQuatro(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 5:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroCinco(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 6:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroSeis(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 7:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroSete(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 8:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroOito(desenho, digitoSeis);

                        desenho.pause(1000);

                    case 9:
                        desenhaGrade(desenho, digito);
                        digitoApagado(desenho, digito);
                        digitoApagado(desenho, digitoUm);
                        digitoApagado(desenho, digitoDois);
                        digitoApagado(desenho, digitoTres);
                        digitoApagado(desenho, digitoQuatro);
                        digitoApagado(desenho, digitoCinco);
                        desenhaNumeroNove(desenho, digitoSeis);

                        desenho.pause(1000);

                }
                */


            if (minuto == 0) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroZero(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);


            } else if (minuto == 1) {

                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroUm(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);


            } else if (minuto == 2) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroDois(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (minuto == 3) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroTres(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (minuto == 4) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroQuatro(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);

            } else if (minuto == 5) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroCinco(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (minuto == 6) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroSeis(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (minuto == 7) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroSete(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (minuto == 8) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                digitoApagado(desenho, digitoTres);
                desenhaNumeroOito(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);
            } else if (minuto == 9) {
                desenhaGrade(desenho, digito);
                digitoApagado(desenho, digito);
                digitoApagado(desenho, digitoUm);
                digitoApagado(desenho, digitoDois);
                desenhaNumeroNove(desenho, digitoTres);
                digitoApagado(desenho, digitoQuatro);
                digitoApagado(desenho, digitoCinco);
                digitoApagado(desenho, digitoSeis);

                desenho.pause(1000);

            }


        }
    }


    /**
     * The method to draw only the timer.
     *
     * @param contadorRegressivo the timer
     * @throws InterruptedException the interrupted exception to run the interruption in milliseconds in the timer
     */
    public void desenhaContadoRegressivo(ContadorRegressivo contadorRegressivo) throws InterruptedException {

        desenho.setTitle("Contador Regressivo");
        desenhaGrade(desenho, digito);

        while (contadorRegressivo.getHora()<=99) {


            int[] horario = contadorRegressivo.contador();
            int segundo = horario[2];
            int minuto = horario[1];
            int hora = horario[0];

            /*
            System.out.println("Seg " + horario[2]);
            System.out.println("Min " + horario[1]);
            System.out.println("Hora " + horario[0]);

             */


            Digito[] display = new Digito[]{digito, digitoUm, digitoDois, digitoTres, digitoQuatro, digitoCinco, digitoSeis};


            int segundoprimeirodisplay = segundo / 10;
            int segundosegundodisplay = segundo % 10;

            int minutoprimeirodisplay = minuto / 10;
            int minutosegundodisplay = minuto % 10;

            int horaprimeirodisplay = hora / 10;
            int horasegundodisplay = hora % 10;


            int[] time = new int[]{segundoprimeirodisplay, segundosegundodisplay, minutoprimeirodisplay, minutosegundodisplay, horaprimeirodisplay, horasegundodisplay};

            int segundo1 = time[0];
            int segundo2 = time[1];
            int minuto1 = time[2];
            int minuto2 = time[3];
            int hora1 = time[4];
            int hora2 = time[5];

            /*
            System.out.println("Seg1: " + segundo1);
            System.out.println("Seg2: " + segundo2);

            System.out.println("Min1 " + minuto1);
            System.out.println("Min2:" + minuto2);

            System.out.println("Hora1" + hora1);
            System.out.println("Hora2" + hora2);

             */




                /*
                for (int i = segundo1; i < display.length; i = i + segundo1) {

                    desenhaGrade(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroZero(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroUm(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroDois(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroTres(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroSete(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroOito(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroNove(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenho.show();

                }

                for (int j = 0; j < display.length; j = j + segundo2) {

                    desenhaGrade(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroZero(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroUm(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroDois(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroTres(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroCinco(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroSeis(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroSete(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroOito(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroNove(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenho.show();
                }

                for (int k = 0; k < display.length; k = k + minuto1) {

                    desenhaGrade(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroZero(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroUm(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroDois(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroTres(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroSete(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroOito(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroNove(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenho.show();
                }

                for (int l = 0; l < display.length; l = l + minuto2) {

                    desenhaGrade(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroZero(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroUm(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroDois(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroTres(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroCinco(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroSeis(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroSete(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroOito(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroNove(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenho.show();
                }

                for (int m = 0; m < display.length; m = m + hora1) {

                    desenhaGrade(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroZero(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroUm(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroDois(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroTres(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroSete(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroOito(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroNove(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenho.show();
                }

                for (int n = 0; n < display.length; n = n + hora2) {

                    desenhaGrade(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroZero(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroUm(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroDois(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroTres(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroQuatro(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroQuatro(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroCinco(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroSeis(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroSete(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroOito(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroNove(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenho.show();
                }



            for (int tempo = 0; tempo < display.length; tempo++) {


                if (tempo == 0) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[2]);
                    }

                } else if (tempo == 1) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[2]);
                    }
                } else if (tempo == 2) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[2]);
                    }
                } else if (tempo == 3) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[2]);
                    }

                } else if (tempo == 4) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[2]);
                    }
                } else if (tempo == 5) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[2]);
                    }
                } else if (tempo == 6) {


                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[2]);
                    }

                } else if (tempo == 7) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[2]);
                    }
                } else if (tempo == 8) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[2]);
                    }

                } else if (tempo == 9) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[2]);
                    }

                }
            }

                 */


            desenho.show();

            switch (segundoprimeirodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[5]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[5]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[5]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[5]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[5]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[5]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[5]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[5]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[5]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[5]);
                    break;

            }

            switch (segundosegundodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[6]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[6]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[6]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[6]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[6]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[6]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[6]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[6]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[6]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[6]);
                    break;

            }

            switch (minutoprimeirodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[3]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[3]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[3]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[3]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[3]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[3]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[3]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[3]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[3]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[3]);
                    break;

            }

            switch (minutosegundodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[4]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[4]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[4]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[4]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[4]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[4]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[4]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[4]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[4]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[4]);
                    break;

            }
            switch (horaprimeirodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[1]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[1]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[1]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[1]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[1]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[1]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[1]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[1]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[1]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[1]);
                    break;

            }

            switch (horasegundodisplay){

                case 0:
                    desenhaNumeroZero(desenho, display[2]);
                    break;
                case 1:
                    desenhaNumeroUm(desenho, display[2]);
                    break;
                case 2:
                    desenhaNumeroDois(desenho,display[2]);
                    break;
                case 3:
                    desenhaNumeroTres(desenho,display[2]);
                    break;
                case 4:
                    desenhaNumeroQuatro(desenho,display[2]);
                    break;
                case 5:
                    desenhaNumeroCinco(desenho,display[2]);
                    break;
                case 6:
                    desenhaNumeroSeis(desenho, display[2]);
                    break;
                case 7:
                    desenhaNumeroSete(desenho,  display[2]);
                    break;
                case 8:
                    desenhaNumeroOito(desenho, display[2]);
                    break;
                case 9:
                    desenhaNumeroNove(desenho, display[2]);
                    break;

            }

            /*
            if (segundoprimeirodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[5]);
                desenho.show();
            } else if (segundosegundodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[6]);
                desenho.show();
            } else if (minutoprimeirodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[3]);
                desenho.show();
            } else if (minutosegundodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[4]);
                desenho.show();
            } else if (horaprimeirodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[1]);
                desenho.show();
            } else if (horasegundodisplay == 0) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroZero(desenho, display[2]);
                desenho.show();
            }

            if (segundoprimeirodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[5]);
            } else if (segundosegundodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[6]);
            } else if (minutoprimeirodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[3]);
            } else if (minutosegundodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[4]);
            } else if (horaprimeirodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[1]);
            } else if (horasegundodisplay == 1) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroUm(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[5]);
            } else if (segundosegundodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[6]);
            } else if (minutoprimeirodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[3]);
            } else if (minutosegundodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[4]);
            } else if (horaprimeirodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[1]);
            } else if (horasegundodisplay == 2) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroDois(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[5]);
            } else if (segundosegundodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[6]);
            } else if (minutoprimeirodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[3]);
            } else if (minutosegundodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[4]);
            } else if (horaprimeirodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[1]);
            } else if (horasegundodisplay == 3) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroTres(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[5]);
            } else if (segundosegundodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[6]);
            } else if (minutoprimeirodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[3]);
            } else if (minutosegundodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[4]);
            } else if (horaprimeirodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[1]);
            } else if (horasegundodisplay == 4) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroQuatro(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[5]);
            } else if (segundosegundodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[6]);
            } else if (minutoprimeirodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[3]);
            } else if (minutosegundodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[4]);
            } else if (horaprimeirodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[1]);
            } else if (horasegundodisplay == 5) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroCinco(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[5]);
            } else if (segundosegundodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[6]);
            } else if (minutoprimeirodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[3]);
            } else if (minutosegundodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[4]);
            } else if (horaprimeirodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[1]);
            } else if (horasegundodisplay == 6) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSeis(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[5]);
            } else if (segundosegundodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[6]);
            } else if (minutoprimeirodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[3]);
            } else if (minutosegundodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[4]);
            } else if (horaprimeirodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[1]);
            } else if (horasegundodisplay == 7) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroSete(desenho, display[2]);
            }
            if (segundoprimeirodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[5]);
            } else if (segundosegundodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[6]);
            } else if (minutoprimeirodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[3]);
            } else if (minutosegundodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[4]);
            } else if (horaprimeirodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[1]);
            } else if (horasegundodisplay == 8) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroOito(desenho, display[2]);
                desenho.show();
            }
            if (segundoprimeirodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[5]);
                desenho.show();
            } else if (segundosegundodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[6]);
                desenho.show();
            } else if (minutoprimeirodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[3]);
                desenho.show();
            } else if (minutosegundodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[4]);
                desenho.show();
            } else if (horaprimeirodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[1]);
                desenho.show();
            } else if (horasegundodisplay == 9) {
                //desenhaGrade(desenho, display[0]);
                desenhaNumeroNove(desenho, display[2]);
                desenho.show();
            }

             */

        }
    }

    /**
     * The method to draw the counter only.
     *
     * @param cronometro the counter
     * @throws InterruptedException the interrupted exception to run the interruption in milliseconds in the counter
     */
    public void desenhaCronometro(Cronometro cronometro) throws InterruptedException {

        desenho.setTitle("Cronometro");
        desenhaGrade(desenho, digito);



            while (true) {


                int[] horario = cronometro.contador();
                int segundo = horario[2];
                int minuto = horario[1];
                int hora = horario[0];

            /*
            System.out.println("Seg " + horario[2]);
            System.out.println("Min " + horario[1]);
            System.out.println("Hora " + horario[0]);

             */




                Digito[] display = new Digito[]{digito, digitoUm, digitoDois, digitoTres, digitoQuatro, digitoCinco, digitoSeis};


                int segundoprimeirodisplay = segundo / 10;
                int segundosegundodisplay = segundo % 10;

                int minutoprimeirodisplay = minuto / 10;
                int minutosegundodisplay = minuto % 10;

                int horaprimeirodisplay = hora / 10;
                int horasegundodisplay = hora % 10;


                int[] time = new int[]{segundoprimeirodisplay, segundosegundodisplay, minutoprimeirodisplay, minutosegundodisplay, horaprimeirodisplay, horasegundodisplay};

                int segundo1 = time[0];
                int segundo2 = time[1];
                int minuto1 = time[2];
                int minuto2 = time[3];
                int hora1 = time[4];
                int hora2 = time[5];

                /*
                System.out.println("Seg1: " + segundo1);
                System.out.println("Seg2: " + segundo2);

                System.out.println("Min1 " + minuto1);
                System.out.println("Min2:" + minuto2);

                System.out.println("Hora1" + hora1);
                System.out.println("Hora2" + hora2);

                 */




                /*
                for (int i = segundo1; i < display.length; i = i + segundo1) {

                    desenhaGrade(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroZero(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroUm(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroDois(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroTres(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroSete(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroOito(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenhaNumeroNove(desenho, display[i]);
                    desenho.pause(segundoprimeirodisplay);
                    desenho.show();

                }

                for (int j = 0; j < display.length; j = j + segundo2) {

                    desenhaGrade(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroZero(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroUm(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroDois(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroTres(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroCinco(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroSeis(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroSete(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroOito(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenhaNumeroNove(desenho, display[j]);
                    desenho.pause(segundosegundodisplay);
                    desenho.show();
                }

                for (int k = 0; k < display.length; k = k + minuto1) {

                    desenhaGrade(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroZero(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroUm(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroDois(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroTres(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroSete(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroOito(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenhaNumeroNove(desenho, display[k]);
                    desenho.pause(minutoprimeirodisplay);
                    desenho.show();
                }

                for (int l = 0; l < display.length; l = l + minuto2) {

                    desenhaGrade(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroZero(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroUm(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroDois(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroTres(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroQuatro(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroCinco(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroSeis(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroSete(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroOito(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenhaNumeroNove(desenho, display[l]);
                    desenho.pause(minutosegundodisplay);
                    desenho.show();
                }

                for (int m = 0; m < display.length; m = m + hora1) {

                    desenhaGrade(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroZero(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroUm(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroDois(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroTres(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroQuatro(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroCinco(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroSeis(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroSete(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroOito(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenhaNumeroNove(desenho, display[m]);
                    desenho.pause(horaprimeirodisplay);
                    desenho.show();
                }

                for (int n = 0; n < display.length; n = n + hora2) {

                    desenhaGrade(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroZero(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroUm(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroDois(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroTres(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroQuatro(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroQuatro(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroCinco(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroSeis(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroSete(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroOito(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenhaNumeroNove(desenho, display[n]);
                    desenho.pause(horasegundodisplay);
                    desenho.show();
                }



            for (int tempo = 0; tempo < display.length; tempo++) {


                if (tempo == 0) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroZero(desenho, display[2]);
                    }

                } else if (tempo == 1) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroUm(desenho, display[2]);
                    }
                } else if (tempo == 2) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroDois(desenho, display[2]);
                    }
                } else if (tempo == 3) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroTres(desenho, display[2]);
                    }

                } else if (tempo == 4) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroQuatro(desenho, display[2]);
                    }
                } else if (tempo == 5) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroCinco(desenho, display[2]);
                    }
                } else if (tempo == 6) {


                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSeis(desenho, display[2]);
                    }

                } else if (tempo == 7) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroSete(desenho, display[2]);
                    }
                } else if (tempo == 8) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroOito(desenho, display[2]);
                    }

                } else if (tempo == 9) {

                    if (tempo == segundoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[5]);
                    } else if (tempo == segundosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[6]);
                    } else if (tempo == minutoprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[3]);
                    } else if (tempo == minutosegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[4]);
                    } else if (tempo == horaprimeirodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[1]);
                    } else if (tempo == horasegundodisplay) {
                        desenhaGrade(desenho, display[0]);
                        desenhaNumeroNove(desenho, display[2]);
                    }

                }
            }

                 */


                desenho.show();

                switch (segundoprimeirodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[5]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[5]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[5]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[5]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[5]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[5]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[5]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[5]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[5]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[5]);
                        break;

                }

                switch (segundosegundodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[6]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[6]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[6]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[6]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[6]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[6]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[6]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[6]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[6]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[6]);
                        break;

                }

                switch (minutoprimeirodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[3]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[3]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[3]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[3]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[3]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[3]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[3]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[3]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[3]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[3]);
                        break;

                }

                switch (minutosegundodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[4]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[4]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[4]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[4]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[4]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[4]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[4]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[4]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[4]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[4]);
                        break;

                }
                switch (horaprimeirodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[1]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[1]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[1]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[1]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[1]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[1]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[1]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[1]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[1]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[1]);
                        break;

                }

                switch (horasegundodisplay){

                    case 0:
                        desenhaNumeroZero(desenho, display[2]);
                        break;
                    case 1:
                        desenhaNumeroUm(desenho, display[2]);
                        break;
                    case 2:
                        desenhaNumeroDois(desenho,display[2]);
                        break;
                    case 3:
                        desenhaNumeroTres(desenho,display[2]);
                        break;
                    case 4:
                        desenhaNumeroQuatro(desenho,display[2]);
                        break;
                    case 5:
                        desenhaNumeroCinco(desenho,display[2]);
                        break;
                    case 6:
                        desenhaNumeroSeis(desenho, display[2]);
                        break;
                    case 7:
                        desenhaNumeroSete(desenho,  display[2]);
                        break;
                    case 8:
                        desenhaNumeroOito(desenho, display[2]);
                        break;
                    case 9:
                        desenhaNumeroNove(desenho, display[2]);
                        break;

                }


            }
        }


    /**
     * The method to automatic draw seven segments, each one going zero to nine in a fraction of a second
     */
    public void desenhaDigitoAndador() {

        while (true) {

            Digito[] display = new Digito[]{digito, digitoUm, digitoDois, digitoTres, digitoQuatro, digitoCinco, digitoSeis};


            for (int i = 0; i < display.length; i++) {
                desenhaGrade(desenho, display[i]);
                desenhaNumeroZero(desenho, display[i]);
                desenhaNumeroUm(desenho, display[i]);
                desenhaNumeroDois(desenho, display[i]);
                desenhaNumeroTres(desenho, display[i]);
                desenhaNumeroQuatro(desenho, display[i]);
                desenhaNumeroQuatro(desenho, display[i]);
                desenhaNumeroCinco(desenho, display[i]);
                desenhaNumeroSeis(desenho, display[i]);
                desenhaNumeroSete(desenho, display[i]);
                desenhaNumeroOito(desenho, display[i]);
                desenhaNumeroNove(desenho, display[i]);
                desenho.show();
            }
        }
    }


    /**
     * A method to try change the position on canvas of the digits (deprecated, not working).
     * @deprecated
     * @throws InterruptedException the interrupted exception
     */

    public void tentativaPosicionamento() throws InterruptedException {

        Digito[] display = new Digito[]{digito, digitoUm, digitoDois, digitoTres, digitoQuatro, digitoCinco, digitoSeis};



        desenhaGrade(desenho,display[0]);
       desenho.setLocationOnScreen(0,0);
       desenhaNumeroZero(desenho,display[0]);
       desenho.setLocationOnScreen(280,0);
       desenhaNumeroZero(desenho,display[1]);
        desenho.setLocationOnScreen(560,0);
       desenhaNumeroZero(desenho,display[2]);
        desenho.setLocationOnScreen(840,0);
       desenhaNumeroZero(desenho,display[3]);
        desenho.setLocationOnScreen(1120,0);
       desenhaNumeroZero(desenho,display[4]);
        desenho.setLocationOnScreen(1400,0);
       desenhaNumeroZero(desenho, display[5]);
        desenho.show();


    }


    /**
     * The method to draw six segments on the screen at the same time, from zero to nine, synchronized
     */
    public void desenhaSeisDigitos() {


        while(true) {

            desenho.clear();
            desenhaGrade(desenho, digito);

            desenhaNumeroZero(desenho, digito);
            desenhaNumeroZero(desenho, digitoUm);
            desenhaNumeroZero(desenho, digitoDois);
            desenhaNumeroZero(desenho, digitoTres);
            desenhaNumeroZero(desenho, digitoQuatro);
            desenhaNumeroZero(desenho, digitoCinco);
            desenhaNumeroZero(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroUm(desenho, digito);
            desenhaNumeroUm(desenho, digitoUm);
            desenhaNumeroUm(desenho, digitoDois);
            desenhaNumeroUm(desenho, digitoTres);
            desenhaNumeroUm(desenho, digitoQuatro);
            desenhaNumeroUm(desenho, digitoCinco);
            desenhaNumeroUm(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroDois(desenho, digito);
            desenhaNumeroDois(desenho, digitoUm);
            desenhaNumeroDois(desenho, digitoDois);
            desenhaNumeroDois(desenho, digitoTres);
            desenhaNumeroDois(desenho, digitoQuatro);
            desenhaNumeroDois(desenho, digitoCinco);
            desenhaNumeroDois(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroTres(desenho, digito);
            desenhaNumeroTres(desenho, digitoUm);
            desenhaNumeroTres(desenho, digitoDois);
            desenhaNumeroTres(desenho, digitoTres);
            desenhaNumeroTres(desenho, digitoQuatro);
            desenhaNumeroTres(desenho, digitoCinco);
            desenhaNumeroTres(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroQuatro(desenho, digito);
            desenhaNumeroQuatro(desenho, digitoUm);
            desenhaNumeroQuatro(desenho, digitoDois);
            desenhaNumeroQuatro(desenho, digitoTres);
            desenhaNumeroQuatro(desenho, digitoQuatro);
            desenhaNumeroQuatro(desenho, digitoCinco);
            desenhaNumeroQuatro(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroCinco(desenho, digito);
            desenhaNumeroCinco(desenho, digitoUm);
            desenhaNumeroCinco(desenho, digitoDois);
            desenhaNumeroCinco(desenho, digitoTres);
            desenhaNumeroCinco(desenho, digitoQuatro);
            desenhaNumeroCinco(desenho, digitoCinco);
            desenhaNumeroCinco(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroSeis(desenho, digito);
            desenhaNumeroSeis(desenho, digitoUm);
            desenhaNumeroSeis(desenho, digitoDois);
            desenhaNumeroSeis(desenho, digitoTres);
            desenhaNumeroSeis(desenho, digitoQuatro);
            desenhaNumeroSeis(desenho, digitoCinco);
            desenhaNumeroSeis(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroSete(desenho, digito);
            desenhaNumeroSete(desenho, digitoUm);
            desenhaNumeroSete(desenho, digitoDois);
            desenhaNumeroSete(desenho, digitoTres);
            desenhaNumeroSete(desenho, digitoQuatro);
            desenhaNumeroSete(desenho, digitoCinco);
            desenhaNumeroSete(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroOito(desenho, digito);
            desenhaNumeroOito(desenho, digitoUm);
            desenhaNumeroOito(desenho, digitoDois);
            desenhaNumeroOito(desenho, digitoTres);
            desenhaNumeroOito(desenho, digitoQuatro);
            desenhaNumeroOito(desenho, digitoCinco);
            desenhaNumeroOito(desenho, digitoSeis);

            desenho.pause(1000);

            desenhaNumeroNove(desenho, digito);
            desenhaNumeroNove(desenho, digitoUm);
            desenhaNumeroNove(desenho, digitoDois);
            desenhaNumeroNove(desenho, digitoTres);
            desenhaNumeroNove(desenho, digitoQuatro);
            desenhaNumeroNove(desenho, digitoCinco);
            desenhaNumeroNove(desenho, digitoSeis);

            desenho.pause(1000);

        }
        /*
        desenhaNumeroZero(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroUm(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroDois(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroTres(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroQuatro(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroCinco(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroSeis(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroSete(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroOito(desenho, digito);
        desenho.pause(1000);
        desenhaNumeroNove(desenho, digito);
        desenho.pause(1000);


        desenhaSegmentoA(desenho,digito);
        desenhaSegmentoB(desenho,digito);
        desenhaSegmentoC(desenho,digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho,digito);
        desenhaSegmentoF(desenho,digito);
        desenhaSegmentoG(desenho,digito);

         */

    }



/*
    public void desenhaDigitos() {


            desenho.clear();
            desenha0(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial, yInicial);
            desenho.show();
            desenho.pause(1000);

            desenho.clear();
            desenha0(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial+280, yInicial);
            desenho.show();
            desenho.pause(1000);

            desenho.clear();
            desenha0(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial+560, yInicial);
            desenho.show();
            desenho.pause(1000);

            desenho.clear();
            desenha0(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial+840, yInicial);
            desenho.show();
            desenho.pause(1000);

            desenho.clear();
            desenha0(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial+1120, yInicial);
            desenho.show();
            desenho.pause(1000);

            desenho.clear();
            desenha0(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha1(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha2(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha3(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha4(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha5(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha6(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha7(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha8(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);
            desenho.clear();
            desenha9(desenho, xInicial+1400, yInicial);
            desenho.show();
            desenho.pause(1000);




        desenha0relativo(desenho, 0,0);
        desenha0relativo(desenho, 280,0);
        desenha0relativo(desenho,560,0);
        desenha0relativo(desenho,840,0);
        desenha0relativo(desenho, 1120,0);
        desenha0relativo(desenho, 1400,0);


}

 */


    /**
     * The method responsible to draw the screen, set the size, enable the buffering of the draw before drawing, change the color of the backgroung and start all the six digits off .
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaGrade(Draw desenho, Digito digito){

        //desenho.setCanvasSize(1366, 768);

        /*
        desenho.setXscale(40,100);
        desenho.setYscale(40,100);

         */

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);


        desenho.enableDoubleBuffering();

        desenho.setPenColor(Color.gray);
        desenho.filledSquare(dimensao,dimensao,dimensao);

        /*
        int grade = 10;
        desenho.setPenColor(Color.RED);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */



        digitoApagado(desenho, digitoUm);
        digitoApagado(desenho, digitoDois);
        digitoApagado(desenho, digitoTres);
        digitoApagado(desenho, digitoQuatro);
        digitoApagado(desenho, digitoCinco);
        digitoApagado(desenho, digitoSeis);


        /*
        int grade = digito.getB().getFator() / 10;
        desenho.setPenColor(digito.getB().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

        int grade = digito.getA().getFator() / 10;
        desenho.setPenColor(digito.getA().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

        int grade = (int) digito.getE().getFator() / 10;
        desenho.setPenColor(digito.getE().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

        int grade = digito.getF().getFator() / 10;
        desenho.setPenColor(digito.getF().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

        int grade = digito.getG().getFator() / 10;
        desenho.setPenColor(digito.getG().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

        int grade = digito.getD().getFator() / 10;
        desenho.setPenColor(digito.getD().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */




    }

    /**
     * The method for drawing segment C of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoC(Draw desenho, Digito digito) {

        /*
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        desenho.enableDoubleBuffering();

        int grade = digito.getC().getFator() / 10;
        desenho.setPenColor(digito.getC().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */
        double[] xVertical = {0.1 * digito.getC().getFator() + digito.getC().getxInicial(), 0.2 * digito.getC().getFator() + digito.getC().getxInicial(), 0.2 * digito.getC().getFator() + digito.getC().getxInicial(), 0.1 * digito.getC().getFator() + digito.getC().getxInicial(), 0 * digito.getC().getFator() + digito.getC().getxInicial(), 0 * digito.getC().getFator() + digito.getC().getxInicial()};
        double[] yVertical = {0.2 * digito.getC().getFator() + digito.getC().getyInicial(), 0.3 * digito.getC().getFator() + digito.getC().getyInicial(), 1.0 * digito.getC().getFator() + digito.getC().getyInicial(), 1.1 * digito.getC().getFator() + digito.getC().getyInicial(), 1.0 * digito.getC().getFator() + digito.getC().getyInicial(), 0.3 * digito.getC().getFator() + digito.getC().getyInicial()};

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;

        }
        desenho.setPenColor(digito.getC().getCorSegmentoLigado());
        desenho.filledPolygon(xVertical, yVertical);

        desenho.show();

    }

    /**
     * The method for drawing segment B of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoB(Draw desenho, Digito digito) {

        /*
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);

        desenho.enableDoubleBuffering();


        int grade = digito.getB().getFator() / 10;
        desenho.setPenColor(digito.getB().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */


        double[] xVertical = {0.1 * digito.getB().getFator() + digito.getB().getxInicial(), 0.2 * digito.getB().getFator() + digito.getB().getxInicial(), 0.2 * digito.getB().getFator() + digito.getB().getxInicial(), 0.1 * digito.getB().getFator() + digito.getB().getxInicial(), 0 * digito.getB().getFator() + digito.getB().getxInicial(), 0 * digito.getB().getFator() + digito.getB().getxInicial()};
        double[] yVertical = {0.2 * digito.getB().getFator() + digito.getB().getyInicial(), 0.3 * digito.getB().getFator() + digito.getB().getyInicial(), 1.0 * digito.getB().getFator() + digito.getB().getyInicial(), 1.1 * digito.getB().getFator() + digito.getB().getyInicial(), 1.0 * digito.getB().getFator() + digito.getB().getyInicial(), 0.3 * digito.getB().getFator() + digito.getB().getyInicial()};


        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(digito.getB().getCorSegmentoLigado());
        desenho.filledPolygon(xVertical, yVertical);
        desenho.show();

    }

    /**
     * The method for drawing segment A of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoA(Draw desenho, Digito digito) {
        /*
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);

        desenho.enableDoubleBuffering();


        int grade = digito.getA().getFator() / 10;
        desenho.setPenColor(digito.getA().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */


        double[] xHorizontal = {0.1 * digito.getA().getFator() + digito.getA().getxInicial(), 0.2 * digito.getA().getFator() + digito.getA().getxInicial(), 1.0 * digito.getA().getFator() + digito.getA().getxInicial(), 1.1 * digito.getA().getFator() + digito.getA().getxInicial(), 1.0 * digito.getA().getFator() + digito.getA().getxInicial(), 0.2 * digito.getA().getFator() + digito.getA().getxInicial()};
        double[] yHorizontal = {0.2 * digito.getA().getFator() + digito.getA().getyInicial(), 0.3 * digito.getA().getFator() + digito.getA().getyInicial(), 0.3 * digito.getA().getFator() + digito.getA().getyInicial(), 0.2 * digito.getA().getFator() + digito.getA().getyInicial(), 0.1 * digito.getA().getFator() + digito.getA().getyInicial(), 0.1 * digito.getA().getFator() + digito.getA().getyInicial()};

        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;
        }
        desenho.setPenColor(digito.getA().getCorSegmentoLigado());
        desenho.filledPolygon(xHorizontal, yHorizontal);
        desenho.show();

    }


    /**
     * The method for drawing segment E of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoE(Draw desenho, Digito digito) {

        /*
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();


        // Desenhando grade quadriculada
        int grade = (int) digito.getE().getFator() / 10;
        desenho.setPenColor(digito.getE().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */



        double[] xVertical = {0.1 * digito.getE().getFator() + digito.getE().getxInicial(), 0.2 * digito.getE().getFator() + digito.getE().getxInicial(), 0.2 * digito.getE().getFator() + digito.getE().getxInicial(), 0.1 * digito.getE().getFator() + digito.getE().getxInicial(), 0 * digito.getE().getFator() + digito.getE().getxInicial(), 0 * digito.getE().getFator() + digito.getE().getxInicial()};
        double[] yVertical = {0.2 * digito.getE().getFator() + digito.getE().getyInicial(), 0.3 * digito.getE().getFator() + digito.getE().getyInicial(), 1.0 * digito.getE().getFator() + digito.getE().getyInicial(), 1.1 * digito.getE().getFator() + digito.getE().getyInicial(), 1.0 * digito.getE().getFator() + digito.getE().getyInicial(), 0.3 * digito.getE().getFator() + digito.getE().getyInicial()};

        //E


        desenho.setPenColor(digito.getE().getCorSegmentoLigado());
        desenho.filledPolygon(xVertical, yVertical);
        desenho.show();


    }

    /**
     * The method for drawing segment D of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhasegmentoD(Draw desenho, Digito digito) {

        /*
        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();


        // Desenhando grade quadriculada
        int grade = digito.getD().getFator() / 10;
        desenho.setPenColor(digito.getD().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal


        double[] xHorizontal = {0.1 * digito.getD().getFator() + digito.getD().getxInicial(), 0.2 * digito.getD().getFator() + digito.getD().getxInicial(), 1.0 * digito.getD().getFator() + digito.getD().getxInicial(), 1.1 * digito.getD().getFator() + digito.getD().getxInicial(), 1.0 * digito.getD().getFator() + digito.getD().getxInicial(), 0.2 * digito.getD().getFator() + digito.getD().getxInicial()};
        double[] yHorizontal = {0.2 * digito.getD().getFator() + digito.getD().getyInicial(), 0.3 * digito.getD().getFator() + digito.getD().getyInicial(), 0.3 * digito.getD().getFator() + digito.getD().getyInicial(), 0.2 * digito.getD().getFator() + digito.getD().getyInicial(), 0.1 * digito.getD().getFator() + digito.getD().getyInicial(), 0.1 * digito.getD().getFator() + digito.getD().getyInicial()};

        desenho.setPenColor(digito.getD().getCorSegmentoLigado());
        desenho.filledPolygon(xHorizontal, yHorizontal);
        desenho.show();


    }

    /**
     * The method for drawing segment F of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoF(Draw desenho, Digito digito) {

        /*
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);

        desenho.enableDoubleBuffering();


        // Desenhando grade quadriculada
        int grade = digito.getF().getFator() / 10;
        desenho.setPenColor(digito.getF().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */


        double[] xVertical = {0.1 * digito.getF().getFator() + digito.getF().getxInicial(), 0.2 * digito.getF().getFator() + digito.getF().getxInicial(), 0.2 * digito.getF().getFator() + digito.getF().getxInicial(), 0.1 * digito.getF().getFator() + digito.getF().getxInicial(), 0 * digito.getF().getFator() + digito.getF().getxInicial(), 0 * digito.getF().getFator() + digito.getF().getxInicial()};
        double[] yVertical = {0.2 * digito.getF().getFator() + digito.getF().getyInicial(), 0.3 * digito.getF().getFator() + digito.getF().getyInicial(), 1.0 * digito.getF().getFator() + digito.getF().getyInicial(), 1.1 * digito.getF().getFator() + digito.getF().getyInicial(), 1.0 * digito.getF().getFator() + digito.getF().getyInicial(), 0.3 * digito.getF().getFator() + digito.getF().getyInicial()};


        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(digito.getF().getCorSegmentoLigado());
        desenho.filledPolygon(xVertical, yVertical);
        desenho.show();

    }

    /**
     * The method for drawing segment G of the digit.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaSegmentoG(Draw desenho, Digito digito) {
        /*
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        desenho.enableDoubleBuffering();


        // Desenhando grade quadriculada
        int grade = digito.getG().getFator() / 10;
        desenho.setPenColor(digito.getG().getCorSegmentoDesligado());
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);

         */


        double[] xHorizontal = {0.1 * digito.getG().getFator() + digito.getG().getxInicial(), 0.2 * digito.getG().getFator() + digito.getG().getxInicial(), 1.0 * digito.getG().getFator() + digito.getG().getxInicial(), 1.1 * digito.getG().getFator() + digito.getG().getxInicial(), 1.0 * digito.getG().getFator() + digito.getG().getxInicial(), 0.2 * digito.getG().getFator() + digito.getG().getxInicial()};
        double[] yHorizontal = {0.2 * digito.getG().getFator() + digito.getG().getyInicial(), 0.3 * digito.getG().getFator() + digito.getG().getyInicial(), 0.3 * digito.getG().getFator() + digito.getG().getyInicial(), 0.2 * digito.getG().getFator() + digito.getG().getyInicial(), 0.1 * digito.getG().getFator() + digito.getG().getyInicial(), 0.1 * digito.getG().getFator() + digito.getG().getyInicial()};


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(digito.getG().getCorSegmentoLigado());
        desenho.filledPolygon(xHorizontal, yHorizontal);
        desenho.show();

    }

    /**
     * The method for drawing the number zero.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroZero(Draw desenho, Digito digito){

        /*
        digito.getA().setCorSegmentoLigado(digito.getA().getCorSegmentoLigado());
        digito.getB().setCorSegmentoLigado(digito.getB().getCorSegmentoLigado());
        digito.getC().setCorSegmentoLigado(digito.getC().getCorSegmentoLigado());
        digito.getD().setCorSegmentoLigado(digito.getD().getCorSegmentoLigado());
        digito.getE().setCorSegmentoLigado(digito.getE().getCorSegmentoLigado());
        digito.getF().setCorSegmentoLigado(digito.getF().getCorSegmentoLigado());
        digito.getG().setCorSegmentoDesligado(digito.getG().getCorSegmentoDesligado());

         */


        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.green);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.lightGray);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);


    }


    /**
     * The method for turning all the segments off.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void digitoApagado(Draw desenho, Digito digito){


            digito.getA().setCorSegmentoLigado(Color.lightGray);
            digito.getB().setCorSegmentoLigado(Color.lightGray);
            digito.getC().setCorSegmentoLigado(Color.lightGray);
            digito.getD().setCorSegmentoLigado(Color.lightGray);
            digito.getE().setCorSegmentoLigado(Color.lightGray);
            digito.getF().setCorSegmentoLigado(Color.lightGray);
            digito.getG().setCorSegmentoLigado(Color.lightGray);


            desenhaSegmentoA(desenho, digito);
            desenhaSegmentoB(desenho, digito);
            desenhaSegmentoC(desenho, digito);
            desenhasegmentoD(desenho, digito);
            desenhaSegmentoE(desenho, digito);
            desenhaSegmentoF(desenho, digito);
            desenhaSegmentoG(desenho, digito);


    }

    /**
     * The method for drawing the number one.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroUm(Draw desenho, Digito digito) {



        digito.getA().setCorSegmentoLigado(Color.lightGray);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.lightGray);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.lightGray);
        digito.getG().setCorSegmentoLigado(Color.lightGray);




        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number two.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroDois(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.lightGray);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.green);
        digito.getF().setCorSegmentoLigado(Color.lightGray);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number three.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroTres(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.lightGray);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number four.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroQuatro(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.lightGray);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.lightGray);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number five.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroCinco(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.lightGray);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number six.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroSeis(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.lightGray);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.green);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number seven.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroSete(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.lightGray);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.lightGray);
        digito.getG().setCorSegmentoLigado(Color.lightGray);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number eight.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroOito(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.green);
        digito.getE().setCorSegmentoLigado(Color.green);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }

    /**
     * The method for drawing the number nine.
     *
     * @param desenho the draw
     * @param digito  the digit
     */
    public void desenhaNumeroNove(Draw desenho, Digito digito) {

        digito.getA().setCorSegmentoLigado(Color.green);
        digito.getB().setCorSegmentoLigado(Color.green);
        digito.getC().setCorSegmentoLigado(Color.green);
        digito.getD().setCorSegmentoLigado(Color.lightGray);
        digito.getE().setCorSegmentoLigado(Color.lightGray);
        digito.getF().setCorSegmentoLigado(Color.green);
        digito.getG().setCorSegmentoLigado(Color.green);


        desenhaSegmentoA(desenho, digito);
        desenhaSegmentoB(desenho, digito);
        desenhaSegmentoC(desenho, digito);
        desenhasegmentoD(desenho, digito);
        desenhaSegmentoE(desenho, digito);
        desenhaSegmentoF(desenho, digito);
        desenhaSegmentoG(desenho, digito);
    }
    /*


    public void desenha0relativo(Draw desenho, int xInicial, int yInicial) {

        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Desenhando outro segmento vertical com um espaço de 200 pixels em X
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.filledPolygon(xVertical, yVertical);
        // ---------------------------------------- //
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.filledPolygon(xVertical, yVertical);

        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }

    public void desenha0(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Desenhando outro segmento vertical com um espaço de 200 pixels em X
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.filledPolygon(xVertical, yVertical);
        // ---------------------------------------- //
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.filledPolygon(xVertical, yVertical);

        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }

    public void desenha1(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }

    public void desenha2(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }

    public void desenha3(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha4(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha5(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha6(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha7(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha8(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }
    public void desenha9(Draw desenho, double xInicial, double yInicial) {

        //Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)

        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos


        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade) desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade) desenho.line(0, j, dimensao, j);



        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento horizontal

        double[] xHorizontal = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial, 1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial};
        double[] yHorizontal = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial, 0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial};

        //D
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        // ---------------------------------------- //

        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = {0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial, 0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial};
        double[] yVertical = {0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial, 1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial};

        //E
        desenho.setPenColor(Draw.GRAY);
        desenho.filledPolygon(xVertical, yVertical);

        // C
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += 200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        //B
        for (int i = 0; i < yVertical.length; i++) {
            yVertical[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);


        //G
        for (int i = 0; i < yHorizontal.length; i++) {

            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);


        //A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += 180;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xHorizontal, yHorizontal);

        //F
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += -200;


        }
        desenho.setPenColor(Draw.GREEN);
        desenho.filledPolygon(xVertical, yVertical);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    }



*/





}
