import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Tarefa implements Comparable<Tarefa> {
	String nome;
	int dia;
	double multa;

	public Tarefa(String nome, int dia, double multa) {
		this.nome = nome;
		this.dia = dia;
		this.multa = multa;
	}

	@Override
	public int compareTo(Tarefa t) {
		if (this.multa < t.multa)
			return -1;
		if (this.multa > t.multa)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ";  entrega o dia " + this.dia + "; com multa: " + this.multa;

	}

}

public class App {
	public static void main(String[] args) {
		Tarefa t1 = new Tarefa("tarefa 1", 2, 120.0);
		Tarefa t2 = new Tarefa("tarefa 2", 1, 200.0);
		Tarefa t3 = new Tarefa("tarefa 3", 2, 100.0);

		List<Tarefa> tarefas = new ArrayList<>();
		tarefas.add(t1);
		tarefas.add(t2);
		tarefas.add(t3);

		System.out.println("tarefas recebidas>>");
		for (Tarefa t : tarefas)
			System.out.println(t.toString());
		System.out.println("---------------------------------------------------");

		Collections.sort(tarefas);

		System.out.println("tarefas ordenadas por multas>>");
		for (Tarefa t : tarefas)
			System.out.println(t.toString());
		System.out.println("---------------------------------------------------");

		System.out.println("Realização das tarefas>>");

		Tarefa[] dias = new Tarefa[tarefas.size()];
		int p, count = 0, index = tarefas.get(tarefas.size() - 1).dia;
		count = 1;
		dias[index - 1] = tarefas.get(tarefas.size() - count);

		while (count < tarefas.size()) {
			count++;
			index = (tarefas.size() - count);
			if (dias[tarefas.get(index).dia - 1] == null) {
				dias[tarefas.get(index).dia - 1] = tarefas.get(index);
			} else {
				p = (tarefas.get(index).dia - 1);
				while (dias[p] != null) {
					if (p == 0)
						p = tarefas.size();
					p--;
				}
				dias[p] = tarefas.get((tarefas.size() - count));
			}

		}
		for (int i = 0; i < tarefas.size(); i++)
			System.out.println(dias[i].nome + " no dia " + (i + 1));

	}

}
