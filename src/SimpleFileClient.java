import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class SimpleFileClient {

    public final static int SOCKET_PORT = 13267;      // you may change this
    //public final static String SERVER = "127.0.0.1";  // localhost
    public final static String SERVER = "192.168.0.105";
    public final static String
            FILE_TO_RECEIVED = "/home/darkzera/testePravc/segunda.ser";  // you may change this, I give a
    // different name because i don't want to
    // overwrite the one used by server...

    public final static int FILE_SIZE = 6022386; // file size temporary hard coded
    // should bigger than the file to be downloaded

    public static void main (String [] args ) throws IOException {
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket(SERVER, SOCKET_PORT);
            System.out.println("Connecting...");
            // receive file
            byte [] mybytearray  = new byte [FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVED);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;
            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);

            bos.write(mybytearray, 0 , current);
            bos.flush();
            System.out.println("File " + FILE_TO_RECEIVED
                    + " downloaded (" + current + " bytes read)");
            readObject();
        }
        finally {
            if (fos != null) fos.close();
            if (bos != null) bos.close();
            if (sock != null) sock.close();
        }
    }
           public static void readObject(){
            try {
                FileInputStream fin = new FileInputStream("/home/darkzera/testePravc/segunda.ser");
                String dirName="/home/darkzera/";
                ObjectInputStream ois = new ObjectInputStream(fin);
                byte[] teste = (byte[]) ois.readObject();
                BufferedImage imag = ImageIO.read(new ByteArrayInputStream(teste));
                ImageIO.write(imag, "PNG", new File(dirName,"ImagemRetornando.png"));
                System.out.println("Salvou em " +dirName);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }



}