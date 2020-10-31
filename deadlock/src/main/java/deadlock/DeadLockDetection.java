package deadlock;

import java.util.ArrayList;

public class DeadLockDetection {
    
    public static final ArrayList<Processo> processos = new ArrayList<Processo>();
    private static int qtdRecursos=0;
    //public static final ArrayList<String> processos1 = new ArrayList<String>();

    public static void quebraLinha(String linha)
    {   
        String[] linhaSeparada;
        String[] rA = new String[qtdRecursos];
        String[] rR = new String[qtdRecursos];
        boolean separador = false;
        Processo p;

        linhaSeparada = linha.split(" ");

        for (int i = 0, j=0; i<linhaSeparada.length; i++){

            if(linhaSeparada[i].equals(";")){
                separador = true;
            }
            else{
                if(separador == false){   
                    rA[i] = linhaSeparada[i];
                }
                else{
                    rR[j] = linhaSeparada[i];
                    j++;
                }
            }
        }

        p = new Processo(rA,rR);
        processos.add(p);
    }
    
    public static void setQtdRecursos(String str) {
        String[] strB;
        strB = str.split(" ");
        qtdRecursos = Integer.parseInt(strB[1]);
    }
    
    public static void printArray()
    {   
        processos.size();
        //System.out.println(qtdRecursos);
       /* 
        for(int i=0; i<str.length; i++){
            System.out.println(str[i]);
        }
        */
    }
    
}