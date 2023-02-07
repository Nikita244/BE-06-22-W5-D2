package it.epicode.be.godfather.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Ordine {
	
	private int id;
	private Menu menu;
	private String note;
	private StatoOrdine statoOrdine;
	private int coperti;
	private LocalTime oraOrdine;
	private double totale;
	
	public String menu(Menu m) {
		List<Pizza> pizzas = m.getMenuPizza();
		List<Drink> drinks = m.getMenuDrink();
		List<Franchise> franchises = m.getMenuFranchise();

		List<String> pizzaNames = pizzas.stream().map(Pizza::getName).collect(Collectors.toList());
		List<String> drinkNames = drinks.stream().map(Drink::getName).collect(Collectors.toList());
		List<String> franchiseNames = franchises.stream().map(Franchise::getName).collect(Collectors.toList());

		return String.join("\n", pizzaNames) + "\n" + String.join("\n", drinkNames) + "\n" + (franchiseNames.isEmpty() ? "" : String.join("\n", franchiseNames));
	}
	
	public double getTotalCost(Menu m) {
		   List<Pizza> pizzas = m.getMenuPizza();
		   List<Drink> drinks = m.getMenuDrink();
		   List<Franchise> franchises = m.getMenuFranchise();

		   double pizzaCost = pizzas.stream().mapToDouble(Pizza::getPrice).sum();
		   double drinkCost = drinks.stream().mapToDouble(Drink::getPrice).sum();
		   double franchiseCost = franchises.stream().mapToDouble(Franchise::getPrice).sum();

		   return pizzaCost + drinkCost + franchiseCost;
		}
	
	@Override
	public String toString() {
		return "\nOrdine n." + id + "\nmenu: \n" + menu(menu) + "\nNota: " + note + " | Stato dell'ordine: " + statoOrdine + " | n.Coperti: "
				+ coperti + " | Orario: " + oraOrdine + " | totale: " + (getTotalCost(menu) + totale) + "Euro";
	}
}