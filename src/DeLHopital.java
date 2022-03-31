import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.event.spi.ClearEvent;

@SuppressWarnings("all")

public class DeLHopital {

	private static ArrayList<Paziente> pazienti; //ok
	private static ArrayList<Reparto> reparti;  //ok
	private static ArrayList<Ricovero> ricoveri;  //ok
	private static ArrayList<Servizio> servizi; //ok
	private static ArrayList<Prenotazione> prenotazioni;
	private static ArrayList<Preventivo> preventivi;  //ok
	private static ArrayList<Sconto> sconti;
	private static StartUp startUp;
	private static ArrayList<Servizio> serviziScelti;
	
	public static void main(String[] args) throws IOException {
		startUp=new StartUp();
		carica();		
		Scanner scan=new Scanner(System.in);
		logo();
		int scelta=10000;
		
		while(scelta!=0) {
			System.out.println("1 CREA PRENOTAZIONE");
			System.out.println("2 ASSOCIA SCONTO(se disponibile) E TERMINA RICOVERO");
			System.out.println("3 SALVA");
			System.out.println("4 INCREMENTA POSTI REPARTO");
			System.out.println("5 STAMPA DATI");
			System.out.println("0 ESCI");
			scelta=scan.nextInt();
			switch (scelta) {
			case 1:
				prenotazione();
				break;
			case 2:
				associaSconto();
				break;
			case 3:
				salva();
				break;
			case 4:
				incrementaPosti();
				break;
			case 5:
				stampa();
				break;
			default:
				break;
			}	
		}
		System.out.println("GRAZIE PER AVERE USATO DEL'HOSPITAL");
		logo();
	}
	
	private static void incrementaPosti() {
		Scanner scan = new Scanner(System.in);
		int scelta=10000;
		int posti=0;
		while(scelta!=0) {
			System.out.println("SCEGLIERE UN REPARTO IN BASE AL CODICE DEL REPARTO, 0 PER TERMINARE");
			for(int i=0; i<reparti.size(); i++) {
				System.out.println(reparti.get(i).toString());		
			}
			scelta = scan.nextInt();
			
			if(scelta<reparti.size()+1) {
				if(scelta>0) {
					System.out.println("REPARTO SCELTO : "+reparti.get(scelta-1).toString()); 
					System.out.println("QUANTI POSTI AGGIUNGERE?");
					posti=scan.nextInt();
					System.out.println(posti);
					reparti.get(scelta-1).incrementaPostiDisponibili(posti);
				}
				else if(scelta==0){
					System.out.println("HAI SCELTO DI USCIRE"); 
				}
			}else {
				System.err.println("CODICE NON ESISTENTE");
			}
		}
	}
	
	private static void stampa() {
		System.out.println("STAMPA");
		System.out.println("PAZIENTI--------------------------------------------------");
		for(int i=0; i<pazienti.size(); i++) {
			System.out.println(pazienti.get(i).toString());		
		}
		System.out.println();
		System.out.println("REPARTI--------------------------------------------------");
		for(int i=0; i<reparti.size(); i++) {
			System.out.println(reparti.get(i).toString());		
		}
		System.out.println();
		System.out.println("RICOVERI--------------------------------------------------");
		for(int i=0; i<ricoveri.size(); i++) {
			System.out.println(ricoveri.get(i).toString());		
		}
		System.out.println();
		System.out.println("PRENOTAZIONI--------------------------------------------------");
		for(int i=0; i<prenotazioni.size(); i++) {
			System.out.println(prenotazioni.get(i).toString());		
		}
		System.out.println();
		System.out.println("PREVENTIVI--------------------------------------------------");
		for(int i=0; i<preventivi.size(); i++) {
			System.out.println(preventivi.get(i).toString());		
		}
		System.out.println();
		System.out.println("SCONTI--------------------------------------------------");
		for(int i=0; i<sconti.size(); i++) {
			System.out.println(sconti.get(i).toString());		
		}
	}
	
