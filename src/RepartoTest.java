import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepartoTest {

	@Test
	void testIncrementaPostoLetto() {//con valori normali
		Reparto reparto= new Reparto(1, 1, 1, 7,"reparto1",new Servizio(1, 1, "servizio1",1, "servizio1"));
		reparto.incrementaPostiDisponibili(10);
		int res=reparto.getPostidisponibili();
		assertEquals(17, res);
	}
	@Test
	void testIncrementaPostoLetto1() {//con valori negativi, li incrementa solo se sono positivi
		Reparto reparto= new Reparto(1, 1, 1, 7,"reparto1",new Servizio(1, 1, "servizio1",1, "servizio1"));
		reparto.incrementaPostiDisponibili(-10);
		int res=reparto.getPostidisponibili();
		assertEquals(7, res);
	}
	@Test
	void testAssegnaPostoLetto1() {
		Reparto reparto= new Reparto(1, 1, 1, 5,"reparto1",new Servizio(1, 1, "servizio1",1, "servizio1"));
		reparto.assegnaPostoLetto();
		reparto.assegnaPostoLetto();
		reparto.assegnaPostoLetto();
		reparto.assegnaPostoLetto();
		reparto.assegnaPostoLetto();
		reparto.assegnaPostoLetto();// non lo assegna perchè già siamo a 0 posti 
		int res=reparto.getPostidisponibili();
		assertEquals(0, res);
	}

}
