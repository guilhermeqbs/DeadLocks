package deadlock;

public class Processo {
    
    private String[] recursoAlocado;
    private String[] recursoRequisitado;

    public Processo(String[] recursoAlocado, String[] recursoRequisitado) {
        this.recursoAlocado = recursoAlocado;
        this.recursoRequisitado = recursoRequisitado;
    }
    public Processo(){}

    public void setRecursoAlocado(String str) {
        this.recursoAlocado = recursoAlocado;
    }

   public String[] getRecursoAlocado() {
       return recursoAlocado;
   }

  

}
