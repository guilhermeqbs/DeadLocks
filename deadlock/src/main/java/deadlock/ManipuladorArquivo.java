package deadlock;

import java.io.*;
import java.util.ArrayList;


public class ManipuladorArquivo {

	public static void leitor(String path) throws IOException {
        
        File arquivo = new File(path);
            
        FileReader fileRead = new FileReader( arquivo );
        
        BufferedReader buffRead = new BufferedReader(fileRead);
        
        String linha = "";
        int i=0;

		while (true) {
			if (linha != null) {
                if(i==1){
                    //DeadLockDetection.setQtdRecursos(linha);
                }else if(i>1)
                {
                    DeadLockDetection.quebraLinha(linha);
                }
                i++;
            }else
                break;
            linha = buffRead.readLine();
		}
        buffRead.close();
        fileRead.close();
	}
    
	public static void escritor(String path, ArrayList<String> list) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

        for(int i=0; i<list.size(); i++){
            buffWrite.append(list.get(i));
            if(i<list.size()-1)
            {
                buffWrite.append(" ");
            }
        }
        list.clear();
        buffWrite.close();
	}

}