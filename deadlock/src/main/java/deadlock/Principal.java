package deadlock;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Principal {
    public static void main(String[] args) throws IOException
    {
        String leitura = "entrada.txt";
        String escrita = "saida.txt";

        ManipuladorArquivo.leitor(leitura);

        DeadLockDetection.fon();
        
    }
}
