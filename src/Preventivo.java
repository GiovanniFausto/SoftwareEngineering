import java.util.ArrayList;

public class Preventivo {

	//ci dirà solo il costo dei servizio totali
	private double totalePrezzo;
	private int numero;
	private ArrayList<Servizio> servizi;

	public Preventivo( int numero, ArrayList<Servizio> servizi) {
		
		this.numero = numero;
		this.servizi = servizi;
		this.calcolaTotale();
	}

	public double getTotalePrezzo() {
		return totalePrezzo;
	}

	public void setTotalePrezzo(double totalePrezzo) {
		this.totalePrezzo = totalePrezzo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(ArrayList<Servizio> servizi) {
		this.servizi = servizi;
	}


	@Override
	public String toString() {
		return "Preventivo [totalePrezzo=" + totalePrezzo + ", numero=" + numero + ", servizi=" + servizi + "]";
	}
	
	//setta il prezzo totale dei servizi del preventivo
	public double calcolaTotale() {
		double tot=0;
		for(int i=0; i<servizi.size();i++) {
			if(servizi.get(i).getPrezzo()>=0) {
			tot=tot+servizi.get(i).getPrezzo();}
		}
		this.setTotalePrezzo(tot);
		return tot;
	}
	
}
