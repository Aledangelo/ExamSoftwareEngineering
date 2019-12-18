package is.provaesame.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;

import is.provaesame.control.gestioneAppelli;
import is.provaesame.control.gestioneCorso;
import is.provaesame.entity.Appello;
import is.provaesame.entity.Corso;
import is.provaesame.entity.Data;
import is.provaesame.entity.Studente;
import is.provaesame.entity.TipoAula;
import is.provaesame.entity.TipoProva;

public class main {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(input);
		
		gestioneAppelli ga = new gestioneAppelli();
		gestioneCorso gc = new gestioneCorso();
		
		String s;
		char ch;
		int num;
		
		do {
			System.out.println("Scegli una delle seguenti opzioni:\n"
					+ "1 - Usa come Docente\n"
					+ "2 - Usa come Studente\n"
					+ "3 - Usa come Addetto alla segreteria\n"
					+ "0 - Exit");
			num = Integer.parseInt(buffer.readLine().trim());
			switch(num) {
			case 1:
				do {
					System.out.println("Scegliere una delle seguenti opzioni:\n"
							+ "a - Aggiungi appello\n"
							+ "l - Visualizza una lista degli studenti prenotati\n"
							+ "i - Indietro");
					s = (buffer.readLine()).toLowerCase().trim();
					ch = s.charAt(0);
					switch(ch) {
					case 'a':
						System.out.println("Scegliere un corso:\n");
						gc.stampaCorsi();
						if(!gc.listaCorsi().isEmpty()) {
							System.out.println("Inserire l'Id del corso del quale si vuole creare l'appello.");
							num = Integer.parseInt(buffer.readLine().trim());
							Corso c = gc.cercaCorso(num);
							if(c != null) {
								int id;
								System.out.println("Creazione appello...");
								Appello a = ga.creaAppello(c);
								int opt;
								do {
									System.out.println("Scegliere una delle seguenti opzioni:\n"
											+ "1 - Inserisci data\n"
											+ "0 - Termina");
									opt = Integer.parseInt(buffer.readLine().trim());
									switch(opt) {
									case 1:
										int anno;
										int giorno;
										int mese;
										TipoProva tp = null;
										TipoAula ta = null;
										boolean x = false;
										boolean y = false;
										System.out.println("Inserire la data.\nAnno:");
										anno = Integer.parseInt(buffer.readLine().trim());
										System.out.println("Mese (numerico):");
										mese = Integer.parseInt(buffer.readLine().trim());
										System.out.println("Giorno (numerico):");
										giorno = Integer.parseInt(buffer.readLine().trim());
										do {
											System.out.println("Scegliere una delle seguenti opzioni:\n"
													+ "s - Prova scritta\n"
													+ "o - Prova orale\n"
													+ "c - Prova al calcolatore");
											s = (buffer.readLine()).toLowerCase().trim();
											ch = s.charAt(0);
											switch(ch) {
											case 's':
												tp = TipoProva.SCRITTA;
												x = true;
												break;
											case 'o':
												tp = TipoProva.ORALE;
												x = true;
												break;
											case 'c':
												tp = TipoProva.CALCOLATORE;
												x = true;
												break;
											default:
												System.out.println("Opzione no valida.");
												break;
											}
										}while(x == false);
										do {
											System.out.println("Scegliere una delle seguenti opzioni:\n"
													+ "a - Aula\n"
													+ "l - Laboratorio");
											s = (buffer.readLine()).toLowerCase().trim();
											ch = s.charAt(0);
											switch(ch) {
											case 'a':
												ta = TipoAula.AULA;
												y = true;
												break;
											case 'l':
												ta = TipoAula.LABORATORIO;
												y = true;
												break;
											default:
												System.out.println("Opzione non valida.");
												break;
											}
										}while(y == false);
										ga.aggiungiData(a,LocalDate.of(anno,ga.controlMonth(mese),giorno),ta,tp);
										break;
									case 0:
										System.out.println("Exit");
										break;
									default:
										System.out.println("Opzione non valida.");
										break;
									}
								}while(opt != 0);
								System.out.println("Appello salvato correttamente.");
							}else {
								System.out.println("ID non valido.");
							}
						}
						break;
					case 'l':
						System.out.println("Inserire l'ID dell'appello di cui si desidera vedere gli studenti prenotati.");
						ga.stampaListaAppelli();
						if(!ga.listaAppelli().isEmpty()) {
							num = Integer.parseInt(buffer.readLine().trim());
							Appello a = ga.cercaAppello(num);
							if(a != null) {
								ga.stampaListaStudentiPrenotati(a);;
							}else {
								System.out.println("ID non valido.");
							}
						}
						break;
					case 'i':
						System.out.println("Indietro.");
						break;
					default:
						System.out.println("Opzione non valida.");
						break;
					}
				}while(ch!='i');
				break;
			case 2:
				do {
					System.out.println("Scegliere una delle seguenti opzioni:\n"
							+ "p - Prenota appello\n"
							+ "i - indietro");
					s = (buffer.readLine()).toLowerCase().trim();
					ch = s.charAt(0);
					switch(ch) {
					case 'p':
						String mat;
						String nome;
						String cognome;
						System.out.println("Inserire la matricola.");
						mat = (buffer.readLine()).toLowerCase().trim();
						System.out.println("Inserire il nome.");
						nome = (buffer.readLine()).toLowerCase().trim();
						System.out.println("Inserire il cognome.");
						cognome = (buffer.readLine()).toLowerCase().trim();
						Studente stud = gc.creaStudente(mat, nome, cognome);
						ga.stampaListaAppelli();
						if(!ga.listaAppelli().isEmpty()) {
							System.out.println("Inserire l'ID dell'appello da prenotare.");
							num = Integer.parseInt(buffer.readLine().trim());
							ga.prenotaAppello(stud, num);
							}
						break;
					case 'i':
						System.out.println("Indietro");
						break;
					default:
						System.out.println("Opzione non valida.");
						break;
					}
				}while(ch != 'i');
				break;
			case 3:
				do {
					System.out.println("Scegliere una delle seguenti:\n"
							+ "c - Crea corso\n"
							+ "i - Indietro");
					s = (buffer.readLine()).toLowerCase().trim();
					ch = s.charAt(0);
					switch(ch){
					case 'c':
						int id;
						String docente;
						String nome;
						int cfu;
						System.out.println("Inserire il nome del docente.");
						docente = (buffer.readLine()).toLowerCase().trim();
						System.out.println("Inserire il nome del corso.");
						nome = (buffer.readLine()).toLowerCase().trim();
						System.out.println("Inserire il numero di creaditi.");
						cfu = Integer.parseInt(buffer.readLine().trim());
						gc.creaCorso(nome,docente,cfu);
						System.out.println("Corso creato correttamente.");
						break;
					case 'i':
						System.out.println("Indietro");
						break;
					default:
						System.out.println("Opzione non valida.");
						break;
					}
					
				}while(ch != 'i');
				break;
			case 0:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Opzione non valida.");
				break;
			}
			
			
		}while(num != 0);

	}

}
