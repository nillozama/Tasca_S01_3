package Nivell_3_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Principal31_N3 {
	
	static List<Persona> llistaPersones=new ArrayList<Persona>();

	public static void main(String[] args) {

		boolean sortirMenu=false;
		
		try {
			carregaFitxerCSV("ListaNombres.csv");
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		do{
			sortirMenu=showMenu(sortirMenu);
			
		}while(!sortirMenu);
	}
	
	public static boolean showMenu(boolean sortirMenu) {

		Persona persona;
		String nom;
		String cognom;
		String dni;
		int indexSwitch;
		
		System.out.println("Programa per ordenar llista de persones.\n \n1.- Introduir persona.\r\n"
				+ "\r\n"
				+ "2.- Mostrar les persones ordenades per nom (A-Z).\r\n"
				+ "\r\n"
				+ "3.- Mostrar les persones ordenades per nom (Z-A).\r\n"
				+ "\r\n"
				+ "4.- Mostrar les persones ordenades per cognoms (A-Z).\r\n"
				+ "\r\n"
				+ "5.- Mostrar les persones ordenades per cognoms (Z-A).\r\n"
				+ "\r\n"
				+ "6.- Mostrar les persones ordenades per DNI (1-9).\r\n"
				+ "\r\n"
				+ "7.- Mostrar les persones ordenades per DNI (9-1).\r\n"
				+ "\r\n"
				+ "0.- Sortir.");
		
		indexSwitch=requireIntNumber("\r\nQuina opció del menú vols triar?");
		
		switch(indexSwitch) {
		
		case 0:

			System.out.println("Gracies per utilitzar l'aplicació. Adeu!!");
			sortirMenu=true;

			break;
			
		case 1:
			
			dni=requireString("Introdueix el DNI de la persona.");
			persona=validateNewPersona(dni);
			if(persona==null) {
				
				nom=requireString("Introdueix nom de la persona.");
				cognom=requireString("Introdueix el cognom de la persona.");
				addPersonesToList(createPersona(nom, cognom, dni));
				System.out.println("La persona "+nom+" "+cognom+" amb DNI "+dni+" s'ha creat.");
			}
			
			break;
			
		case 2:

			ordenarPerNom();
			printList();

			break;
			
		case 3:
			
			ordenarPerNomReverse();
			printList();
			
			break;
			
		case 4:

			ordenarPerCognom();
			printList();

			break;
			
		case 5:
			
			ordenarPerCognomReverse();
			printList();
			
			break;
				
		case 6:
			
			ordenarPerDni();
			printList();
			
			break;
			
		case 7:
			
			ordenarPerDniReverse();
			printList();
			
			break;
			
		default:
			
			System.out.println("Has d'escollir un número de la llista.");
		}
		
		return sortirMenu;
	}
	
	public static void carregaFitxerCSV (String fileName) throws IOException{
		
		FileReader fr = new FileReader(new File(fileName));
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
		Persona persona;
		String nom="";
		String cognom="";
		String dni="";
        String [] parts;

        while (linea != null) {
            
            parts=linea.split(";");
            
            nom = parts[0].trim();
            cognom = parts[1].trim();
            dni= parts[2].trim();
            
           persona=new Persona(nom, cognom, dni);
           llistaPersones.add(persona);
           linea = br.readLine();
        }
        
        br.close();
        fr.close();
	}
	
	public static Persona validateNewPersona(String dni) {
		
		Persona persona=null;
		String message="";
		int index;
		
		index=findListedPersones(dni);
		
		if(index!=-1) {
		
			message="La persona amb dni número "+dni+"  ja existeix a la base de dades.";
			persona=llistaPersones.get(index);
		}
		
		System.out.println(message);
		return persona;
	}
	
	public static int findListedPersones(String dni) {
		
		int index=-1;
		int i=0;
		
		if(llistaPersones.size()>0) {
			do {	
					
				if(dni.equalsIgnoreCase(llistaPersones.get(i).getDni())) {
				
					index=i;
				}
			
				i++;
			
			}while (i<llistaPersones.size()&&!(dni.equalsIgnoreCase(llistaPersones.get(i-1).getDni())));
		}
		return index;
	}
	
	public static Persona createPersona(String nom, String cognom, String dni) {
		
		Persona persona=new Persona(nom, cognom, dni);
		return persona;
	}
	
	public static void addPersonesToList(Persona persona) {
		
		llistaPersones.add(persona);
	}
	
	public static void ordenarPerNom() {
		
		Collections.sort(llistaPersones, (x, y) -> x.getNom().compareToIgnoreCase(y.getNom()));
		
	}
	
	public static void ordenarPerNomReverse() {
		
		Collections.sort(llistaPersones, (x, y) -> y.getNom().compareToIgnoreCase(x.getNom()));
	}
	
	public static void ordenarPerCognom() {
		
		Collections.sort(llistaPersones, (x, y) -> x.getCognom().compareToIgnoreCase(y.getCognom()));
	}
	
	public static void ordenarPerCognomReverse() {
		
		Collections.sort(llistaPersones, (x, y) -> y.getCognom().compareToIgnoreCase(x.getCognom()));
	}
	
	public static void ordenarPerDni() {
		
		Collections.sort(llistaPersones, (x, y) -> x.getDni().compareToIgnoreCase(y.getDni()));
	}
	
	public static void ordenarPerDniReverse() {
		
		Collections.sort(llistaPersones, (x, y) -> y.getDni().compareToIgnoreCase(x.getDni()));
	}
	
	public static void printList() {
		
		System.out.println("__Nom__    ______Cognoms______     ___NIF___");
		
		for(Persona persona:llistaPersones) {
			
			System.out.println(persona);
		}
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
