package it.epicode.be.godfather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.godfather.model.Tavoli;
import it.epicode.be.godfather.model.Tavolo;

@Configuration
public class TavoliConfig {
	
	@Bean
	public Tavoli tavoliList() {

		Tavoli tavoli = new Tavoli();

		tavoli.getListaTavolo().add(new Tavolo(1,4));
		tavoli.getListaTavolo().add(new Tavolo(2,2));
		tavoli.getListaTavolo().add(new Tavolo(3,5));
		tavoli.getListaTavolo().add(new Tavolo(4,2));
		tavoli.getListaTavolo().add(new Tavolo(5,6));

		return tavoli;
	}
}
