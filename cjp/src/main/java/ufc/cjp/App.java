package ufc.cjp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

import org.xml.sax.ext.LexicalHandler;

public class App {
	static int contadora, cont;

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		contadora = countLine();
		int op;

		do {
			System.out.println("1-Inseir  2-Conversation  3-print count");
			op = s.nextInt();

			switch (op) {
			case 1:
				insertWord();
				break;

			case 2:
				conversation();
				break;
				
			case 3:
				printCount();
				break;

			case 0:
				System.out.println("Obrigado!!!");
				break;

			default:
				System.out.println("Opção inválida.");
			}
		} while (op != 0);

	}

	public static void conversation() throws IOException {
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");

		Scanner s = new Scanner(System.in);
		String a, st;
		String[] b;
		int count = rand();
		for (int i = 1; i < count; i++) {
			c.readLine();
		}
		a = c.readLine();
		b = a.split(";");
		System.out.println(">>> " + b[0]);
		st = s.nextLine();
		if (st.equals(b[1]))
			System.out.println("ok");
		else
			System.out.println("não desista!");
	}

	public static void insertWord() throws IOException {
		Scanner s = new Scanner(System.in);
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");

		String st;
		System.out.println("informe a palavra ou frase a ser inserida");
		st = s.next() + ";";
		System.out.println("resposta em português");
		st += s.next() + ";";
		System.out.println("Descrição");
		st += s.next();
		st += "\n";

		c.seek(c.length());
		c.writeBytes(st);
		contadora++;

	}

	public static int rand() throws IOException {
		Random a = new Random(System.currentTimeMillis());
		cont = contadora+1;
		int valor = a.nextInt(cont);
		if (valor == 0)
			return 1;
		return valor;
	}

	public static int countLine() throws IOException {
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
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
	public static void printCount() {
		System.out.println(contadora);
	}

}