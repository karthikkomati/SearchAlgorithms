
public class Tile {
	
	String name;
	int[] pos = new int[2];
	
	public Tile(String name) {
	
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

public void setPos(int x, int y) {
		
		pos[0] = x;
		pos[1] = y;
		
	}
	
	public int[] getPos() {
		return pos;
	}
}
