package is.provaesame.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import is.provaesame.control.gestioneAppelli;
import is.provaesame.control.gestioneCorso;
import is.provaesame.entity.Appello;
import is.provaesame.entity.Corso;
import is.provaesame.entity.Studente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class gestioneAppelliTest {
	
	gestioneCorso gc;
	gestioneAppelli ga;
	
	@Before
	public void setUp() throws Exception{
		ga = new gestioneAppelli(); 
		gc = new gestioneCorso();
	}
	
	@After
	public void tearDown() throws Exception{
		ga = null;
		gc = null;
	}
	
	@Test
	public void test01() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi", 9);
		Appello a1 = ga.creaAppello(c1);
		ga.stampaListaStudentiPrenotati(a1);
		assertEquals(0,a1.getStudenti().size());
	}
	
	@Test
	public void test02() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi", 9);
		Appello a1 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("N46003712","Alessandro","D'Angelo");
		ga.prenotaAppello(s1,a1.getId());
		ga.stampaListaStudentiPrenotati(a1);
		assertEquals(1,a1.getStudenti().size());
	}
	
	@Test
	public void test03() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a1.getId());
		ga.stampaListaStudentiPrenotati(a1);
		assertEquals(2, a1.getStudenti().size());
	}
	
	@Test
	public void test04() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a2.getId());
		ga.stampaListaStudentiPrenotati(a1);
		ga.stampaListaStudentiPrenotati(a2);
		assertEquals(1, a1.getStudenti().size());
		assertEquals(1, a2.getStudenti().size());
	}
	
	@Test
	public void test05() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a1.getId());
		ga.stampaListaStudentiPrenotati(a1);
		ga.stampaListaStudentiPrenotati(a2);
		assertEquals(2, a1.getStudenti().size());
	}
	
	@Test
	public void test06() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		Studente s3= gc.creaStudente("678","Domenico","Iorio");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a1.getId());
		ga.prenotaAppello(s3, a2.getId());
		ga.stampaListaStudentiPrenotati(a1);
		ga.stampaListaStudentiPrenotati(a2);
		assertEquals(2, a1.getStudenti().size());
		assertEquals(1, a2.getStudenti().size());
	}
	
	@Test
	public void test07() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Corso c2 = gc.creaCorso("Fisica 1","Perroni",6);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c2);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a2.getId());
		ga.stampaListaStudentiPrenotati(a1);
		ga.stampaListaStudentiPrenotati(a2);
		assertEquals(1, a1.getStudenti().size());
		assertEquals(1, a2.getStudenti().size());
	}
	
	@Test
	public void test08() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Corso c2 = gc.creaCorso("Fisica 1","Perroni",6);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c2);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s1, a2.getId());
		ga.stampaListaStudentiPrenotati(a1);
		ga.stampaListaStudentiPrenotati(a2);
		assertEquals(1, a1.getStudenti().size());
		assertEquals(1, a2.getStudenti().size());
	}
	
	@Test
	public void test09() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s1, a1.getId());
		ga.stampaListaStudentiPrenotati(a1);
		assertEquals(1, a1.getStudenti().size());
	}
	
	@Test
	public void test10() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		ga.rimuoviAppello(a1,c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		ga.prenotaAppello(s1, a1.getId());
		assertEquals(0, a1.getStudenti().size());
	}
	
	@Test
	public void test11() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Appello a1 = ga.creaAppello(c1);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a1.getId());
		ga.prenotaAppello(s1, a1.getId());
		ga.stampaListaStudentiPrenotati(a1);
		assertEquals(2, a1.getStudenti().size());
	}
	
	@Test
	public void test12() throws Exception{
		Corso c1 = gc.creaCorso("Analisi 1","Baldi",9);
		Corso c2 = gc.creaCorso("Fisica 1","Perroni",6);
		Appello a1 = ga.creaAppello(c1);
		Appello a2 = ga.creaAppello(c2);
		Studente s1 = gc.creaStudente("123","Alessandro","D'angelo");
		Studente s2 = gc.creaStudente("456","Tecla","Perenze");
		Studente s3= gc.creaStudente("678","Domenico","Iorio");
		ga.prenotaAppello(s1, a1.getId());
		ga.prenotaAppello(s2, a1.getId());
		ga.prenotaAppello(s3, a2.getId());
		ga.stampaListaStudentiPrenotati(null);
		assertEquals(2, a1.getStudenti().size());
		assertEquals(1, a2.getStudenti().size());
	}

}
