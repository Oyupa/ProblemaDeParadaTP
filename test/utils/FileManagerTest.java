package utils;

import utils.IO.FileManager;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

        @org.junit.jupiter.api.Test
        void leerFicheroPrograma() {
            String ruta = "ejemplos/FicheroPrueba";
            String programa = FileManager.leerFicheroPrograma(ruta);
            assertEquals("Esto es una prueba para FileManagerTest\n", programa);
        }

}