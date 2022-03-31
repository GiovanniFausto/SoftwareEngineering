import java.util.Date;

public class Paziente {

	private int CF;
	private String nome;
	private String cognome;
	private Date dataRegistrazione;
	private int eta;
	private int percentualeInvalidita;

	public Paziente() {};
	public Paziente(int cF, String nome, String cognome, Date dataRegistrazione, int eta, int percentualeInvalidita) {
		this.CF = cF;
		this.nome = nome;
		this.cognome = cognome;
		this.dataRegistrazione = dataRegistrazione;
		if(eta>0 && eta<120)this.eta = eta;
		this.percentualeInvalidita = percentualeInvalidita;
	}

	public int getCF() {
		return CF;
	}

	public void setCF(int cF) {
		CF = cF;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getPercentualeInvalidita() {
		return percentualeInvalidita;
	}
	public void setPercentualeInvalidita(int percentualeInvalidita) {
		this.percentualeInvalidita = percentualeInvalidita;
	}
	@Override
	public String toString() {
		return "Paziente [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + ", dataRegistrazione="
				+ dataRegistrazione + ", eta=" + eta + ", percentualeInvalidita=" + percentualeInvalidita + "]";
	}

	
	
	
}
