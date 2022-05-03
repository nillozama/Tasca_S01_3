package Nivell_1_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Principal3 {
	
	static GameController gc=new GameController();
	
	public static void main(String[] args) {
		
		boolean sortirMenu=false;
		
		carregarJoc();
			
		do{
			sortirMenu=showMenu(sortirMenu);
				
		}while(!sortirMenu);
	}
	
	public static boolean showMenu(boolean sortirMenu) {

		String name;
		byte indexSwitch;
		
		System.out.println("JOC DE LES CAPITALS.\n \n0- Sortir del programa. \n1- Jugar partida.");
		indexSwitch=requireByteNumber("Quina opció del menú vols triar?");
		
		switch(indexSwitch) {
		
			case 0:

				System.out.println("Gracies per utilitzar l'aplicació. Adeu!!");
				sortirMenu=true;

				break;

			case 1:
				
				name=requireString("Introdueix el teu nom.");
				Jugador player=new Jugador(name);
				gc.addPlayer(player);
				
				try {
					
					addPlayerFile(play(player));
				}
				
				catch (IOException e){
					
					System.out.println(e.getMessage()+" Archivo no encontrado.");
				}
			
				break;
	
			default:
				
				System.out.println("Has d'escollir un número de la llista.");
			}
			
			return sortirMenu;
		}
	
	static public void carregarJoc() {
		
		try {
			
			crearArchivo();
		}
		
		catch (IOException e){
			
			System.out.println(e.getMessage()+" Archivo no encontrado.");
		}

		try{
			gc.loadCountryHashMapList("countries.txt");
		}
		
		catch(IOException e){
			
			System.out.println(e.getMessage()+" Archivo no encontrado.");
		}
	}
	
	static public Jugador play(Jugador player) {
		
		String country;
		String resposta;
		
		for(int i=0;i<10;i++) {
			
			country=gc.generateRandomCountry();
			resposta=requireString("Escriu el nom de la capital de "+country+".");
			
			if(gc.countryHashMapList.get(country).equalsIgnoreCase(resposta)){
				
				System.out.println("Molt bé!");
				player.calculateScore();
			}
			else {
				
				System.out.println("La resposta correcte era: "+gc.countryHashMapList.get(country)+".");
			}
		}
		
		return player;
	}
	
	 public static void addPlayerFile(Jugador player) throws IOException {
		 
	        FileWriter fw = new FileWriter(new File("classificacio.txt"));
	        BufferedWriter bw = new BufferedWriter(fw);

	        for(int i=0;i<gc.playerList.size();i++) {
	        	
	        	bw.write("Jugador: "+gc.playerList.get(i).getName()+", "+gc.playerList.get(i).getScore()+" punts.");
		        bw.newLine();
	        }
	        
	        bw.newLine();
	        bw.close();
	        fw.close();
	 }
	
	 public static void crearArchivo() throws IOException {
		 
	        FileWriter fw = new FileWriter(new File("countries.txt"));
	        BufferedWriter bw = new BufferedWriter(fw);
	        
	        bw.write("Afganistan, Kabul");
	        bw.newLine();
	        bw.write("Perú, Lima");
	        bw.newLine();
	        bw.write("Grecia, Atenas");
	        bw.newLine();
	        bw.write("Portugal, Lisboa");
	        bw.newLine();
	        bw.write("Argentina, Buenos Aires");
	        bw.newLine();
	        bw.write("Hungría, Budapest");
	        bw.newLine();
	        bw.write("Siria, Damasco");
	        bw.newLine();
	        bw.write("Albania, Tirana");
	        bw.newLine();
	        bw.write("Rusia, Moscu");
	        bw.newLine();
	        bw.write("Angola, Luanda");
	        bw.newLine();
	        bw.write("Australia, Canberra");
	        bw.newLine();
	        bw.write("Bolivia, Sucre");
	        bw.newLine();
	        bw.write("China, Pekin");
	        bw.newLine();
	        bw.write("Chile, Santiago");
	        bw.newLine();
	        bw.write("Chipre, Nicosia");
	        bw.newLine();
	        bw.write("Filipinas, Manila");
	        bw.newLine();
	        bw.write("Italia, Roma");
	        bw.newLine();
	        bw.write("Alemania, Berlin");
	        bw.newLine();
	        bw.write("Japón, Tokio");
	        bw.newLine();
	        bw.write("Marruecos, Rabat");
	        bw.newLine();
	        
	        bw.close();
	        fw.close();
	        
	 }
	 
		public static String requireString(String message) {
			
			Scanner sc=new Scanner(System.in);
			String string;
			
			System.out.println(message);
			string=sc.nextLine();
			
			return string;
		}
		
		public static byte requireByteNumber(String message) {
			
			Scanner sc=new Scanner(System.in);
			byte num;
			
			System.out.println(message);
			num=sc.nextByte();
			
			return num;
		}
}
