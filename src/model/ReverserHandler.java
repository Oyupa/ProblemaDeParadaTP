package model;


public abstract class ReverserHandler implements MaquinaTuningHandler{
    protected String program;
    protected MaquinaTuningHandler siguienteMaquina;

    public ReverserHandler(String program){
        this.program = program;
        this.siguienteMaquina = null;
    }
    public ReverserHandler(String program, MaquinaTuningHandler maquina){
        this(program);
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
