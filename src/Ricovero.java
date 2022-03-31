import java.util.Date;

public class Ricovero {

	private Date dataInizio;
	private Date dataFine;
	private Preventivo preventivo;
	private Paziente paziente;
	@SuppressWarnings("unused")
	private Sconto sconto;	
	private boolean giaPagato;
	public Ricovero(Date dataInizio, Date dataFine, Preventivo preventivo,Paziente paziente) {
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.preventivo = preventivo;
		this.paziente=paziente;		
		this.giaPagato=false;
	}

	
	public boolean isGiaPagato() {
		return giaPagato;
	}


	public void setGiaPagato(boolean giaPagato) {
		this.giaPagato = giaPagato;
	}


	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Preventivo getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(Preventivo preventivo) {
		this.preventivo = preventivo;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	@Override
	public String toString() {
		return "Ricovero [dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", preventivo=" + preventivo
				+ ", paziente=" + paziente + ", sconto=" + sconto + ", giaPagato=" + giaPagato + "]";
	}


	public void setSconto(Sconto s) {
		this.sconto = s;
	}

	public double associaSconto(Sconto s) {
		double totaleScontato = 0;
		setSconto(s);
		totaleScontato = s.calcolaTotaleScontato(this,0);
		return totaleScontato;
	}

	
	
	
	
	
}
