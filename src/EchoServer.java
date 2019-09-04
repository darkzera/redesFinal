// Fonte: https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
package redesFinal;
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String args[]) throws IOException {
    	final int SOCKET_PORT = 4200; // you may change this
    	        
        int portNumber = SOCKET_PORT;

        System.out.println("Servidor ECHO pronto... Pressione CTRL+C para sair. \nAguardando o Cliente...");
        try (
            ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String inputLine;
            System.out.println("Aguardando Mensagem a enviar...");
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Mensagem enviada: " + inputLine);
                out.println(inputLine);
                System.out.println("Digite nova mensagem...");
            }
        } catch (IOException e) {
            System.out.println("Erro detectado ao tentar ouvir a porta " + portNumber + " ou escutar a conexão.");
            System.out.println(e.getMessage());
        }
    }
}