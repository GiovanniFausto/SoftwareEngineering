import java.util.Observable;

public class Reparto extends Observable {

	private int codReparto;
	private int medico;
	private int infermiere;
	private int postidisponibili;
	private String descrizione;
	private Servizio servizio;
	
		
	public Reparto(int codReparto, int medico, int infermiere, int postidisponibili, String descrizione, Servizio servizio) {
		this.codReparto = codReparto;
		this.medico = medico;
		this.infermiere = infermiere;
		if(postidisponibili>0)this.postidisponibili = postidisponibili;
		this.descrizione = descrizione;
		this.servizio=servizio;
	}
	public int getCodReparto() {
		return codReparto;
	}
	public void setCodReparto(int codReparto) {
		this.codReparto = codReparto;
	}
	public int getMedico() {
		return medico;
	}
	public void setMedico(int medico) {
		this.medico = medico;
	}
	public int getInfermiere() {
		return infermiere;
	}
	public void setInfermiere(int infermiere) {
		this.infermiere = infermiere;
	}
	public int getPostidisponibili() {
		return postidisponibili;
	}
	public void setPostidisponibili(int postidisponibili) {
		this.postidisponibili = postidisponibili;
		setChanged();
		notifyObservers();
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Servizio getServizio() {
		return servizio;
	}
	public void setServizio(Servizio servizio) {
		this.servizio = servizio;
	}
	@Override
	public String toString() {
		return "Reparto [codReparto=" + codReparto + ", medico=" + medico + ", infermiere=" + infermiere
				+ ", postidisponibili=" + postidisponibili + ", descrizione=" + descrizione + ", servizio=" + servizio
				+ "]";
	}

	public void incrementaPostiDisponibili(int posti){
			if(posti > 0){
			this.setPostidisponibili(posti + this.getPostidisponibili());
		}
	}
	
	
	public boolean assegnaPostoLetto() {
		//quando assegnamo un posto letto dalla prenotazione ne togliamo uno nel reparto
		if(this.getPostidisponibili()>0) {
			System.out.println("REPARTO: posto assegnato da "+this.descrizione+", ora i posti sono: " + (this.getPostidisponibili()-1) +" prima erano : "+this.getPostidisponibili());
			this.setPostidisponibili(this.getPostidisponibili()-1);	
			return true;
		}
		else {	
			System.out.println("REPARTO: HO PROVATO AD ASSEGNARE POSTO LETTO MA posto non disponibile in "+this.descrizione);
			return false;
		}
	
	}
	
}
