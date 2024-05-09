package utils.Analyzer;

public class AnalyzerResult {
    private TipoBucle tipoBucle;
    private TipoVariacion tipoVariacion;
    private int objetivo;

    public AnalyzerResult() {
        this.tipoBucle = null;
        this.tipoVariacion = TipoVariacion.NULA;
        this.objetivo = 0;
    }

    public TipoBucle getTipoBucle() {
        return tipoBucle;
    }

    public void setTipoBucle(TipoBucle tipoBucle) {
        this.tipoBucle = tipoBucle;
    }

    public TipoVariacion getTipoVariacion() {
        return tipoVariacion;
    }

    public void setTipoVariacion(TipoVariacion tipoVariacion) {
        this.tipoVariacion = tipoVariacion;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }
}