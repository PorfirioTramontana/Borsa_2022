package ProvaMain;

import Model.*;

import java.time.LocalDate;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		Borsa borsa=new Borsa(new Listino());
		Listino listino=borsa.getListino();
		listino.addSocieta(new Societa("Apple", 10.0F));
		listino.addSocieta(new Societa("Google",20.0F));
		listino.addSocieta(new Societa("Microsoft",30.0F));
		Societa apple=listino.getSocietaPerNome("Apple");
		Societa google=listino.getSocietaPerNome("Google");
		Societa microsoft=listino.getSocietaPerNome("Microsoft");
		Azione azioneApple=new Azione(apple, 100);
		Azione azioneGoogle=new Azione(google, 200);
		Azione azioneMicrosoft=new Azione(microsoft, 300);
		Giocatore paperone=new Giocatore("Paperone");
		Giocatore topolino=new Giocatore("Topolino");
		Giocatore paperino=new Giocatore("Paperino");
		paperone.acquista(azioneApple, 10);
		paperone.acquista(azioneGoogle, 20);
		paperone.acquista(azioneMicrosoft, 30);
		topolino.acquista(azioneApple, 40);
		topolino.acquista(azioneGoogle, 50);
		System.out.println("Liquidita' di paperone : "+paperone.getLiquidita());
		System.out.println("Liquidita' di topolino : "+topolino.getLiquidita());
		System.out.println("Liquidita' di paperino : "+paperino.getLiquidita());
		azioneApple.setPrezzo(azioneApple.getPrezzo()+10);
		System.out.println("Capitale di paperone : "+paperone.calcolaCapitale());
		System.out.println("Capitale di topolino : "+topolino.calcolaCapitale());
		System.out.println("Capitale di paperino : "+paperino.calcolaCapitale());


		
		
		

	}

}
