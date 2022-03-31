import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;



public class StartUp {
	private static ArrayList<Paziente> pazienti; //ok
	private static ArrayList<Reparto> reparti;  //ok
	private static ArrayList<Servizio> servizi; //ok
	private static ArrayList<Sconto> sconti;

	public StartUp(){
		pazienti= new ArrayList<Paziente>();
		reparti=new ArrayList<Reparto>();		
		servizi= new  ArrayList<Servizio>();
		sconti= new ArrayList<Sconto>();
	}
		
	public ArrayList<Paziente> caricaPazienti() throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Paziente> pazi=(List<Paziente>)session.createQuery("from Paziente").list();
		for(Paziente p:pazi) {
			pazienti.add(p);
		}
		//per salvare
		/*Transaction tx=session.beginTransaction();
		Paziente p=new Paziente();
		p.setCognome("prova1");
		p.setDataRegistrazione(new Date());
		p.setEta(75);
		p.setNome("prova1");
		p.setPercentualeInvalidita(4);	
		session.save(p);
		tx.commit();*/
		
		session.close();	
		return pazienti;
	}
	public ArrayList<Servizio> caricaServizi() {
									//cod  medic  tipo     costo   descri
		Servizio ser1=new Servizio(1, 1, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(2, 2, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(3, 3, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		return servizi;
	}
	public ArrayList<Reparto> caricaReparti() {
		//reparto                 cod  med  inf  posti descri    servizio
		Reparto rep1= new Reparto(1,1,1,5,"[REPARTO 1]",servizi.get(0));
		Reparto rep2= new Reparto(2,2,2,5,"[REPARTO 2]",servizi.get(1));
		Reparto rep3= new Reparto(3,3,3,5,"[REPARTO 3]",servizi.get(2));
		reparti.add(rep1);
		reparti.add(rep2);
		reparti.add(rep3);			
		return reparti;
	}
	public ArrayList<Sconto> caricaSconti() {
		Sconto scontoData= new ScontoData("Data", 20);
		Sconto scontoEta= new ScontoEta("Eta",20);
		Sconto scontoInv= new ScontoInvalidita("Iinvalidità",20);
		Sconto scontoComp= new ScontoComposite("Combinazione Sconto");
		scontoComp.add(scontoData);
		scontoComp.add(scontoEta);
		scontoComp.add(scontoInv);
		sconti.add(scontoComp);
		sconti.add(scontoInv);
		sconti.add(scontoEta);
		sconti.add(scontoData);
		return sconti;
	}
	

	
}
