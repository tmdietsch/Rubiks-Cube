package pack;

import java.util.ArrayList;

public class Cubelet {

	public char color;
	private ArrayList<Cubelet> neighbors;
	
	public Cubelet(char color, ArrayList<Cubelet> neighbors) {
		this.color = color;
		
		this.neighbors = neighbors;
	}
	
	public Cubelet(char color) {
		this.color = color;
		
		neighbors = new ArrayList<>();
	}
	
	public void addNeighbor(Cubelet c) {
		neighbors.add(c);
		
		c.addNeighborDefault(this);
	}
	
	private void addNeighborDefault(Cubelet c) {
		neighbors.add(c);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) {
			return true;
		}
		
		if (! (o instanceof Cubelet)) {
			return false;
		}
		
		Cubelet c = (Cubelet) o;
		
		if (c.color != this.color)
			return false;
		
		if (c.neighbors.size() != this.neighbors.size())
			return false;
		
		for (int i = 0; i < c.neighbors.size(); i++) {
			if (c.neighbors.get(i).color != this.neighbors.get(i).color)
				return false;
		}
		
		return true;
	}
	
}
