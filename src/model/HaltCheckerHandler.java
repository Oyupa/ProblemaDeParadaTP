package model;

public abstract class HaltCheckerHandler implements MaquinaTuningHandler {
    protected String program;
    protected String input;
    protected MaquinaTuningHandler siguienteMaquina;

    public HaltCheckerHandler(String program, String input){
        this.program = program;
        this.input = input;
        this.siguienteMaquina = null;
    }
    public HaltCheckerHandler(String program, String input, MaquinaTuningHandler maquina){
        this(program, input);
        this.siguienteMaquina = maquina;
    }
    @Override
    public void setSiguienteMaquina(MaquinaTuningHandler maquina) {
        this.siguienteMaquina = maquina;
    }
    @Override
    public Boolean call() {
        return false;
    }
}
