package it.epicode.be.godfather;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import it.epicode.be.godfather.config.OrdineConfig;
import it.epicode.be.godfather.model.Ordine;

public class GestioneOrdine {
	
	private Ordine ordine;
	private String stampa;
	private AnnotationConfigApplicationContext ctx;

	public GestioneOrdine() {
		ctx = new AnnotationConfigApplicationContext(OrdineConfig.class);
		ordine = (Ordine) ctx.getBean("confermaOrdine");
		stampa = (String) ctx.getBean("stampaOrdine");

	}
	//List<Ordine> orderList = new ArrayList<Ordine>();

	
	public void stampaOrdine() {
		System.out.println(stampa);
	}
}
