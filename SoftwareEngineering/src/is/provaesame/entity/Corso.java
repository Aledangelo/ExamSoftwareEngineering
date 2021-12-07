package is.provaesame.entity;

import java.util.LinkedList;

public class Corso {

	private int id;
	private String nome_corso;
	private String nome_docente;
	private int num_crediti;
	LinkedList<Appello> lista_appelli;
	
	public Corso() {
		this.id = 0;
		this.nome_corso = "";
		this.nome_docente = "";
		this.num_crediti = 0;
		this.lista_appelli = new LinkedList<Appello>();
	}

	public Corso(int id, String corso, String docente, int crediti) {
		this.id = id;
		this.nome_corso = corso;
		this.nome_docente = docente;
		this.num_crediti = crediti;
		this.lista_appelli = new LinkedList<Appello>();
	}
	
	public void setNomeCorso(String corso) {
		this.nome_corso = corso;
	}
	
	public String getNomeCorso() {
		return this.nome_corso;
	}
	
	public void setNomeDocente(String docente) {
		this.nome_docente = docente;
	}
	
	public String getNomeDocente() {
		return this.nome_docente;
	}
	
	public void setNumCrediti(int crediti) {
		this.num_crediti = crediti;
	}
	
	public int getNumCrediti() {
		return this.num_crediti;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setAppelli(LinkedList<Appello> appelli) {
		this.lista_appelli = appelli;
	}
	
	public LinkedList<Appello> getAppelli(){
		return this.lista_appelli;
	}
	
	public String toString() {
		return "Codice: "+this.id+" Nome: "+this.nome_corso+" Docente: "+this.nome_docente+" Crediti: "+this.num_crediti+" Appelli: "+this.lista_appelli.toString();
	}
}
