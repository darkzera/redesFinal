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
import java.net.UnknownHostException;

public class SimpleFileClient {

	public static void main(String[] args) {
		
		
		
		
		new Thread(t1).start();
		new Thread(t2).start();

	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			final int SOCKET_PORT = 13267; // you may change this
			final String SERVER = "localhost"; // localhost
			final String FILE_TO_RECEIVED = "\\Users\\nicol\\Desktop\\ImagemSerializedeucetocarai2.ser"; // you

			final int FILE_SIZE = 6022386; // file size temporary hard coded
			// should bigger than the file to be downloaded
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
				Imgreader.main(null);

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally

			{
				try {
					if (fos != null)
						fos.close();

					if (bos != null)
						bos.close();

					if (sock != null)
						sock.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}
	};
	private static Runnable t2 = new Runnable() {
		public void run() {
			final int SOCKET_PORT = 4200; // you may change this

			int portNumber = SOCKET_PORT;

			System.out.println("Servidor ECHO pronto... Pressione CTRL+C para sair. \nAguardando o outro jogador terminar o desenho");
			try (ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);
					Socket clientSocket = serverSocket.accept();
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			) {
				String inputLine;
				System.out.println("Envie sua resposta assim que identificar o desenho...");
				while ((inputLine = in.readLine()) != null) {
					System.out.println("Resposta enviada: " + inputLine);
					out.println(inputLine);
					System.out.println("Digite nova mensagem...");
				}
			} catch (IOException e) {
				System.out.println("Erro detectado ao tentar ouvir a porta " + portNumber + " ou escutar a conexão.");
				System.out.println(e.getMessage());
			}

		}

	};

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
