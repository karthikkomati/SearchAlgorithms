import java.util.ArrayList;
import java.util.Collections;

public class Move {
	
	public Grid moveLeft(Grid g) {
		
		Grid g2 = new Grid();
		Tile[][] t = g2.getGrid();
		int[] p = g.getAgentPosition();
		if (p[1] == 0) {
		
			//System.out.println("Cant move left");
			g2=null;
			return null;
		}
		else {

			
			t[g.a.getPos()[0]][g.a.getPos()[1]] = g2.a;
			t[g.b.getPos()[0]][g.b.getPos()[1]] = g2.b;
			t[g.c.getPos()[0]][g.c.getPos()[1]] = g2.c;
			
			g2.a.setPos(g.a.getPos()[0], g.a.getPos()[1]);
			g2.b.setPos(g.b.getPos()[0], g.b.getPos()[1]);
			g2.c.setPos(g.c.getPos()[0], g.c.getPos()[1]);
			
			Tile temp = t[p[0]][p[1]-1];
			Agent agent = new Agent();
			agent.setPos(p[0], p[1]-1);
			t[p[0]][p[1]-1] = agent;
			g2.agent = agent;
			t[p[0]][p[1]] = temp;
			if (temp instanceof Block) {
				
				temp.setPos(p[0], p[1]);
			}
		
			return g2;
		}
	}
	
	public Grid moveRight(Grid g) {
		

		
		Grid g2 = new Grid();
		Tile[][] t = g2.getGrid();
		int[] p = g.getAgentPosition();
		if (p[1] == 3) {
		
			//System.out.println("Cant move right");
			g2=null;
			return null;
		}
		else {

			
			t[g.a.getPos()[0]][g.a.getPos()[1]] = g2.a;
			t[g.b.getPos()[0]][g.b.getPos()[1]] = g2.b;
			t[g.c.getPos()[0]][g.c.getPos()[1]] = g2.c;
			
			g2.a.setPos(g.a.getPos()[0], g.a.getPos()[1]);
			g2.b.setPos(g.b.getPos()[0], g.b.getPos()[1]);
			g2.c.setPos(g.c.getPos()[0], g.c.getPos()[1]);
			
			Tile temp = t[p[0]][p[1]+1];
			Agent agent = new Agent();
			agent.setPos(p[0], p[1]+1);
			t[p[0]][p[1]+1] = agent;
			t[p[0]][p[1]] = temp;
			g2.agent = agent;
			if (temp instanceof Block) {
				
				temp.setPos(p[0], p[1]);
			}
		
			return g2;
		}
		
	}
	
	public Grid moveUp(Grid g) {
		

		
		Grid g2 = new Grid();
		Tile[][] t = g2.getGrid();
		int[] p = g.getAgentPosition();
		if (p[0] == 0) {
		
			//System.out.println("Cant move up");
			g2=null;
			return null;
		}
		else {

			
			t[g.a.getPos()[0]][g.a.getPos()[1]] = g2.a;
			t[g.b.getPos()[0]][g.b.getPos()[1]] = g2.b;
			t[g.c.getPos()[0]][g.c.getPos()[1]] = g2.c;
			
			g2.a.setPos(g.a.getPos()[0], g.a.getPos()[1]);
			g2.b.setPos(g.b.getPos()[0], g.b.getPos()[1]);
			g2.c.setPos(g.c.getPos()[0], g.c.getPos()[1]);
			
			Tile temp = t[p[0]-1][p[1]];
			Agent agent = new Agent();
			agent.setPos(p[0]-1, p[1]);
			t[p[0]-1][p[1]] = agent;
			t[p[0]][p[1]] = temp;
			g2.agent = agent;
			if (temp instanceof Block) {
				temp.setPos(p[0], p[1]);
			}
			

			
			return g2;
		}
		
	}
	
