package utils.Analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoopAnalyzer {

        /**
         * Método que analiza una línea de código y devuelve un entero que representa el valor objetivo del bucle
         * @param linea línea del programa
         * @param var expresión regular para encontrar un entero
         * @param m matcher
         * @return entero que representa el valor objetivo del bucle
         */
        public static int encontrarConstante(String linea, Pattern var, Matcher m){
                m=var.matcher(linea);
                m.find();
                return Integer.parseInt(m.group());
        }
        /**
         * Método que analiza un bucle y devuelve un objeto AnalyzerResult con la información obtenida
         * @param lineas lineas del bucle
         * @param var expresión regular para encontrar un entero
         * @param m matcher
         * @return objeto AnalyzerResult con la información obtenida
         */
        public static AnalyzerResult analizarBucle(String[] lineas, Pattern var, Matcher m){
                AnalyzerResult result = new AnalyzerResult();
                for (String linea : lineas){
                        if (linea.contains("while")) {                  //por simplicidad unicamente comprobaremos los bucles while
                                                                        //sin embargo para mejorar el programa habria que comprobar todos los tipos de bucle
                                result.setObjetivo(encontrarConstante(linea, var, m));        //obtenemos el valor objetivo del bucle
                                if (linea.contains("=")) {
                                        result.setTipoBucle(TipoBucle.IGUALQUE);
                                } else if (linea.contains("<")) {
                                        result.setTipoBucle(TipoBucle.MENORQUE);
                                } else if (linea.contains(">")) {
                                        result.setTipoBucle(TipoBucle.MAYORQUE);
                                } else {
                                        result.setTipoBucle(TipoBucle.OTRO);
                                }
                        }
                        if (linea.matches("\\s*((\\w+ *= *\\w+ *\\+ *\\d+)|(\\w+ *\\+= *\\d+)|(\\w+\\+\\+)|(\\+\\+\\w*));*")) {
                                result.setTipoVariacion(TipoVariacion.CRECIENTE);
                        } else if (linea.matches("\\s*((\\w+ *= *\\w+ *- *\\d+)|(\\w+ *-= *\\d+)|(\\w+--)|(--\\w*));*")) {
                                result.setTipoVariacion(TipoVariacion.DECRECIENTE);
                        }
                }
                return result;
        }
}
