import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

public class PreventivoTest {

	@Test
	public void testcalcolaTotale() {//inserendo valori normali
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		Servizio ser1=new Servizio(123, 123, "servizio 1", 10, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 10, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", 10, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		Preventivo testPreventivo=new Preventivo(1,servizi);
		double ris=testPreventivo.calcolaTotale();
		assertEquals(30.0, ris,0);
	}
	
	@Test
	public void testcalcolaTotale2() {//inserendo valori negativi // sistemato in modo da non prendere valori negativi
		ArrayList<Servizio> servizi= new ArrayList<Servizio>();
		Servizio ser1=new Servizio(123, 123, "servizio 1", -10, "servizio 1");
		Servizio ser2=new Servizio(456, 456, "servizio 2", 10, "servizio 2");
		Servizio ser3=new Servizio(678, 678, "servizio 3", -10, "servizio 3");
		servizi.add(ser1);
		servizi.add(ser2);
		servizi.add(ser3);
		Preventivo testPreventivo=new Preventivo(1,servizi);
		double ris=testPreventivo.calcolaTotale();
		assertEquals(10.0, ris,0);
	}



}
