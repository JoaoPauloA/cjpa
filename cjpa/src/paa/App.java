package paa;

import java.util.ArrayList;
import java.util.Collections;

import paa.Tarefa;
public class App{
	public static void main(String[] args) {
	    Tarefa t1 = new Tarefa(13,13);
	    Tarefa t2 = new Tarefa(12,1);
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		tarefas.add(t1);
		tarefas.add(t2);
		Collections.sort(tarefas);
		
		for(Tarefa t: tarefas){
			System.out.println(t.dia);
			
		}
	} 

}
