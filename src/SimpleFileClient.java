package redesFinal;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileClient {

	public final static int SOCKET_PORT = 13267; // you may change this
	public final static String SERVER = "localhost"; // localhost
	public final static String FILE_TO_RECEIVED = "\\Users\\nicol\\Desktop\\ImagemSerializedeucetocarai2.ser"; // you

	public final static int FILE_SIZE = 6022386; // file size temporary hard coded
	// should bigger than the file to be downloaded

	public static void main(String[] args) throws IOException {
		
		int bytesRead;
		int current = 0;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		Socket sock = null;
		try {
			sock = new Socket(SERVER, SOCKET_PORT);

			System.out.println("Connecting...");

			// receive file
			byte[] mybytearray = new byte[FILE_SIZE];
			InputStream is = sock.getInputStream();
			fos = new FileOutputStream(FILE_TO_RECEIVED);
			bos = new BufferedOutputStream(fos);
			bytesRead = is.read(mybytearray, 0, mybytearray.length);
			current = bytesRead;

			do {
				bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
				if (bytesRead >= 0)
					current += bytesRead;
			} while (bytesRead > -1);

			bos.write(mybytearray, 0, current);
			bos.flush();
			System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
			HandlerImage.readObject();

		} finally

		{
			if (fos != null)
				fos.close();
			if (bos != null)
				bos.close();
			if (sock != null)
				sock.close();
		}
	}

}
/*
 * try (ServerSocket serverSocket = new ServerSocket(SOCKET_PORT); Socket
 * clientSocket = serverSocket.accept(); PrintWriter out = new
 * PrintWriter(clientSocket.getOutputStream(), true); BufferedReader in = new
 * BufferedReader(new InputStreamReader(System.in));) { String inputLine;
 * System.out.println("Aguardando Mensagem a enviar..."); while ((inputLine =
 * in.readLine()) != null) { System.out.println("Mensagem enviada: " +
 * inputLine); out.println(inputLine);
 * System.out.println("Digite nova mensagem..."); } } catch (IOException e) {
 * System.out.println("Erro detectado ao tentar ouvir a porta " + SOCKET_PORT +
 * " ou escutar a conexão."); System.out.println(e.getMessage()); } }
 */
