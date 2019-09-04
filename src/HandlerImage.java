package redesFinal;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

public class HandlerImage {
	public static void writeObject(byte[] bs) {
		try{

			/*
			 * A Classe FileOutputStream � respons�vel por criar
			 * o arquivo fisicamente no disco, assim poderemos realizar a 
			 * escrita neste. 
			 * */
			FileOutputStream fout = new FileOutputStream("\\Users\\nicol\\Desktop\\ImagemSerialize.ser");

			/*
			 * A Classe ObjectOutputStream escreve os objetos no FileOutputStream
			 * */
			ObjectOutputStream oos = new ObjectOutputStream(fout);   

			/*
			 * Veja aqui a m�gica ocorrendo: Estamos gravando um objeto 
			 * do tipo Address no arquivo address.ser. Aten��o: O nosso 
			 * objeto Address que est� sendo gravado, j� � gravado de forma 
			 * serializada
			 * */
			oos.writeObject(bs);

			oos.close();
			System.out.println("Done, agora serializou o vetor de byte");

		}catch(Exception ex){
			ex.printStackTrace();
		} 
	}


		public static void readObject(){


			try{

				/*
				 * Respons�vel por carregar o arquivo ImagemSerialize.ser
				 * */
				FileInputStream fin = new FileInputStream("\\Users\\nicol\\Desktop\\ImagemSerialize.ser");

				String dirName="\\Users\\nicol\\Desktop"; 
				/*
				 * Respons�vel por ler o objeto referente ao arquivo
				 * */
				ObjectInputStream ois = new ObjectInputStream(fin);

				/*
				 * Aqui a m�gica � feita, onde os bytes presentes no arquivo address.ser
				 * s�o convertidos em uma inst�ncia de Address.
				 * */
				byte[] teste = (byte[]) ois.readObject();
				BufferedImage imag = ImageIO.read(new ByteArrayInputStream(teste));
				ImageIO.write(imag, "PNG", new File(dirName,"ImagemRetornando.png"));
				System.out.println("Salvou em " +dirName);

			}catch(Exception ex){
				ex.printStackTrace(); 
			} 

	}

	public static byte[] writeImage(BufferedImage imagem, String formato) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(imagem, formato, bos);
		bos.flush();
		System.out.println("entrou em tudo carai, transformou a imagem em um vetor de byte");
		return bos.toByteArray();
	}

}


