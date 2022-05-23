package Nivell_2_1;

import java.util.Objects;

public class Restaurant {
	
	private String nom;
	private int puntuacio;
	
	public Restaurant(String nom, int puntuacio) {
		
		this.nom=nom;
		this.puntuacio=puntuacio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	public boolean equals(Object object) {
		
		if (object == null) {
			
			return false;
		}

		Restaurant restaurant = (Restaurant)object;
		if (this.nom.equals(restaurant.getNom())) {
			
			if(this.puntuacio==restaurant.getPuntuacio()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		
		return Objects.hashCode(nom);
	}

	@Override
	public String toString() {
		return  nom + " amb puntuació "+puntuacio;
	}
}
