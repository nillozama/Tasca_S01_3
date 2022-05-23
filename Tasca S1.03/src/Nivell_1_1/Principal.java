package Nivell_1_1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
public class Principal {

	public static void main(String[] args) {

		ArrayList<Month> monthList=new ArrayList<Month>();
		
		Month month;
		month=new Month("Gener");
		monthList.add(month);
		
		month=new Month("Febrer");
		monthList.add(month);
		
		month=new Month("Març");
		monthList.add(month);
		
		month=new Month("Abril");
		monthList.add(month);
		
		month=new Month("Maig");
		monthList.add(month);
		
		month=new Month("Juny");
		monthList.add(month);
		
		month=new Month("Juliol");
		monthList.add(month);
		
		month=new Month("Setembre");
		monthList.add(month);
		
		month=new Month("Octubre");
		monthList.add(month);
		
		month=new Month("Novembre");
		monthList.add(month);
		
		month=new Month("Desembre");
		monthList.add(month);
		
		System.out.println("Impresión lista ArrayList sin mes de Agosto:");
		System.out.println(monthList);
		
		month=new Month("Agost");
		monthList.add(7,month);
		
		System.out.println("\nImpresión lista ArrayList con mes de Agosto:");
		System.out.println(monthList);
		
		HashSet<Month> monthSetList=new HashSet<Month> (monthList);
		
		
		/*HashSet<Month> monthSetList=new HashSet<Month>();
		 * monthSetList.addAll(monthList);
		
 		monthList.forEach(value -> {monthSetList.add(value);});*/

		System.out.println("\nImpresión lista HashSet:");
		System.out.println(monthSetList);
		
		month=new Month("Desembre");
		monthSetList.add(month);//Añadimos un mes para comprobar que no se duplica.
		
		System.out.println("\nImpresión lista HashSet comprobando que no repite elementos:");
		System.out.println(monthSetList);
		
		System.out.println("\nRecorrido con for:");
		
		for (Month month2:monthSetList) {//Recorrer lista con un for-each
			
			System.out.print(month2+", ");
		}
		
		System.out.println("\n\nRecorrido con iterator:");
		
		Iterator<Month> it = monthSetList.iterator();
		
		while(it.hasNext()) {
			
			month = it.next();
			System.out.print(month+", ");
		}
	}
}
