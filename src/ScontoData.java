import java.util.Date;



public class ScontoData extends Sconto{
	private double percentuale;
	private Date time;
	public ScontoData(String nome, double percentuale){
		this.nome = nome;
		this.percentuale = percentuale;
		this.time=new Date();
    }
	
	@Override
	public double calcolaTotaleScontato(Ricovero ricovero, double tot) {
		double result = 0;
		if(tot == 0)  {
			result = ricovero.getPreventivo().getTotalePrezzo();
		}
		else {
			result = tot;
		}
		if((time.before(ricovero.getDataFine()))){
			result = result - (result * (percentuale / 100));
			System.out.println("SCONTO DEL "+ percentuale+"% APLLICATO DATA: "+time);
		}
		if(result!=tot)System.out.println("PREZZO SCONTATO :"+ (Math.round(result*100D))/100D);
		return  (Math.round(result*100D))/100D;
	}

	@Override
	public String toString() {
		return "ScontoData [percentuale=" + percentuale + ", nome=" + nome + "]";
	}

	
	
	
	
}
