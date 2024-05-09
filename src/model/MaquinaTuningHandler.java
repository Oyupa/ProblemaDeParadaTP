package model;

import java.util.concurrent.Callable;

public interface MaquinaTuningHandler extends Callable<Boolean> {

    public Boolean call();
    public void setSiguienteMaquina(MaquinaTuningHandler maquina);
}
