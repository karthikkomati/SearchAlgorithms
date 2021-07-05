import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Search {
	
	Move m = new Move();
	
	public Node<Grid> root;
	public Node<Grid> parent;
	public Node<Grid> current;
	ArrayList<Node<Grid>> a = new ArrayList<Node<Grid>>();
	public Search(Node<Grid> node) {
		
		this.root = node;
		this.current = root;
		//m.randomNodeExpand(current);
		//current = root.children.get(0);
		//search4();
	}
	
	public void search() {
		
		
		
		while(m.isGoal(current) != true) {
			//Node<Grid> temp;
			
			parent = current;
			m.randomNodeExpand(current);
			current = current.children.get(0);
			a.add(parent);
		} 
		
		System.out.println(a.size());
	}
	
	public Node<Grid> search2() {
		Node<Grid> e1 = null;
		Stack<Node<Grid>> s = new Stack<Node<Grid>>();
		s.add(root);
		int i = 0;
		int j = 1;
		while(!s.empty()) {
			
			Node<Grid> e = s.pop();
			
			if(m.isGoal(e) != true) {
				m.randomNodeExpand(e);
				s.addAll(e.getChildren());
				System.out.println(i);
				j = j+e.getChildren().size();
				i++;
				
			}
			else {
				
				e1= e;
				System.out.println(j);
				System.out.println("Goal reached");
				break;
				}
			
			
		}
		
		return e1;
	}
	
	public Node<Grid> search3() {
		
		Node<Grid> x = null;
		int level = 1;
		boolean found  = false;
		//int level = 14;
		
		
		while(!found) {
		
		Stack<Node<Grid>> s = new Stack<Node<Grid>>();
		s.add(root);
		int i = 0;
		int j = 1;
		int k = 0;
	
		
		while(!s.empty()) {
			Node<Grid> e = s.pop();
			if(e.getLevel()<level) {
			
			
			
			if(m.isGoal(e) != true) {
				m.expandNode(e);
				s.addAll(e.getChildren());
				//System.out.println(i);
				
				j = j+e.getChildren().size();
				i++;
				if(s.size()>k) {
					k = s.size();
				}
			}
			else {
				
				//System.out.println("Expanded:"+ i + ", Generated:"+ j + ", in memory:"+ k);

				//System.out.println(j);
				System.out.println("Goal reached at level"+e.getLevel());
				//System.out.println(k);
				found = true;
				x =e;
				break;
				}
			}
			else if(e.getLevel()==level) {
				if(m.isGoal(e) == true) {
					//System.out.println("Expanded:"+ i + ", Generated:"+ j + ", in memory:"+ k);
					//System.out.println(j);
					System.out.println("Goal reached at level "+e.getLevel());
					//System.out.println(k);
					found = true;
					x = e;
					break;
				}
				else {
					
				}
				
			}
			
			//Test
			else if(s.size()>=65){
				System.out.println("Too many items");
				break;
				
			}
			
			//Test
			else {
				//System.out.println("lever too low");
				//break;
			}
			
			
		}
		level ++;
	}
		
		return x;
		
	}
	
	
	public Node<Grid> search4() {
		
		Comparator<Node<Grid>> distance = new Comparator<Node<Grid>>() {
            @Override
            public int compare(Node<Grid> n1, Node<Grid> n2) {
            	
            	
                return ((m.calculate(n1.getValue())+n1.getLevel()) - (m.calculate(n2.getValue())+n2.getLevel()));
            }
        };

		PriorityQueue<Node<Grid>> a = new PriorityQueue<>(distance);
		a.add(root);
		
		int i =0;
		int j = 1;
		Node<Grid> x = null;
		while(!a.isEmpty()) {
			
			Node<Grid> e = a.poll();
			
			if(!m.isGoal(e)) {
				m.expandNode(e);
			a.addAll(e.getChildren());
			System.out.println(i);
			i++;
			j = j+e.getChildren().size();
			}
			else {
				System.out.println(j);
				System.out.println("Goal reached");
				x = e;
				break;
				}
		}
		return x;
	}
	
	public Node<Grid> search5() {
		
		Queue<Node<Grid>> q =new LinkedList<Node<Grid>>();
		q.add(root);
		int i = 0;
		int j = 1;
		Node<Grid> x = null;
		while(!q.isEmpty()) {
			Node<Grid> e = q.poll();
			
			if(!m.isGoal(e)) {
				m.expandNode(e);
				e.getValue().displayGrid();
			q.addAll(e.getChildren());
			//System.out.println(i);
			System.out.println(e.getLevel() );
			
			j = j+e.getChildren().size();
			i++;
			}
			else {
				
				x = e;
				//System.out.println(j);
				System.out.println(e.getLevel());
				System.out.println("Goal reached");
				break;
				}
			
			
		}
		
		return x;
		
		
	}
}
