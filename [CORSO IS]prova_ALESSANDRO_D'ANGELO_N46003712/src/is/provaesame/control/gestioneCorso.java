package is.provaesame.control;

import java.util.LinkedList;

import is.provaesame.entity.Corso;
import is.provaesame.entity.Studente;

public class gestioneCorso {
	
	LinkedList<Corso> lista_corsi;
	LinkedList<Studente> lista_studenti;

	public gestioneCorso() {
		lista_corsi = new LinkedList<Corso>();
		lista_studenti = new LinkedList<Studente>();
	}
	
	public Corso creaCorso(String corso, String docente, int crediti) {
		Corso c = new Corso(impostaId(),corso,docente,crediti);
		lista_corsi.add(c);
		return c;
	}
	
	public Studente creaStudente(String matricola,String nome,String cognome) {
		Studente s = new Studente(matricola,nome,cognome);
		lista_studenti.add(s);
		return s;
	}
	
	public void rimuoviCorso(Corso c) {
		lista_corsi.remove(c);
	}
	
	public int impostaId() {
		int id = 0;
		for(Corso c : lista_corsi) {
			if(id <= c.getId())
				id = c.getId();
		}
		return id+1;
	}
	
	
	public void rimuoviStudente(Studente s) {
		lista_studenti.remove(s);
	}
	
	public LinkedList<Corso> listaCorsi(){
		return this.lista_corsi;
	}
	
	public void stampaCorsi() {
		if(!this.lista_corsi.isEmpty()) {
			for(Corso c : lista_corsi) {
				System.out.println(c.toString());
			}
		}else {
			System.out.println("Non ci sono corsi.");
		}
	}
	
	public Corso cercaCorso(int id) {
		Corso corso = null;
		for(Corso c : lista_corsi) {
			if(c.getId() == id) {
				corso = c;
				break;
			}
		}
		return corso;
	}

}
