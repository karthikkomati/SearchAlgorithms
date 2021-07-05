
public class Main {

	public static void main(String[] args) {
		
		
		
		Grid g = new Grid("root");
		
		Node<Grid> root = new Node<Grid>(g);
		
		Search search = new Search(root);
		

		
		Node<Grid> g2 = search.search4();
		
		System.out.println(g2.getLevel() + "-----------------------------------------  ");
		while(g2 != null) {
			
			g2.getValue().displayGrid();
			g2=g2.parent;
			
			
			
		}

		
	}

}
