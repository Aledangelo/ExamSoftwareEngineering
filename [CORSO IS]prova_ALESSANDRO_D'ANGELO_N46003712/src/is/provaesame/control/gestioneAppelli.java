package is.provaesame.control;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

import is.provaesame.entity.Appello;
import is.provaesame.entity.Corso;
import is.provaesame.entity.Data;
import is.provaesame.entity.Studente;
import is.provaesame.entity.TipoAula;
import is.provaesame.entity.TipoProva;

public class gestioneAppelli {
	
	LinkedList<Appello> lista_appelli;
	
	public gestioneAppelli() {
		lista_appelli = new LinkedList<Appello>();
	}
	
	public Appello creaAppello(Corso corso) {
		Appello a = new Appello(corso,impostaId());
		corso.getAppelli().add(a);
		lista_appelli.add(a);
		return a;
	}
	
	public void rimuoviAppello(Appello a, Corso c) {
		lista_appelli.remove(a);
		c.getAppelli().remove(a);
	}
	
	public void aggiungiData(Appello a, LocalDate data, TipoAula aula, TipoProva prova) {
		Data d = new Data(data,aula,prova);
		a.getDate().add(d);
	}
	
	public void rimuoviData(Appello a, Data d) {
		a.getDate().remove(d);
	}
	
	public int impostaId() {
		int id = 0;
		for(Appello a : lista_appelli) {
			if(id <= a.getId())
				id = a.getId();
		}
		return id+1;
	}
	
	public void prenotaAppello(Studente studente, int id) {
		Appello a = cercaAppello(id);
		if(a != null) {
			for(Studente s : a.getStudenti()) {
				if(s == studente) {
					System.out.println("Questo studente risulta già prenotato per quest'appello.");
					a.getStudenti().remove(studente);
					break;
				}
			}a.getStudenti().add(studente);
		}else {
			System.out.println("Nessun appello trovato.");
		}
	}
	
	public void annullaPrenotazione(Studente s, Appello a) {
		a.getStudenti().remove(s);
	}
	
	public LinkedList<Studente> visualizzaStudentiPrenotati(Appello a) {
		return a.getStudenti();
	}
	
	public void stampaListaStudentiPrenotati(Appello a) {
		if(a != null) {
			if(!a.getStudenti().isEmpty()) {
				for(Studente s : a.getStudenti()) {
					System.out.println(s.toString());
				}
			}else {
				System.out.println("Non risultao studenti prenotati all'appello.");
			}
		}else {
			for(Appello appello : lista_appelli) {
				System.out.println(appello.toString()+"\n"+appello.getStudenti().toString()+"\n");
			}
		}
	}
	
	
	public LinkedList<Appello> listaAppelli(){
		return this.lista_appelli;
	}
	
	public void stampaListaAppelli() {
		if(!this.lista_appelli.isEmpty()) {
			for(Appello a : lista_appelli) {
				System.out.println(a.toString());
			}
		}else {
			System.out.println("Non ci sono appelli disponibili.");
		}
	}
	
	public Appello cercaAppello(int id) {
		Appello appello = null;
		for(Appello a : lista_appelli) {
			if(a.getId() == id) {
				appello = a;
				break;
			}
		}
		return appello;
	}
	
	public Month controlMonth(int m) {
		Month s;
		switch(m){
		case 1:
			s = Month.JANUARY;
			break;
		case 2:
			s = Month.FEBRUARY;
			break;
		case 3:
			s = Month.MARCH;
			break;
		case 4:
			s = Month.APRIL;
			break;
		case 5:
			s = Month.MAY;
			break;
		case 6:
			s = Month.JUNE;
			break;
		case 7:
			s = Month.JULY;
			break;
		case 8:
			s = Month.AUGUST;
			break;
		case 9:
			s = Month.SEPTEMBER;
			break;
		case 10:
			s = Month.OCTOBER;
			break;
		case 11:
			s = Month.NOVEMBER;
			break;
		case 12:
			s = Month.DECEMBER;
			break;
		default:
			s = null;
		}
		return s;
	}
}