	private static void associaSconto() {
		Scanner scan = new Scanner(System.in);
		int scelta=10000;
		while(scelta>ricoveri.size()) {
			System.out.println("SCEGLIERE UN PAZIENTE IN BASE AL CODICE DEL RICOVERO");
			System.out.println("PAZIENTI CHE HANNO UN RICOVERO DA PAGARE , SE E' POSSIBILE VERRA' APPLCIATO LO SCONTO");
			for(int i=0; i<ricoveri.size(); i++) {
				System.out.println("CODICE RICOVERO : " +(i+1)+"   "+ricoveri.get(i).getPaziente().toString());		
			}
			scelta = scan.nextInt();
			if(scelta>0 && scelta<ricoveri.size()+1) {
				if(!ricoveri.get(scelta-1).isGiaPagato()){
					System.out.println("PAZIENTE SCELTO : "+ricoveri.get(scelta-1).getPaziente().toString());//scelgo il paziente dal ricovero
					System.out.println("ASSOCIO LO SCONTO E LIBERO I POSTI OCCUPATI");
					ArrayList<Servizio> ls=ricoveri.get(scelta-1).getPreventivo().getServizi();//prendo i servizi dal preventivo che sono i servizi fatti dal paziente
						for(Servizio s:ls) {
						for(Reparto r:reparti) {
							if(s.equals(r.getServizio())) {
								ricoveri.get(scelta-1).setGiaPagato(true);//così dico che ho pagato per quel ricovero
								r.incrementaPostiDisponibili(1);//incremento di un posto dato che il cliente ha avuto lo sconto e quindi sta terminado
							}
						}
					}
				ricoveri.get(scelta-1).associaSconto(sconti.get(0));
				}else {
					System.err.println("GIA PAGATO");
				}			
			}
			else {
				System.err.println("Scelta non corretta"); 
			}
		}
		
   }
		
	private static void prenotazione() {
		Paziente paziente=scegliPaziente();
		if(paziente!=null) {
			serviziScelti=scegliServizi();
			@SuppressWarnings("unchecked")
			Preventivo prev = new Preventivo(preventivi.size()+1,(ArrayList<Servizio>)serviziScelti.clone());// senza il clona la lista si cancella
			preventivi.add(prev);
			Ricovero ric=creaRicovero(prev, paziente);
			ricoveri.add(ric);
			creaPrenotazione(serviziScelti, paziente);	
			serviziScelti.clear();
		}
	}
	
