
public abstract class Sconto {
	String nome;
	
	public abstract double calcolaTotaleScontato(Ricovero ricovero, double tot);
	
	public String getNome() {
		return nome;
	}
	
	// metodi per gestire i componenti
	
	public void add(Sconto s)	{
	}
	
	public void remove(Sconto s)	{
	}
	
	public Sconto getSconto(String nome)	{
		return null;
	}

	@Override
	public String toString() {
		return "Sconto [nome=" + nome + "]";
	}

	
	
	
}
