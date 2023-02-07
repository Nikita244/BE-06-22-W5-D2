package it.epicode.be.godfather;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import it.epicode.be.godfather.config.TavoliConfig;
import it.epicode.be.godfather.model.Tavoli;


public class GestioneTavoli {
	
	private Tavoli tavoli;
	private AnnotationConfigApplicationContext ctx;

	public GestioneTavoli() {
		ctx = new AnnotationConfigApplicationContext(TavoliConfig.class);
		tavoli = (Tavoli) ctx.getBean("tavoliList");
	}
	
	public void stampaTavoli() {
		System.out.println("Tavoli disponibili: ");
		tavoli.getListaTavolo().forEach(t -> System.out.println(t.toString()));
	}

}
