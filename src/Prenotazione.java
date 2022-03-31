import java.util.Observable;
import java.util.Observer;

public class Prenotazione implements Observer {

	private int idPrenotazione;
	private Paziente paziente;
	private Reparto reparto;
	private boolean prenotato;
	
	public Prenotazione(int idPrenotazione, Paziente paziente, Reparto reparto, boolean prenotato) {
		this.idPrenotazione = idPrenotazione;
		this.paziente = paziente;
		this.reparto = reparto;
		this.reparto.addObserver(this);
		this.prenotato=prenotato;
		if(prenotato) {
			reparto.assegnaPostoLetto();	
		}else { System.err.println("PRENOTAZIONE : "+this.idPrenotazione+" da assegnare posto letto in "+ this.reparto.getDescrizione()+" a paziente "+ this.paziente.getNome());}
	}
	
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Reparto getReparto() {
		return reparto;
	}
	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}
	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", paziente=" + paziente + ", reparto=" + reparto
				+ ", prenotato=" + prenotato + "]";
	}

	public boolean aggiornaPrenotazione() { // richiamata se prenotato era falso 
		boolean controlla=false;
		controlla=this.reparto.assegnaPostoLetto();// controllo se è assegnato il posto letto perchè magari non ci sono posti
		if(controlla) {
			System.out.println("PRENOTAZIONE: "+this.idPrenotazione+" AGGIORNATA posto assegnato a  "+this.paziente.getNome()+" in reparto "+this.getReparto().getDescrizione());
			this.prenotato=true;
		}
		return controlla;			
	}
	
	public void incrementaPostiLetto() {
		this.reparto.incrementaPostiDisponibili(1);
	}
	
	
	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}

	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		// notifica se ci sono posti disponibili
			int postiliberi= ((Reparto)o).getPostidisponibili();	
			if(postiliberi>0){
				System.out.println("PRENOTAZIONE " + this.idPrenotazione+" : Ci sono posti disponibili:"+ postiliberi + " in " +((Reparto)o).getDescrizione());                   
				if(!this.prenotato) { 
					this.prenotato=true;
					this.aggiornaPrenotazione();			
				}
			}else {
				System.err.println("PRENOTAZIONE: non ci sono piu posti disponibili in "+((Reparto)o).getDescrizione());
				if(!prenotato) {
					System.err.println("PRENOTAZIONE: non ci sono piu posti disponibili in "+((Reparto)o).getDescrizione()+" per il paziente " +this.paziente.getCognome());
				}			
			}
		
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
