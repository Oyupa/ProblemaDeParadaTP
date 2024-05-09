package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HaltChecker extends HaltCheckerHandler {

    public HaltChecker(String program, String input){
        super(program, input);
    }

    public HaltChecker(String program, String input, MaquinaTuningHandler maquina){
        super(program, input, maquina);
    }

    /**
     * Comprueba si el programa se detiene con el input dado
     * @return true si el programa se detiene, false en caso contrario
     */
    @Override
    public Boolean call(){
        String[] lines = program.split("\n");      //separamos el programa en lineas
        Pattern var = Pattern.compile("-?\\d+");        //expresión regular para encontrar un entero
        Matcher m;
        int i = 0;
        int inputEntero;
        try {
            inputEntero = Integer.parseInt(input);      //convertimos el input a entero
        } catch (NumberFormatException e) {
            return true;                                   //si el input no es un entero el programa se detendra con una excepción
        }
        boolean menorQue=false;                         //nos servira para saber si el bucle es de tipo while(i<10) o while(i>10)
        boolean incremento=false;                       //nos servira para saber si el bucle incrementa la variable
        boolean decremento=false;                       //nos servira para saber si el bucle decrementa la variable
        boolean hayBucle = false;                       //nos servira para saber si hay algun bucle en el programa
        for (String line : lines){
            if (line.contains("while")) {               //por simplicidad unicamente comprobaremos los bucles while
                                                        //sin embargo para mejorar el programa habria que comprobar todos los tipos de bucle
                hayBucle=true;
                m=var.matcher(line);
                m.find();
                i = Integer.parseInt(m.group());        //obtenemos el valor objetivo del bucle
                menorQue= line.contains("<");
            }
            if (line.matches("\\s*((\\w+ *= *\\w+ *\\+ *\\d+)|(\\w+ *\\+= *\\d+)|(\\w+\\+\\+)|(\\+\\+\\w*));*")){
                incremento=true;
            }
            if (line.matches("\\s*((\\w+ *= *\\w+ *- *\\d+)|(\\w+ *-= *\\d+)|(\\w+--)|(--\\w*));*")){
                decremento=true;
            }
        }
        if (hayBucle) {
            if (menorQue && incremento) {               //si el bucle es de tipo while(j<10) y la variable incrementa entonces si el input es menor que i el programa no se detendra
                return inputEntero < i;
            } else if (menorQue && decremento) {        //si el bucle es de tipo while(j<10) y la variable decrementa entonces siempre se detendra
                return true;
            } else if (!menorQue && incremento) {       //si el bucle es de tipo while(j>10) y la variable incrementa entonces siempre se detendra
                return true;
            } else if (!menorQue && decremento) {       //si el bucle es de tipo while(j>10) y la variable decrementa entonces si el input es mayor que i el programa no se detendra
                return inputEntero > i;
            } else {
                return false;                           //si la variable no incrementa ni decrementa no podemos saber si el programa se detendra
            }
        } else {
            return true;                                //si no hay bucles el programa siempre se detendra
        }

    }


}
