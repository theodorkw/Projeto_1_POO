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


/**
 * The type Main.
 * @author Theodor Konrad Wojcikiewicz
 * Have the instantiation of all the 84 segments, 12 digits, 1 counter, 1 timer.
 * Have the instantiation of the hour, minute, seconds, colors, size of the drawing, size of the screen.
 * Have the instantiation of the x and y position on the canvas.
 * Please don't change any value, read copyright first.
 */
public class Main {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {

        /*

        //testte desenha

        //Desenha d = new Desenha(2000,200,200,200,new Draw());

        d.desenha0();
        d.desenha1();
        d.desenha2();
        d.desenha3();
        d.desenha4();
        d.desenha5();
        d.desenha6();
        d.desenha7();
        d.desenha8();
        d.desenha9();

 */
        /*
        //teste cronometro
        //Cronometro c = new Cronometro(1, 99, 23, 59, 59);

        for (int i=0;i<99;i++) {
            System.out.println("Seg: "+c.contadorSegundos());
            System.out.println("Min: "+c.contadorMinutos());
            System.out.println("Hora: "+c.contadorHora());
        }

         */
        /*
        //teste contador regressivo

        Scanner sc = new Scanner(System.in);

        System.out.println("h");
        int hora = Integer.parseInt(sc.nextLine());
        System.out.println("min");
        int minuto = Integer.parseInt(sc.nextLine());
        System.out.println("seg");
        int segundo= Integer.parseInt(sc.nextLine());





        while (hora <= 99) {

            if(hora==0){
                hora=99;
                System.out.println("Hora"+hora);
            }
            if(minuto==0){
                hora--;
                minuto=60;
                System.out.println("Hora"+hora);
                System.out.println("Min"+minuto);
            }
            if(segundo==0){
                minuto--;
                segundo=60;
                System.out.println("Min"+minuto);
                System.out.println("Seg"+segundo);
            }

            else {

                Thread.sleep(1000);
                segundo--;
                System.out.println("Seg" + segundo);
            }

        }

         */
        /*

        //teste ccontador
        while(hora<99){

            Thread.sleep(1000);
            segundos++;
            System.out.println("Segundos" +segundos);

            if(minutos==60){
                hora++;
                minutos=0;
                System.out.println("Horas: "+hora);
            }
            if (segundos==60) {
                minutos++;
                segundos=0;
                System.out.println("Minutos: "+minutos);
            }
        }

         */

        // Implementar modificação funcional da troca de cordennadas iniciais, fator e cores  // TODO: 18/11/2022




        //Contador Regressivo(nao mexer nas posicoes iniciais e nem no fator)

        Segmento a = new Segmento(0,180, 200, Color.green, Color.lightGray);
        Segmento b = new Segmento(200,0, 200,Color.green, Color.lightGray);
        Segmento c = new Segmento(0,0,200, Color.green, Color.lightGray);
        Segmento d= new Segmento(0,0,200, Color.green, Color.lightGray);
        Segmento e = new Segmento(0,0,200, Color.green, Color.lightGray);
        Segmento f = new Segmento(200,180,200, Color.green, Color.lightGray);
        Segmento g = new Segmento(0,0,200, Color.green, Color.lightGray);

        Segmento a1 = new Segmento(280,180, 200, Color.green, Color.lightGray);
        Segmento b1 = new Segmento(480,0, 200, Color.green, Color.lightGray);
        Segmento c1= new Segmento(280,0,200, Color.green, Color.lightGray);
        Segmento d1 = new Segmento(280,0,200, Color.green, Color.lightGray);
        Segmento e1 = new Segmento(280,0,200, Color.green, Color.lightGray);
        Segmento f1 = new Segmento(480,180,200,Color.green, Color.lightGray);
        Segmento g1 = new Segmento(280,0,200, Color.green, Color.lightGray);

        Segmento a2 = new Segmento(560,180, 200,Color.green, Color.lightGray);
        Segmento b2 = new Segmento(760,0, 200, Color.green, Color.lightGray);
        Segmento c2 = new Segmento(560,0,200, Color.green, Color.lightGray);
        Segmento d2 = new Segmento(560,0,200, Color.green, Color.lightGray);
        Segmento e2 = new Segmento(560,0,200, Color.green, Color.lightGray);
        Segmento f2 = new Segmento(760,180,200, Color.green, Color.lightGray);
        Segmento g2 = new Segmento(560,0,200, Color.green, Color.lightGray);

        Segmento a3 = new Segmento(840,180, 200, Color.green, Color.lightGray);
        Segmento b3 = new Segmento(1040,0, 200, Color.green, Color.lightGray);
        Segmento c3= new Segmento(840,0,200, Color.green, Color.lightGray);
        Segmento d3 = new Segmento(840,0,200, Color.green, Color.lightGray);
        Segmento e3 = new Segmento(840,0,200, Color.green, Color.lightGray);
        Segmento f3 = new Segmento(1040,180,200, Color.green, Color.lightGray);
        Segmento g3 = new Segmento(840,0,200, Color.green, Color.lightGray);

