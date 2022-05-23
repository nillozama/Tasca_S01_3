package Nivell_1_3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
	
	ArrayList <Jugador> playerList;
	ArrayList <String> countryIndexList;
	HashMap <String, String> countryHashMapList;
	
	public GameController(){
		
		playerList=new ArrayList <Jugador>();
		countryIndexList=new ArrayList <String>();
		countryHashMapList=new HashMap <String, String>();
	}
	
	public void loadCountryHashMapList(String fileName) throws IOException{
		
		FileReader fr = new FileReader(new File(fileName));
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        String [] parts;
        String country;
        String capital;
        
        while (linea != null) {
            
            parts = linea.split(", ");
            
            country = parts[0].trim();
            capital = parts[1].trim();
            countryIndexList.add(country);
            countryHashMapList.put(country, capital);
            linea = br.readLine();
        }
        
        br.close();
        fr.close();
	}
	
	public String generateRandomCountry() {
		
		String country;
		
		country=countryIndexList.get((int) (Math.random()*countryIndexList.size()));
		
		return country;
	}
	
	public void addPlayer(Jugador player) {
		
		playerList.add(player);
	}

}
