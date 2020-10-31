package deadlock;

import java.util.ArrayList;

public class DeadLockDetection {
    
    public static final ArrayList<Processo> processos = new ArrayList<Processo>();
    private static int qtdRecursos=0;

    public static void fon(){
        boolean stop = false;
        int a=0;
        //System.out.println(processos.get(0).getRecursoRequisitado()[0]);

        for(int i=0;i<processos.size();i++){
            for(int j=0;j<processos.size();j++){
                for(int k=0;k<processos.get(i).getRecursoRequisitado().length;k++){
                    for(int l=0;l<processos.get(j).getRecursoAlocado().length;l++){
                        if((!processos.get(i).getRecursoRequisitado().equals(null) && !processos.get(j).getRecursoAlocado().equals(null)) && processos.get(i).getRecursoRequisitado()[k].equals(processos.get(j).getRecursoAlocado()[l])){
                            System.out.println(i+1 + processos.get(i).getRecursoRequisitado()[k]);
                            
                            if(processos.get(j).getKassino() == true)
                            {
                               break;
                            }
                            processos.get(j).setKassino(true);
                            
                            i=j;
                            j=0;

                        }
                    }
                }
            } 
        }
    }


    public static void quebraLinha(String linha)
    {   
        String[] linhaSeparada;
        ArrayList<String> str1 = new ArrayList<String>();
        ArrayList<String> str2 = new ArrayList<String>();

        boolean separador = false;

        linhaSeparada = linha.split(" ");

        for (int i = 0, j=0; i<linhaSeparada.length; i++){

            if(linhaSeparada[i].equals(";")){
                separador = true;
            }
            else{
                if(separador == false){   
                    str1.add(linhaSeparada[i]);
                }
                else{
                    str2.add(linhaSeparada[i]);
                    j++;
                }
            }
        }

        criarProcesso(str1,str2);
    }

    private static void criarProcesso(ArrayList<String> str1, ArrayList<String> str2){
        Processo p;
        String[] rA = new String[str1.size()];
        String[] rR = new String[str2.size()];
        
        for(int i=0; i<str1.size(); i++){
            rA[i] = str1.get(i);
        }

        for(int i=0; i<str2.size(); i++){
            rR[i] = str2.get(i);
        }

        p = new Processo(rA,rR);
        processos.add(p);
    }
    
    public static void setQtdRecursos(String str) {
        String[] strB;
        strB = str.split(" ");
        qtdRecursos = Integer.parseInt(strB[1]);
    }
    
}