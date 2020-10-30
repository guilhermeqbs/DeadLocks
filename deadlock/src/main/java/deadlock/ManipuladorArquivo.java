package deadlock;

import java.io.*;


public class ManipuladorArquivo {

	public static void leitor(String path) throws IOException {
        
        File arquivo = new File(path);
            
        FileReader fileRead = new FileReader( arquivo );
        
        BufferedReader buffRead = new BufferedReader(fileRead);
        
        String linha = "";
        
		while (true) {
			if (linha != null) {
                
                //Alocamento.listaStr.add(linha);
                
			} else
				break;
			linha = buffRead.readLine();
		}
        buffRead.close();
        fileRead.close();
	}
 

	public static void escritor(String path, int []mf) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        for(int i=0; i<mf.length; i++){
            buffWrite.append(mf[i] + " ");
        }
        buffWrite.close();
	}

}