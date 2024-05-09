package model;

import static java.lang.Thread.sleep;

public class Reverser extends ReverserHandler  {

    public Reverser(String program) {
        super(program);
    }
    public Reverser(String program, MaquinaTuningHandler maquina) {
        super(program, maquina);
    }


    /**
     * Llama a model.HaltChecker y devuelve el resultado invertido
     * @return true si el programa no se detiene, bucle infinito en caso contrario
     */

    @Override
    public Boolean call() {
        setSiguienteMaquina(new HaltChecker(program, program));
        boolean halt = this.siguienteMaquina.call();
        if (!halt) {
            return true;
        }
        while (halt) {
            try {
                sleep(5000);                       //esto simula un bucle infinito
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            halt = false;                               //esto hace que el bucle se detenga pero en el problema de parada habría que eliminarlo
        }
        return halt;
    }
}