	public static Grid moveDown(Grid g) {
		

		
		Grid g2 = new Grid();
		Tile[][] t = g2.getGrid();
		int[] p = g.getAgentPosition();
		if (p[0] == 3) {
		
			//System.out.println("Cant move down");
			g2=null;
			return null;
		}
		else {

			
			t[g.a.getPos()[0]][g.a.getPos()[1]] = g2.a;
			t[g.b.getPos()[0]][g.b.getPos()[1]] = g2.b;
			t[g.c.getPos()[0]][g.c.getPos()[1]] = g2.c;
			
			g2.a.setPos(g.a.getPos()[0], g.a.getPos()[1]);
			g2.b.setPos(g.b.getPos()[0], g.b.getPos()[1]);
			g2.c.setPos(g.c.getPos()[0], g.c.getPos()[1]);
			
			Tile temp = t[p[0]+1][p[1]];
			Agent agent = new Agent();
			agent.setPos(p[0]+1, p[1]);
			t[p[0]+1][p[1]] = agent;
			t[p[0]][p[1]] = temp;
			g2.agent = agent;
			if (temp instanceof Block) {
				temp.setPos(p[0], p[1]);
			}
		
			return g2;
		}
		
	}
	
	public void expandNode(Node<Grid> n) {
		
		Grid g = n.getValue();
		
		if(this.moveUp(g)!= null) {
			n.addChild(this.moveUp(g));
		}
			
		if(this.moveLeft(g)!= null) {
			n.addChild(this.moveLeft(g));
		}
		
		
		if(Move.moveDown(g)!= null) {
			n.addChild(Move.moveDown(g));
		}
		
		if(this.moveRight(g)!= null) {
			n.addChild(this.moveRight(g));
		}
		
		
		
		
		
				
	}
	
	public void randomNodeExpand(Node<Grid> n) {
		
		Grid g = n.getValue();
		ArrayList<Grid> s = new ArrayList<Grid>();
		s.add(this.moveUp(g));
		s.add(Move.moveDown(g));
		s.add(this.moveLeft(g));
		s.add(this.moveRight(g));
		Collections.shuffle(s);
		for(Grid g1:s) {
			if(g1 != null) {
				n.addChild(g1);
			}
		}
		n.expanded = true;
	}
	
	public boolean isGoal(Node<Grid> n) {
		//n.getValue().displayGrid();
		Tile[][] g = n.getValue().getGrid();
		if(g[1][1]!= null && g[2][1]!= null && g[3][1]!= null){
		if(g[1][1].getName().equals("A") && g[2][1].getName().equals("B") && g[3][1].getName().equals("C")) {
			n.getValue().displayGrid();
			return true;
		}
		else {
			return false;
		}
		}
		else {
			return false;
		}
	}
	
	public int calculate(Grid g) {
		
		
		Tile[][] t = g.getGrid();
		int n = 0,n2 = 0,n3 = 0,x = 0,y = 0,z = 0;
		int[] pos = g.getAgentPosition();
		for (int i = 0; i < 4; i++) { 
		    for (int j = 0; j < 4; j++) { 
		        if (t[i][j] instanceof Block) { 
		        	
		        	if(t[i][j].name.equals("A")) {
		        		
		        		n= Math.abs(i-1)+ Math.abs(j-1);
		        		x =  (Math.abs(i-pos[0])+ Math.abs(j-pos[1]))  -1;
		        		if(x<0) {
		        			x = 0;
		        		}
		        		
		        	}
		        	else if(t[i][j].name.equals("B")) {
		        		
		        		n2= Math.abs(i-2)+ Math.abs(j-1);
		        		
		        		y =  (Math.abs(i-pos[0])+ Math.abs(j-pos[1]))  -1;
		        		if(y<0) {
		        			y = 0;
		        		}
		        		
		        	}
		        	else if(t[i][j].name.equals("C")) {
		        		n3= Math.abs(i-3)+ Math.abs(j-1);
		        		
		        		z =  (Math.abs(i-pos[0])+ Math.abs(j-pos[1]))  -1;
		        		if(z<0) {
		        			z = 0;
		        		}
		        		
		        	}
		        }
		            
		            
		        }
		    }
		//int a = Math.max(n, n2);
		int p = Math.min(x,y);
		int q = Math.min(z, p);
		
		return n+n2+n3+q;
	}
	
}