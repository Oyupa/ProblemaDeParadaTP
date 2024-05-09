package utils.Analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeAnalyzer  {
    private String code;

    public CodeAnalyzer(String code){
        this.code = code;
    }
    /**
     * Comprueba si el programa tiene un bucle while
     * @return true si el programa tiene un bucle while, false en caso contrario
     */
    public boolean hasWhileLoop(){
        return code.contains("while");
    }

    /**
     * Analiza el programa para comprobar si es un bucle infinito
     * @param lines lineas del programa
     * @param var expresión regular para encontrar un entero
     * @param m matcher
     * @param inputEntero input del programa
     * @return true si el programa es un bucle infinito, false en caso contrario
     */
    public boolean analizar(String[] lines, Pattern var, Matcher m, int inputEntero){
        if (!hasWhileLoop()){                                                       //si el programa no tiene un bucle while se detendra
            return false;
        }
        AnalyzerResult resultado = LoopAnalyzer.analizarBucle(lines, var, m);       //analizamos el bucle
        TipoBucle tipoBucle = resultado.getTipoBucle();
        TipoVariacion tipoVariacion = resultado.getTipoVariacion();
        int objetivo = resultado.getObjetivo();
        return noEsBucleInfinito(tipoBucle,tipoVariacion,objetivo, inputEntero);    //comprobamos si el bucle es infinito
    }
    /**
     * Comprueba si el bucle es infinito
     * @param tipoBucle tipo de bucle
     * @param tipoVariacion tipo de variación
     * @param objetivo objetivo del bucle
     * @param inputEntero input del programa
     * @return true si el bucle es infinito, false en caso contrario
     */
    private static boolean noEsBucleInfinito(TipoBucle tipoBucle,TipoVariacion tipoVariacion, int objetivo, int inputEntero){
        switch (tipoBucle){
            case IGUALQUE:
                if(tipoVariacion == TipoVariacion.CRECIENTE){
                    return inputEntero <= objetivo;
                }else if(tipoVariacion == TipoVariacion.DECRECIENTE){
                    return inputEntero >= objetivo;
                }else{
                    return inputEntero == objetivo;
                }
            case MENORQUE:
                if(tipoVariacion == TipoVariacion.CRECIENTE){
                    return inputEntero < objetivo;
                }else if(tipoVariacion == TipoVariacion.DECRECIENTE){
                    return true;
                }else{
                    return false;
                }
            case MAYORQUE:
                if(tipoVariacion == TipoVariacion.CRECIENTE){
                    return true;
                }else if(tipoVariacion == TipoVariacion.DECRECIENTE){
                    return inputEntero > objetivo;
                }else{
                    return false;
                }
            case OTRO:
                return false;
            default:
                return true;
        }


    }
}
