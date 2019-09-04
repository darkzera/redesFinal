package redesFinal;



// Fonte: https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String args[]) throws IOException {
    	final int SOCKET_PORT = 4200; // you may change this
    	final String SERVER = "localhost"; // localhost
    	
       
        String hostName = SERVER;
        int portNumber = SOCKET_PORT;

        System.out.println("Cliente ECHO iniciado...");
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        ) {
            String userInput;
            System.out.println("Conectado ao Servidor.");
            System.out.println("Aguardando mensagem...");
            while ((userInput = in.readLine()) != null) {
                System.out.println("Mensagem recebida: " + userInput);
            }
        } catch (UnknownHostException e) {
            System.err.println("Ocorreu um erro ao tentar conectar ao servidor " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não foi possível conectar ao Servidor " + hostName);
            System.exit(1);
        } 
    }
}