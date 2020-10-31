package deadlock;

import java.util.ArrayList;

public class DeadLockDetection {
    
    public static final ArrayList<Processo> processos = new ArrayList<Processo>();

    public static ArrayList<String> fon(){
        
        ArrayList<String> resultado = new ArrayList<String>();

        for(int i=0;i<processos.size();i++){
            for(int j=0;j<processos.size();j++){
                for(int k=0;k<processos.get(i).getRecursoRequisitado().length;k++){
                    for(int l=0;l<processos.get(j).getRecursoAlocado().length;l++){
                        if(processos.get(j).getRecursoAlocado().length != 0 && processos.get(i).getRecursoAlocado().length != 0 &&  processos.get(i).getRecursoRequisitado().length != 0 && processos.get(i).getRecursoRequisitado()[k].equals(processos.get(j).getRecursoAlocado()[l])){
                            
                            resultado.add(i+1 + " " + processos.get(i).getRecursoRequisitado()[k]);

                            processos.get(j).setKassino(true);

                            if(processos.get(j).getKassino() == true)
                            {
                               break;
                            }
                            i=j;
                            j=0;
                        }
                    }
                }
            } 
        }
        processos.clear();
        return resultado;
    }


    public static void quebraLinha(String linha)
    {   
        String[] linhaSeparada;
        ArrayList<String> str1 = new ArrayList<String>();
        ArrayList<String> str2 = new ArrayList<String>();

        boolean separador = false;

        linhaSeparada = linha.split(" ");

        for (int i = 0; i<linhaSeparada.length; i++){

            if(linhaSeparada[i].equals(";")){
                separador = true;
            }
            else{
                if(separador == false){   
                    str1.add(linhaSeparada[i]);
                }
                else{
                    str2.add(linhaSeparada[i]);
                }
            }
        }

        criarProcesso(str1,str2);

        str1.clear();
        str1.clear();
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
    
}