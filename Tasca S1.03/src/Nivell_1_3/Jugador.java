package Nivell_1_3;

public class Jugador {
	
	private String name;
	private int score;
	
	public Jugador(String name) {
		
		this.name=name;
		this.score=0;
	}
	
	public int calculateScore() {
		
		return score++;
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getScore() {
		
		return score;
	}

	public String toString() {
		return "Jugador name=" + name + ", score=" + score + "punts";
	}
}
