package ufc.cjp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

import org.xml.sax.ext.LexicalHandler;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int op;

		do {
			System.out.println("1-Inseir  2-Conversation");
			op = s.nextInt();

			switch (op) {
			case 1:
				insertWord();
				break;

			case 2:
				conversation();
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
		System.out.println(rand());;
		
		
	

	}

	public static void insertWord() throws IOException {
		Scanner s = new Scanner(System.in);
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
				
		String st;
		System.out.println("informe a palavra ou frase a ser inserida");
		st = s.nextLine() + ";";
		System.out.println("resposta em português");
		st += s.nextLine();
		st += "\n";
		
		c.seek(c.length());
		c.writeBytes(st);
			
	}
	
	public static int rand() throws IOException {
		Random a = new Random(System.currentTimeMillis());
			System.out.println("count line = "+countLine());
		int valor = a.nextInt(countLine()+1);
		if(valor == 0)
			return 1;
		return valor;
	}
	
	
	
	public static int countLine()throws IOException{
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
		String a;
		int count = 0;
		while(true){
			a = c.readLine();
			if(a == null)
				break;
			count++;
			
		}
		return count;
	}
	

}