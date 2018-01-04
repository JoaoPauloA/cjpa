package ufc.cjp.control;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Fachada {
	static int contadora, cont;
	static RandomAccessFile c;

	public Fachada() {
		try {
			this.contadora = countLine();
		} catch (Exception e) {

		}

	}
	public static int count() {
		return contadora;
	}
	public static String[] consultDictionary(String s) throws IOException {
		c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/words.txt", "rw");

		String a = "", b[];
		for (int i = 1; i < contadora; i++) {
			a = c.readLine();
			b = a.split(";");
			if (b[0].equals(s))
				return b;
		}
		return null;
	}

	public static void insertWord(String word, String palavra, String description, Perfil tipo) throws IOException {
		String st = word + ";" + palavra + ";" + description + "\n";
		c.seek(c.length());
		c.writeBytes(st);
		contadora++;
		if (tipo == Perfil.word) {
			c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/words.txt", "rw");
			c.seek(c.length());
			c.writeBytes(st);
		}

	}

	public static void insertWordDictionary(String word, String palavra, String description, Perfil tipo)
			throws IOException {
		c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/dictionary.txt", "rw");
		String st = word + ";" + palavra + ";" + description + "\n";
		c.seek(c.length());
		c.writeBytes(st);
	}

	public static String conversation() throws IOException {
		c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");

		int count = rand();
		String a = "";
		for (int i = 1; i < count; i++) {
			a = c.readLine();
		}
		a = c.readLine();
		return a;
	}

	public static int rand() throws IOException {
		Random a = new Random(System.currentTimeMillis());
		cont = contadora + 1;
		int valor = a.nextInt(cont);
		if (valor == 0)
			return 1;
		return valor;
	}

	public static int countLine() throws IOException {
		c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
		String a;
		int count = 0;
		while (true) {
			a = c.readLine();
			if (a == null)
				break;
			count++;

		}
		return count;
	}
}
