
public class Grid{
	
	
	Tile[][] grid;
	Agent agent = new Agent();;
	Block a = new Block("A");
	Block b = new Block("B");
	Block c = new Block("C");
	
	public Grid(String s) {
		
		grid = new Tile[4][4];

		grid[3][0] = a;
		grid[3][1] = b;
		grid[3][2] = c;
		grid[3][3] = agent;
	
		a.setPos(3, 0);
		b.setPos(3, 1);
		c.setPos(3, 2);
		agent.setPos(3, 3);
		
	}

	public Grid() {
		
		grid = new Tile[4][4];
	}
	
	
	public int[] getAgentPosition() {
		int[] pos = new int[2];

		
		pos[0] = this.agent.getPos()[0];
		pos[1] = this.agent.getPos()[1];		
		return pos;
		
	}
	
	public Tile[][] getGrid(){
		
		return this.grid;
	}
	
	public Agent getAgent() {
		
		//return this.agent;
		int[] p = this.getAgentPosition();
		return (Agent) this.grid[p[0]][p[1]];
	}
	
	
	
	public void setGrid(Tile[][] t) {
		this.grid = t;
	}
	
	public Tile[][] newTile() {
		
		Tile[][] t = new Tile[4][4];

		return t;	
		
		}
	public Grid newGrid() {
		
		Grid g = new Grid();

		
		return g;
	}
	
	
	public void displayGrid() {
		System.out.println("---------------------------");
		for (int i = 0; i < 4; i++) { 
		    for (int j = 0; j < 4; j++) { 
		        if (grid[i][j] instanceof Agent) { 
		            
		            System.out.print("Agent| ");
		        }
		        else if (grid[i][j] instanceof Block) { 
		        	System.out.print(grid[i][j].getName() + "    | ");
		            
		        }
		        else {
		        	System.out.print("null | ");
		        }
		        
		    }
		    System.out.println("");
		}
		System.out.println("---------------------------");
		
	}
	
}