        Segmento a4 = new Segmento(1120,180, 200, Color.green, Color.lightGray);
        Segmento b4 = new Segmento(1320,0, 200,Color.green, Color.lightGray);
        Segmento c4= new Segmento(1120,0,200,Color.green, Color.lightGray);
        Segmento d4 = new Segmento(1120,0,200,Color.green, Color.lightGray);
        Segmento e4 = new Segmento(1120,0,200,Color.green, Color.lightGray);
        Segmento f4 = new Segmento(1320,180,200,Color.green, Color.lightGray);
        Segmento g4 = new Segmento(1120,0,200,Color.green, Color.lightGray);

        Segmento a5 = new Segmento(1400,180, 200,Color.green, Color.lightGray);
        Segmento b5 = new Segmento(1600,0, 200,Color.green, Color.lightGray);
        Segmento c5= new Segmento(1400,0,200,Color.green, Color.lightGray);
        Segmento d5 = new Segmento(1400,0,200,Color.green, Color.lightGray);
        Segmento e5 = new Segmento(1400,0,200,Color.green, Color.lightGray);
        Segmento f5 = new Segmento(1600,180,200,Color.green, Color.lightGray);
        Segmento g5 = new Segmento(1400,0,200,Color.green, Color.lightGray);

        Segmento a6 = new Segmento(1680,180, 200,Color.green, Color.lightGray);
        Segmento b6 = new Segmento(1880,0, 200,Color.green, Color.lightGray);
        Segmento c6= new Segmento(1680,0,200,Color.green, Color.lightGray);
        Segmento d6 = new Segmento(1680,0,200,Color.green, Color.lightGray);
        Segmento e6 = new Segmento(1680,0,200,Color.green, Color.lightGray);
        Segmento f6 = new Segmento(1880,180,200, Color.green, Color.lightGray);
        Segmento g6 = new Segmento(1680,0,200, Color.green, Color.lightGray);


        /*
        ContadorRegressivo contadorRegressivo = new ContadorRegressivo(99,59,59,200,0,0,Color.green,Color.lightGray);
        Cronometro cronometro = new Cronometro(99,59,59,0,0,Color.green,Color.lightGray,200);


        Segmento a= new Segmento(cronometro,contadorRegressivo);

        Digito zero = new Digito(a,a,a,a,a,a,a);
        Desenha tudo = new Desenha(2000,zero,zero,zero,zero,zero,zero,zero, new Draw());

        tudo.desenhaSeisDigitos();

         */


        Digito zero = new Digito(a,b,c,d,e,f,g);
        Digito um = new Digito(a1,b1,c1,d1,e1,f1,g1);
        Digito dois = new Digito(a2,b2,c2,d2,e2,f2,g2);
        Digito tres = new Digito(a3,b3,c3,d3,e3,f3,g3);
        Digito quatro = new Digito(a4,b4,c4,d4,e4,f4,g4);
        Digito cinco = new Digito(a5,b5,c5,d5,e5,f5,g5);
        Digito seis = new Digito(a6,b6,c6,d6,e6,f6,g6);

        ContadorRegressivo contadorRegressivo = new ContadorRegressivo(0,0,0,200,0,0,Color.green,Color.lightGray);

        Desenha contador = new Desenha(2000,zero,um, dois, tres,quatro,cinco, seis, new Draw());

        //contador.desenhaContadoRegressivo(contadorRegressivo);


        //Cronometro (nao mexer nas posicoes iniciais nem no fator)

        Segmento a7 = new Segmento(0,960, 200, Color.green, Color.lightGray);
        Segmento b7 = new Segmento(200,780, 200, Color.green, Color.lightGray);
        Segmento c7 = new Segmento(0,780,200, Color.green, Color.lightGray);
        Segmento d7 = new Segmento(0,780,200,Color.green, Color.lightGray);
        Segmento e7 = new Segmento(0,780,200,Color.green, Color.lightGray);
        Segmento f7 = new Segmento(200,960,200, Color.green, Color.lightGray);
        Segmento g7 = new Segmento(0,780,200,Color.green, Color.lightGray);

        Segmento a8 = new Segmento(280,960, 200,Color.green, Color.lightGray);
        Segmento b8 = new Segmento(480, 780, 200, Color.green, Color.lightGray );
        Segmento c8= new Segmento(280,780,200,Color.green, Color.lightGray);
        Segmento d8 = new Segmento(280,780,200,Color.green, Color.lightGray);
        Segmento e8 = new Segmento(280,780,200, Color.green, Color.lightGray);
        Segmento f8 = new Segmento(480,960,200, Color.green, Color.lightGray);
        Segmento g8 = new Segmento(280,780,200, Color.green, Color.lightGray);

        Segmento a9 = new Segmento(560,960, 200, Color.green, Color.lightGray);
        Segmento b9 = new Segmento(760,780, 200, Color.green, Color.lightGray);
        Segmento c9 = new Segmento(560,780,200, Color.green, Color.lightGray);
        Segmento d9 = new Segmento(560,780,200, Color.green, Color.lightGray);
        Segmento e9 = new Segmento(560,780,200, Color.green, Color.lightGray);
        Segmento f9 = new Segmento(760,960,200, Color.green, Color.lightGray);
        Segmento g9 = new Segmento(560,780,200, Color.green, Color.lightGray);

