import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

@SuppressWarnings("deprecation")
class RicoveroTest {

	@Test
	void testAssociaSconto() {
		// PAZIENTE MINORENNE CON GRAVE INVALIDITà E FINE RICOVERO PRIMA DELLA DATA PREVISTA, HA DIRITTO A TUTTI GLI SOCNTI
		// TOTALE SERVIZI 350 CON GLI SCONTI CIRCA 134
		System.out.println();
		System.out.println("TEST ASSOCIA SCONTO 1 FINE RICOVERO PRIMA, MINORE, GRAVE INVALIDITA, TUTTI GLI SCONTI");
		Date time=new Date();
		Date timeini=new Date(119,7,11);
		Date timefine=new Date(119,7, 20);
		//lista servizi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		//paziente
		Paziente paziente= new Paziente(1, "paziente1", "paziente1", time, 15, 50);
		//lista sconti 
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		//servizi
		Servizio ser1=new Servizio(123, 123, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		//prev
		Preventivo preventivo=new Preventivo(123, servizi);
		//sconti
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
		//ricovero
		Ricovero ricovero = new Ricovero(timeini,timefine,preventivo,paziente);
		double prezzoScontato=ricovero.associaSconto(sconti.get(0));
		assertEquals(134,prezzoScontato,1);
	}
	@Test
	void testAssociaSconto2() {
		// PAZIENTE MAGGIORENNE CON SENZA INVALIDITà E FINE RICOVERO PRIMA DELLA DATA PREVISTA, HA DIRITTO A SCONTO DATA 20%
		//TOTALE SERVIZI 350 CON SCONTO 280
		System.out.println();
		System.out.println("TEST ASSOCIA SCONTO 2 FINE RICOVERO PRIMA, MAGGIORENNE, NO INVALIDITA, SCONTO DATA");
		Date time=new Date();
		Date timeini=new Date(119,7,11);
		Date timefine=new Date(119,7, 20);
		//lista servizi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		//paziente
		Paziente paziente= new Paziente(1, "paziente1", "paziente1", time, 25, 0);
		//lista sconti 
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		//servizi
		Servizio ser1=new Servizio(123, 123, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		//prev
		Preventivo preventivo=new Preventivo(123, servizi);
		//sconti
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
		//ricovero
		Ricovero ricovero = new Ricovero(timeini,timefine,preventivo,paziente);
		double prezzoScontato=ricovero.associaSconto(sconti.get(0));
		assertEquals(280,prezzoScontato,1);
	}
	@Test
	void testAssociaSconto3() {
		// PAZIENTE MAGGIORENNE CON  INVALIDITà E FINE RICOVERO PRIMA DELLA DATA PREVISTA, HA DIRITTO A SCONTO INV 20% E DATA20%
		//TOTALE PRIMA 350 SCONTATO CIRCA 224
		System.out.println();
		System.out.println("TEST ASSOCIA SCONTO 3 FINE RICOVERO PRIMA,MAGGIORENNE, INVALIDITA, SCONTO INV E DATA");
		Date time=new Date();
		Date timeini=new Date(119,7,11);
		Date timefine=new Date(119,7, 20);
		//lista servizi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		//paziente
		Paziente paziente= new Paziente(1, "paziente1", "paziente1", time, 25, 25);
		//lista sconti 
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		//servizi
		Servizio ser1=new Servizio(123, 123, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		//prev
		Preventivo preventivo=new Preventivo(123, servizi);
		//sconti
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
		//ricovero
		Ricovero ricovero = new Ricovero(timeini,timefine,preventivo,paziente);
		double prezzoScontato=ricovero.associaSconto(sconti.get(0));
		assertEquals(224,prezzoScontato,1);
	}
	@Test
	void testAssociaSconto4() {
		// PAZIENTE MAGGIORENNE SENZA  INVALIDITà E FINE RICOVERO DOPO DELLA DATA PREVISTA, NON HA DIRITTO A SCONTO 
		//TOTALE PRIMA 350 SCONTATO CIRCA 224
		System.out.println();
		System.out.println("TEST ASSOCIA SCONTO 4 FINE RICOVERO DOPO, MAGGIORE, NO INVALIDITA, NO SCONTI");
		Date time=new Date();
		Date timeini=new Date(119,7,9);
		Date timefine=new Date(119,7, 12);
		//lista servizi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		//paziente
		Paziente paziente= new Paziente(1, "paziente1", "paziente1", time, 25, 0);
		//lista sconti 
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		//servizi
		Servizio ser1=new Servizio(123, 123, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		//prev
		Preventivo preventivo=new Preventivo(123, servizi);
		//sconti
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
		//ricovero
		Ricovero ricovero = new Ricovero(timeini,timefine,preventivo,paziente);
		double prezzoScontato=ricovero.associaSconto(sconti.get(0));
		assertEquals(350,prezzoScontato,1);
	}
	@Test
	void testAssociaScontoa5() {
		//valori limiti
		// PAZIENTE MAGGIORENNE   INVALIDITà E FINE RICOVERO in DELLA DATA PREVISTA,sconto invalidita limite
		//TOTALE PRIMA 350 SCONTATO CIRCA 210
		System.out.println();
		System.out.println("TEST ASSOCIA SCONTO 5 FINE RICOVERO IN TEMPO, MAGGIORE, INVALIDITA, SCONTO LIMITE INVALIDITA");
		Date time=new Date();
		Date timeini=new Date(119,7,11);
		Date timefine=new Date();
		//lista servizi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		//paziente
		Paziente paziente= new Paziente(1, "paziente1", "paziente1", time, 18, 33);
		//lista sconti 
		ArrayList<Sconto> sconti = new ArrayList<Sconto>();
		//servizi
		Servizio ser1=new Servizio(123, 123, "servizio 1", 50, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 100, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 200, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		//prev
		Preventivo preventivo=new Preventivo(123, servizi);
		//sconti
     	Sconto scontoData= new ScontoData("Data", 20);
     	//scontoData.setData(119,7,20);
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
		//ricovero
		Ricovero ricovero = new Ricovero(timeini,timefine,preventivo,paziente);
		double prezzoScontato=ricovero.associaSconto(sconti.get(0));
		assertEquals(210,prezzoScontato,1);
	}

}
