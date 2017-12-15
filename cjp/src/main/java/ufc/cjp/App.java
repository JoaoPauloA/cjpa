package ufc.cjp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import org.xml.sax.ext.LexicalHandler;

public class App {
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int op;
		
		do{
            System.out.println("1-Inseir  2-Conversation");
            op = s.nextInt();
            
            switch(op){
            case 1:
               insertWord();
                break;
                
            case 2:
                readLines();
                break;
            
            case 0:
            	System.out.println("Obrigado!!!");
            	break;
                
                default:
                System.out.println("Opção inválida.");
            }
        } while(op != 0);
	}

	public static void readLines() throws IOException {
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
		
		Scanner s = new Scanner(System.in);
		String a,st;
		String[] b;
		System.out.println("buscar");
		st = s.nextLine();
		
		while (true) {
			a = c.readLine();
			if (a == null) {
				System.out.println("não existe no vocabulário");
				break;
			}
			b = a.split(";");
			if (b[0].equals(st)) {
				System.out.println("resposta");
				System.out.println(b[1]);
				break;
			}

		}

	}
	
	
	public static void insertWord()throws IOException {
		Scanner s = new Scanner(System.in);
		RandomAccessFile c = new RandomAccessFile("/home/joaopaulo/Documentos/AppEnglish/exemplo.txt", "rw");
		String st;
		System.out.println("informe a palavra ou frase a ser inserida");
		st = s.nextLine()+";";
		System.out.println("resposta em português");
		st+= s.nextLine();
		st+="\n";
		
		c.seek(c.length());
		c.writeBytes(st);
		
				
	}

}