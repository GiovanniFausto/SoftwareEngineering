import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PrenotazioneTest {
	Paziente paziente=new Paziente(1,"paziente1","paziente1",new Date(),25,0);
	Servizio servizio= new Servizio(123, 123, "servizio 1", 10, "servizio 1");
	Reparto reparto=new Reparto(1,1,1,5,"reparto1",servizio );
	
	@Test
	void testAggiornaPrenotazione(){ // caso normale
		System.out.println("TEST 0");
		Prenotazione prenotazione= new Prenotazione(1,paziente,reparto,false);
		boolean ris=prenotazione.aggiornaPrenotazione();
		assertEquals(true,ris);
		
	}
	
	@Test
	void testAggiornaPrenotazione1(){ // caso senza posti disponibili
		System.out.println("TEST 1 ");
		Prenotazione prenotazione= new Prenotazione(1,paziente,reparto,false);
		reparto.setPostidisponibili(0);
		boolean ris=prenotazione.aggiornaPrenotazione();
		assertEquals(false,ris);		
	}
	
	@Test
	void testAggiornaPrenotazione2(){ // caso senza posti disponibili E POI INCREMENTATI
		System.out.println("TEST 2 ");
		Prenotazione prenotazione= new Prenotazione(1,paziente,reparto,false);
		reparto.setPostidisponibili(0);
		prenotazione.aggiornaPrenotazione();
		reparto.incrementaPostiDisponibili(5);// quando incremento i posti non ho bisogno di forzare la funzione aggiorna perchè richiamata in update 
		boolean ris=prenotazione.isPrenotato();
		assertEquals(true,ris);		
	}

	
	
	
	
	
	
	
	
	
	
}
