package Nivell_2_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Principal31N2 {
	
	static Set <Restaurant> llistaRestaurants=new HashSet<Restaurant>();
	
	public static void main(String[] args) {
		
		boolean sortirMenu=false;
		
		do{
			sortirMenu=showMenu(sortirMenu);
			
		}while(!sortirMenu);
	}
	
	public static boolean showMenu(boolean sortirMenu) {

		Restaurant restaurant;
		String nom;
		int puntuacio;
		int indexSwitch;
		
		System.out.println("Programa per introduir restaurants.\n \n0- Sortir del programa. \n1- Introduir restaurant.\n2- Mostra llista restaurants. ");
		indexSwitch=requireIntNumber("Quina opció del menú vols triar?");
		
		switch(indexSwitch) {
		
		case 0:

			System.out.println("Gracies per utilitzar l'aplicació. Adeu!!");
			sortirMenu=true;

			break;
			
		case 1:

			nom=requireString("Introdueix el nom del restaurant.");
			puntuacio= requireIntNumber("Introdueix puntuació del restaurant (puntuació del 1 al 10).");
			restaurant=crearRestaurant(nom.toUpperCase(), puntuacio);
			
			if(addRestaurantToList(restaurant)) {
				System.out.println("El restaurant "+restaurant+" s'ha creat.");
			}
			else {
				System.out.println("El restaurant "+restaurant+" ja existeix.");
			}

			break;
			
		case 2:
			
			System.out.println(llistaRestaurants);
			
		default:
			
			System.out.println("Has d'escollir un número de la llista.");
		}
		
		return sortirMenu;
	}

	public static Restaurant crearRestaurant(String nom, int puntuacio) {
		
		Restaurant restaurant=new Restaurant(nom, puntuacio);
		return restaurant;
	}
	
	public static boolean addRestaurantToList(Restaurant restaurant) {
		
		return llistaRestaurants.add(restaurant);
	}
	
	public static int requireIntNumber(String message) {
		
		Scanner sc=new Scanner(System.in);
		int num;
		
		System.out.println(message);
		num=sc.nextInt();
		
		return num;
	}
	
	public static String requireString(String message) {
		
		Scanner sc=new Scanner(System.in);
		String string;
		
		System.out.println(message);
		string=sc.nextLine();
		
		return string;
	}
}
