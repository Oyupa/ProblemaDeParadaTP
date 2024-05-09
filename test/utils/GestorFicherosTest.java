package utils;

import static org.junit.jupiter.api.Assertions.*;

class GestorFicherosTest {

        @org.junit.jupiter.api.Test
        void leerFicheroPrograma() {
            String ruta = "ejemplos/FicheroPrueba";
            String programa = GestorFicheros.leerFicheroPrograma(ruta);
            assertEquals("Esto es una prueba para GestorFicherosTest\n", programa);
        }

}