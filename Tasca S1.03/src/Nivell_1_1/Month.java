package Nivell_1_1;

import java.util.Objects;

public class Month {
	
	private String name;
	
	public Month(String name) {
		
		this.name=name;
	}
	
	public String getName() {
		
		return name;
	}
	
	public boolean equals(Object object) {
		
		if (object == null) {
			
			return false;
		}

		Month month = (Month)object;
		if (this.name.equals(month.getName())) {
			
			return true;
		}
		else {
			
			return false;
		}
	}

	public int hashCode() {
		
		return Objects.hashCode(name);
	}

	public String toString() {
		
		return name;
	}
}
