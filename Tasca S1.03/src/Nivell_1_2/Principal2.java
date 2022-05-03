package Nivell_1_2;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;


public class Principal2 {

	public static void main(String[] args) {

		List <Integer> lista1=new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			
			lista1.add((int) (Math.random()*100));//Llenamos la lista con números aleatorios del 0 al 100.
		}
		
		System.out.println("Lista de 10 números random del 0 al 100.");
		System.out.println(lista1);//Imprimimos por pantalla la lista.
		
		List <Integer> lista2=new ArrayList<Integer>();
		
		ListIterator<Integer> li=lista1.listIterator(lista1.size());
		
		while(li.hasPrevious()) {
			
			lista2.add(li.previous());
			
		}
		
		System.out.println("\nLista 2 con los mismos números invertidos.");
		System.out.println(lista2);//Imprimimos por pantalla la lista 2.
	}
}
