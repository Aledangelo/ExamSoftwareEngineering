package is.provaesame.entity;

public class Studente {

	private String matricola;
	private String nome;
	private String cognome;
	
	public Studente() {
		this.matricola = "";
		this.nome = "";
		this.cognome = "";
	}
	
	public Studente(String mat, String nome, String cognome) {
		this.matricola = mat;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public void setMatricola(String mat) {
		this.matricola = mat;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCognome(String c) {
		this.cognome = c;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String toString() {
		return "Matricola: "+this.matricola+" Nome: "+this.nome+" Cognome: "+this.cognome;
	}

}
