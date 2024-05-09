package utils.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {


    /**
     * Lee un fichero de texto y devuelve su contenido en un String
     * @param ruta ruta del fichero
     * @return contenido del fichero
     */
    public static String leerFicheroPrograma(String ruta){
        StringBuilder programa = new StringBuilder();
        try {
            File archivo = new File(ruta);
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                programa.append(linea).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return programa.toString();
    }

}
