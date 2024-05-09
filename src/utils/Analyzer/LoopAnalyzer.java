package utils.Analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoopAnalyzer {

        public static int encontrarConstante(String linea, Pattern var, Matcher m){
                m=var.matcher(linea);
                m.find();
                return Integer.parseInt(m.group());
        }
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
