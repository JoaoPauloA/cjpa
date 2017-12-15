package paa;

public class Tarefa implements Comparable<Tarefa>{
	int dia;
	int multa;
	public Tarefa(int i, int j) {
		this.dia = i;
		this.multa = j;
	}
	@Override
	public int compareTo(Tarefa c) {
		if (this.multa < c.multa) return -1;
		if(this.multa > c.multa) return 1;
		return 0;
	}
}
