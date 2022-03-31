import java.util.LinkedList;

public class ScontoComposite extends Sconto {

	private LinkedList<Sconto> listaSconti;
	
	
	public ScontoComposite(String nome)	{
		this.nome = nome;
		listaSconti = new LinkedList<Sconto>();
	}

	@Override
	public String toString() {
		return "ScontoComposite [listaSconti=" + listaSconti + "]";
	}

	@Override
	public double calcolaTotaleScontato(Ricovero ricovero, double tot) {
		double result = 0;
		if(tot == 0)  {
			result = ricovero.getPreventivo().getTotalePrezzo(); //prende il prezzo totale del ricovero
			System.out.println("PREZZO PRIMA DELLO SCONTO :    "+result);
		}
		else {
			result = tot;
		}
		
		for(Sconto s: listaSconti)	{
			result = s.calcolaTotaleScontato(ricovero,result);
		}
		System.out.println("PREZZO SCONTATO FINALE  :"    +result);
		return result;
	}
	
	
	
	// metodi per gestire i componenti
	
		public void add(Sconto s)	{
			listaSconti.add(s);
		}
		
		public void remove(Sconto s)	{
			listaSconti.remove(s);
		}
		
		public Sconto getSconto(String nome)	{
			Sconto sconto = null;
			
			for(Sconto s: listaSconti)	{
				if(s.getNome() == nome)	{
					sconto = s;
				}
			}
			return sconto;
		}

	

}
