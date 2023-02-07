package it.epicode.be.godfather.config;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.godfather.model.Drink;
import it.epicode.be.godfather.model.Franchise;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.Pizza;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.PizzaSalami;
import it.epicode.be.godfather.model.PizzaTopping;
import it.epicode.be.godfather.model.StatoOrdine;

@Configuration
public class OrdineConfig {
	private AnnotationConfigApplicationContext ctx;
	
	@Bean
	public Menu creaOrdine() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		Menu listaProdotti = new Menu();

		listaProdotti.getMenuPizza().add((PizzaMargherita)ctx.getBean("pizzaMargherita"));
		listaProdotti.getMenuPizza().add((PizzaSalami)ctx.getBean("pizzaSalami"));
		listaProdotti.getMenuDrink().add((Drink)ctx.getBean("drinkLemonade"));
		return listaProdotti;
	}
	
	@Bean	
	public Ordine confermaOrdine() {
		Ordine ordine = new Ordine();
		ordine.setId(1);
		ordine.setCoperti(4);
		ordine.setMenu(creaOrdine());
		ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
		ordine.setNote("Senza cipolla");
		ordine.setOraOrdine(LocalTime.now());
		ordine.setId(0);
		ordine.setTotale((ordine.getCoperti() * 1) );
		
		return ordine;
	}
	
	@Bean
	public String stampaOrdine() {
		String result = confermaOrdine().toString();
		return result;
		
	}
}
