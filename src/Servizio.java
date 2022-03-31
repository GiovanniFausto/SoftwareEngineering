

public class Servizio {

	private int codiceServizio;
	private int medico;
	private String tipo;
	private double prezzo;
	private String descrizione;
	
	
	public Servizio(int codiceServizio, int medico, String tipo, double prezzo, String descrizione) {
		
		this.codiceServizio = codiceServizio;
		this.medico = medico;
		this.tipo = tipo;
		if(prezzo>=0)this.prezzo = prezzo;
		this.descrizione = descrizione;
	}
	
	public int getCodiceServizio() {
		return codiceServizio;
	}

	public void setCodiceServizio(int codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Servizio [codiceServizio=" + codiceServizio + ", medico=" + medico + ", tipo=" + tipo + ", prezzo="
				+ prezzo + ", descrizione=" + descrizione + "]";
	}
	
}
