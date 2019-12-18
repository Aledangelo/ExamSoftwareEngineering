package is.provaesame.entity;

import java.util.LinkedList;

public class Appello {

	private int id;
	private String nome_appello;
	LinkedList<Data> date_appello;
	LinkedList<Studente> studenti_prenotati;
	private boolean finito = false;
	
	
	public Appello() {
		this.id = 0;
		this.nome_appello = "";
		this.date_appello = new LinkedList<Data>();
		this.studenti_prenotati = new LinkedList<Studente>();
	}
	
	public Appello(Corso c, int id) {
		this.id = id;
		this.nome_appello = c.getNomeCorso();
		this.date_appello = new LinkedList<Data>();
		this.studenti_prenotati = new LinkedList<Studente>();
	}
	
	public void setNome(String nome) {
		this.nome_appello = nome;
	}
	
	public String getNome() {
		return this.nome_appello;
	}
	
	public LinkedList<Data> getDate(){
		return this.date_appello;
	}
	
	public void setStato(boolean x) {
		this.finito = x;
	}
	
	public boolean getStato() {
		return this.finito;
	}
	
	public LinkedList<Studente> getStudenti(){
		return this.studenti_prenotati;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return "Codice: "+this.id+" Nome: "+this.nome_appello+" "+this.date_appello.toString();
	}
}
