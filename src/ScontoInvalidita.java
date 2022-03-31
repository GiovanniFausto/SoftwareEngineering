
public class ScontoInvalidita  extends Sconto{
  private double percentuale;

	
	public  ScontoInvalidita(String nome, double percentuale){
		this.nome = nome;
		this.percentuale = percentuale;

	}
	


	@Override
	public String toString() {
		return "ScontoInvalidita [percentuale=" + percentuale + ", nome=" + nome + "]";
	}



	@Override
	public double calcolaTotaleScontato(Ricovero ricovero, double tot) {
		double result = 0;
		int invalidita=ricovero.getPaziente().getPercentualeInvalidita();
		
		if(tot == 0)  {
			result = ricovero.getPreventivo().getTotalePrezzo();
		}
		else {
			result = tot;
		}
		
		if(invalidita<33 && invalidita>10){
			result = result - (result * (percentuale / 100));
			System.out.println("SCONTO DEL "+ percentuale+ "% APLLICATO INVALIDITA   "+invalidita);
		}else if(invalidita>=33) {
			result = result - (result * (percentuale*2 / 100));		
			System.out.println("SCONTO DEL "+ percentuale*2+ "% APLLICATO INVALIDITA   "+invalidita);
		}
		if(result!=tot)System.out.println("PREZZO SCONTATO :"+ (Math.round(result*100D))/100D);
		return  (Math.round(result*100D))/100D;
	}


}
