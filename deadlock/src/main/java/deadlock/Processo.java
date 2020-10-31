package deadlock;

public class Processo {
    
    private String[] recursoAlocado;
    private String[] recursoRequisitado;
    private boolean kassino= false;

    public Processo(String[] recursoAlocado, String[] recursoRequisitado) {
        this.recursoAlocado = recursoAlocado;
        this.recursoRequisitado = recursoRequisitado;

    }
    public Processo(){}

    public String[] getRecursoAlocado() {
        return recursoAlocado;
    }
    public String[] getRecursoRequisitado() {
        return recursoRequisitado;
    }
    public boolean getKassino() {
        return kassino;
    }
    public void setKassino(boolean kassino) {
        this.kassino = kassino;
    }
}
