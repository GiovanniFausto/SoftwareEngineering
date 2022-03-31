

public class ScontoEta extends Sconto {
private double percentuale;

	
	public  ScontoEta(String nome, double percentuale){
		this.nome = nome;
		this.percentuale = percentuale;

	}
	
	@Override
	public double calcolaTotaleScontato(Ricovero ricovero, double tot) {
		double result = 0;
		int eta=ricovero.getPaziente().getEta();
		if(tot == 0)  {
			result = ricovero.getPreventivo().getTotalePrezzo();
		}
		else {
			result = tot;
		}
		if(eta<18 || eta>65){
			result = result - (result * (percentuale / 100));
			System.out.println("SCONTO DEL "+ percentuale+"% APLLICATO ETA     " +eta);
		}
		if(result!=tot)System.out.println("PREZZO SCONTATO :"+ (Math.round(result*100D))/100D);
		return  (Math.round(result*100D))/100D;
	}

	@Override
	public String toString() {
		return "ScontoEta [percentuale=" + percentuale + ", nome=" + nome + "]";
	}


	
	
	


}
