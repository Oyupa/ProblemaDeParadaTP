package model;

import utils.Analyzer.CodeAnalyzer;

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
        Matcher m = null;
        int inputEntero;
        try {
            inputEntero = Integer.parseInt(input);      //convertimos el input a entero
        } catch (NumberFormatException e) {
            return true;                                   //si el input no es un entero el programa se detendra con una excepción
        }
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer(program);     //creamos un CodeAnalyzer para analizar el programa

        return codeAnalyzer.analizar(lines,var,m,inputEntero);

    }


}