        Segmento a10 = new Segmento(840,960, 200, Color.green, Color.lightGray);
        Segmento b10 = new Segmento(1040,780, 200, Color.green, Color.lightGray);
        Segmento c10= new Segmento(840,780,200, Color.green, Color.lightGray);
        Segmento d10 = new Segmento(840,780,200, Color.green, Color.lightGray);
        Segmento e10 = new Segmento(840,780,200, Color.green, Color.lightGray);
        Segmento f10 = new Segmento(1040,960,200, Color.green, Color.lightGray);
        Segmento g10 = new Segmento(840,780,200, Color.green, Color.lightGray);

        Segmento a11 = new Segmento(1120,960, 200, Color.green, Color.lightGray);
        Segmento b11 = new Segmento(1320,780, 200, Color.green, Color.lightGray);
        Segmento c11= new Segmento(1120,780,200, Color.green, Color.lightGray);
        Segmento d11 = new Segmento(1120,780,200, Color.green, Color.lightGray);
        Segmento e11 = new Segmento(1120,780,200, Color.green, Color.lightGray);
        Segmento f11 = new Segmento(1320,960,200, Color.green, Color.lightGray);
        Segmento g11 = new Segmento(1120,780,200, Color.green, Color.lightGray);

        Segmento a12 = new Segmento(1400,960, 200, Color.green, Color.lightGray);
        Segmento b12 = new Segmento(1600,780, 200, Color.green, Color.lightGray);
        Segmento c12 = new Segmento(1400,780,200, Color.green, Color.lightGray);
        Segmento d12 = new Segmento(1400,780,200, Color.green, Color.lightGray);
        Segmento e12 = new Segmento(1400,780,200, Color.green, Color.lightGray);
        Segmento f12 = new Segmento(1600,960,200, Color.green, Color.lightGray);
        Segmento g12 = new Segmento(1400,780,200,Color.green, Color.lightGray);

        Segmento a13 = new Segmento(1680,960, 200, Color.green, Color.lightGray);
        Segmento b13 = new Segmento(1880,780, 200,Color.green, Color.lightGray);
        Segmento c13 = new Segmento(1680,780,200,Color.green, Color.lightGray);
        Segmento d13 = new Segmento(1680,780,200, Color.green, Color.lightGray);
        Segmento e13 = new Segmento(1680,780,200,Color.green, Color.lightGray);
        Segmento f13 = new Segmento(1880,960,200, Color.green, Color.lightGray);
        Segmento g13 = new Segmento(1680,780,200,Color.green, Color.lightGray);


        /*
        ContadorRegressivo contadorRegressivo = new ContadorRegressivo(99,59,59,200,0,0,Color.green,Color.lightGray);
        Cronometro cronometro = new Cronometro(99,59,59,0,0,Color.green,Color.lightGray,200);


        Segmento a= new Segmento(cronometro,contadorRegressivo);

        Digito zero = new Digito(a,a,a,a,a,a,a);
        Desenha tudo = new Desenha(2000,zero,zero,zero,zero,zero,zero,zero, new Draw());

        tudo.desenhaSeisDigitos();

         */

        Digito zerocr = new Digito(a7,b7,c7,d7,e7,f7,g7);
        Digito umcr = new Digito(a8,b8,c8,d8,e8,f8,g8);
        Digito doiscr= new Digito(a9,b9,c9,d9,e9,f9,g9);
        Digito trescr = new Digito(a10,b10,c10,d10,e10,f10,g10);
        Digito quatrocr = new Digito(a11,b11,c11,d11,e11,f11,g11);
        Digito cincocr = new Digito(a12,b12,c12,d12,e12,f12,g12);
        Digito seiscr = new Digito(a13,b13,c13,d13,e13,f13,g13);

        Cronometro cronometro = new Cronometro(0,0,2000,Color.green,Color.BLUE);

        Desenha cronos = new Desenha(2000,zerocr,umcr, doiscr, trescr,quatrocr,cincocr, seiscr, new Draw());



        //Desenha so o contador regressivo, so o cronometro ou ambos;

        //cronos.desenhaCronometro(cronometro);
        //contador.desenhaContadoRegressivo(contadorRegressivo);


        cronos.desenhoParalelo(cronometro,contadorRegressivo,cronos,contador);

        //cronos.desenhaSeisDigitos();
        //cronos.desenhaDigitoAndador();

        //testes de chamadas de metodos


        //sa.desenhaSeisDigitos();
        //sa.teste(contadorRegressivo);

        //sa.tar(contadorRegressivo);
        //sa.desenhaSegundo(contadorRegressivo);
        //sa.tentativaPosicionamento();

        //sa.desenhaaautomatico(contadorRegressivo);

        //cronos.desenhaSegundo(contadorRegressivo);

        //sa.desenhaContadoRegressivo(contadorRegressivo);

        //sa.desenhaDigitoAndador();
        //d.tarefa();
        //d.desenhaDigitos();
        //d.desenha2zeros();
    }
}