	private static  Ricovero creaRicovero(Preventivo prev,Paziente paziente) {
		int periodo = 14; 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, periodo);
		Date fine = calendar.getTime();
		Date inizio= new Date();
		Ricovero ric= new Ricovero(inizio, fine, prev, paziente);
		return ric;
		
	}
	
	private static void creaPrenotazione(ArrayList<Servizio> servScelti, Paziente paziente) {
		boolean prenotato=true;
		for(Servizio s: servScelti) {// controllo in che reparto è il servizio
			for(Reparto r:reparti) {
				if(r.getServizio().equals(s)) {// se è nel reparto r aggiungo la prenotazione in quel reparto
					if(r.getPostidisponibili()<=0){
						prenotato=false;
					}
					Prenotazione p= new Prenotazione(prenotazioni.size()+1, paziente, r, prenotato);
					prenotazioni.add(p);
				}
			}
		}
	
	}

	private static Paziente scegliPaziente() {	
		Scanner scan = new Scanner(System.in);
		int scelta =1000; 
		while(scelta>pazienti.size() || scelta==0) {
			System.out.println("SCEGLIERE UN PAZIENTE IN BASE AL CODICE FISCALE");
			for(int i=0; i<pazienti.size(); i++) {
				System.out.println(pazienti.get(i).toString());		
			}
			scelta = scan.nextInt();	
			if(scelta>0 && scelta<pazienti.size()+1) {
				System.out.println("PAZIENTE SCELTO : "+pazienti.get(scelta-1).toString());
			}else if(scelta!=0){
				System.err.println("Scelta non corretta");
			}else if(scelta==0) {
				System.out.println("HAI SCELTO DI USCIRE");
				return null;
			}
		}

		return pazienti.get(scelta-1);

	
		
	}
	
	private static ArrayList<Servizio> scegliServizi(){	
		Scanner scan = new Scanner(System.in);
		int scelta=10000;
		while(scelta!=0) {
			System.out.println("SCEGLIERE UN SERVIZIO IN BASE AL CODICE DEL SERVIZIO, 0 PER TERMINARE");
			for(int i=0; i<servizi.size(); i++) {
				System.out.println(servizi.get(i).toString());		
			}
			scelta = scan.nextInt();
			if(scelta<servizi.size()+1) {
				if(scelta>0 && !serviziScelti.contains((servizi.get(scelta-1)))) {
					System.out.println("SERVIZIO SCELTO : "+servizi.get(scelta-1).toString()); 
					serviziScelti.add(servizi.get(scelta-1)); 
				}
				else if(scelta==0){
					System.out.println("HAI SCELTO DI USCIRE"); 
				}else if(serviziScelti.contains((servizi.get(scelta-1)))){
					System.err.println("SERVIZIO GIA SCELTO"); 
				}
			}else {System.err.println("CODICE NON ESISTENTE");}
		}
		
		return serviziScelti;
	}
	
	private static void carica() throws IOException {
		pazienti=startUp.caricaPazienti();
		servizi=startUp.caricaServizi();
		reparti=startUp.caricaReparti();
		sconti=startUp.caricaSconti();
		preventivi=new ArrayList<Preventivo>();
		ricoveri=new ArrayList<Ricovero>();
		prenotazioni=new ArrayList<Prenotazione>();
		serviziScelti= new ArrayList<Servizio>();
		System.out.println("DATI CARICATI");
	}
	
	private static  void salva() throws FileNotFoundException {
		//PRENOTAZIONI
		PrintWriter preno = new PrintWriter("prenotazioni.txt");
		for(int i=0;i<prenotazioni.size();i++) {
			preno.println(prenotazioni.get(i).toString());
		}
		preno.close();
		//PREVENTIVI
		PrintWriter preven = new PrintWriter("preventivi.txt");
		for(int i=0;i<preventivi.size();i++) {
			preven.println(preventivi.get(i).toString());
		}
		preven.close();
		
		//RICVOERI
		PrintWriter ricov = new PrintWriter("ricoveri.txt");
		for(int i=0;i<ricoveri.size();i++) {
			ricov.println(ricoveri.get(i).toString());
		}
		ricov.close();
		//SCONTI
		PrintWriter scont = new PrintWriter("listaSconti.txt");
		for(int i=0;i<sconti.size();i++) {
			scont.println(sconti.get(i).toString());
		}
		scont.close();
		
		PrintWriter ps = new PrintWriter("prezziScontati.txt");
		for(int i=0;i<ricoveri.size();i++) {
			ps.println("PREZZO INIZIALE DEL RICOVERO DEL PAZIENTE "+ ricoveri.get(i).getPaziente().getCognome()+ "  " + ricoveri.get(i).getPreventivo().getTotalePrezzo());
			ps.println("PREZZO SCONTATO DEL RICOVERO DEL PAZIENTE "+ ricoveri.get(i).getPaziente().getCognome()+ "  " + ricoveri.get(i).associaSconto(sconti.get(0)));
		}
		ps.close();
		
		System.out.println("SALVATO");
		
	}
	
	private static void logo() {
		int width=50;
		int height=23;
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g= image.getGraphics();
		g.setFont(new Font("SansSerif",Font.BOLD,24));
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("DLH", 1, 20);
		
		for(int y=0;y<height;y++) {
			StringBuilder builder= new StringBuilder(); 
		
			for(int x=0;x<width;x++) {
				builder.append(image.getRGB(x, y) == -16777216 ? " ":"#");
			}
			System.out.println(builder);
		}
		
		
	}
		
}
