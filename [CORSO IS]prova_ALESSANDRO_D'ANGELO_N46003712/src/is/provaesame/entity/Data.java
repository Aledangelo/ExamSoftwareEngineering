package is.provaesame.entity;

import java.time.LocalDate;

public class Data {
	
	private LocalDate data;
	private TipoAula aula;
	private TipoProva prova;

	public Data() {
		this.data = LocalDate.of(0, null, 0);
		this.aula = null;
		this.prova = null;
	}
	
	public Data(LocalDate data, TipoAula aula, TipoProva prova) {
		this.data = data;
		this.aula = aula;
		this.prova = prova;
	}
	
	public void setData(LocalDate d) {
		this.data = d;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public void setAula(TipoAula a) {
		this.aula = a;
	}
	
	public TipoAula getAula() {
		return this.aula;
	}
	
	public void setProva(TipoProva p) {
		this.prova = p;
	}
	
	public TipoProva getProva() {
		return this.prova;
	}
	
	public String toString() {
		return "Data: "+this.data+" Aula: "+this.aula+" Prova: "+this.prova+"\n";
	}

}
