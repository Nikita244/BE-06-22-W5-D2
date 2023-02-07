package it.epicode.be.godfather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tavolo {
	
	private int id;
	private int numCoperti;
	private Stato stato;
	
	public Tavolo(int id, int numCoperti) {
		super();
		this.id = id;
		this.numCoperti = numCoperti;
		this.stato = Stato.LIBERO;
	}

	@Override
	public String toString() {
		return "Tavolo " + id + " | Qty Coperti: " + numCoperti + " | Disponibiltà: " + stato;
	}
	
	

}

enum Stato{
	LIBERO, OCCUPATO
}