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
<<<<<<< HEAD
		
		final String SERVER = "localhost";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket servsock = null;
		Socket sock = null;

		servsock = new ServerSocket(SOCKET_PORT);
		while (true) {
			System.out.println("Waiting...");
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
				

			} finally {
				if (bis != null)
					bis.close();
				if (os != null)
					os.close();
				if (sock != null)
					sock.close();
			}
		}
	}
=======
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
					} catch (IOException e) {
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
			final String SERVER = "localhost"; // localhost

			String hostName = SERVER;
			int portNumber = SOCKET_PORT;

			System.out.println("Cliente ECHO iniciado...");
			try (Socket echoSocket = new Socket(hostName, portNumber);
					BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));) {
				String userInput;
				System.out.println("Conectado ao Servidor.");
				System.out.println("Aguardando resposta do outro jogador...");
				while ((userInput = in.readLine()) != null) {
					System.out.println("Resposta recebida: " + userInput);
				}
			} catch (UnknownHostException e) {
				System.err.println("Ocorreu um erro ao tentar conectar ao servidor " + hostName);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Não foi possível conectar ao Servidor " + hostName);
				System.exit(1);
			}
		}
	};
>>>>>>> master

}
