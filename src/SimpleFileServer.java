package redesFinal;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleFileServer {

	public final static int SOCKET_PORT = 13267; // you may change this
	public final static String FILE_TO_SEND = "\\Users\\nicol\\Desktop\\ImagemSerialize.ser"; // you may change this

	public static void main() throws IOException {
		new Thread(t1).start();
		new Thread(t2).start();
	}
	private static Runnable t1 = new Runnable() {
		public void run() {
			final String SERVER = "localhost";
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			OutputStream os = null;
			ServerSocket servsock = null;
			Socket sock = null;

			try {
				servsock = new ServerSocket(SOCKET_PORT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (true) {
				System.out.println("Waiting...");
				try {
					try {
						sock = servsock.accept();
						System.out.println("Accepted connection : " + sock);
						// send file
						File myFile = new File(FILE_TO_SEND);
						byte[] mybytearray = new byte[(int) myFile.length()];
						fis = new FileInputStream(myFile);
						bis = new BufferedInputStream(fis);
						bis.read(mybytearray, 0, mybytearray.length);
						os = sock.getOutputStream();
						System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
						os.write(mybytearray, 0, mybytearray.length);
						os.flush();

						System.out.println("Done.");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					try {

						if (bis != null)
							bis.close();
						if (os != null)
							os.close();
						if (sock != null)
							sock.close();
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();


					}
				}
			}
		}
	};
	private static Runnable t2 = new Runnable() {
		public void run() {



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
	};


}


