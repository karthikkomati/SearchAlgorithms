import java.util.LinkedList;
import java.util.List;

public class Node<T> {
	
	
	public T value;
	public Node<T> parent;
	public List<Node<T>> children;
	public boolean expanded;
	
	public Node(T value) {
		
		this.value = value;
		this.parent = null;
		this.children = new LinkedList<Node<T>>();
		this.expanded = false;
	}

	public void addChild(T value) {
		Node<T> node = new Node<T>(value);
		node.setParent(this);
		this.children.add(node);
		
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public int getLevel() {
		if (this.parent == null)
			return 0;
		else
			return parent.getLevel() + 1;
	}
	
	public boolean isExpanded() {
		
		return this.expanded;
	}
	
	public T getValue() {
		
		return this.value;
	}
	
	public List<Node<T>> getChildren(){
		
		return children;
		
		
	}
	

}
