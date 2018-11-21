package OCM.Miscellaneous;

public class Node<T> {
	protected Node<T> parent;
	protected T current;
	
	public Node() {
		parent = null;
		current = null;
	}
	
	public Node(Node<T> parent, T current) {
		this.parent = parent;
		this.current = current;
	}
	
	public Node<T> getParent() {
		return (Node<T>) parent;
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public T getCurrent() {
		return current;
	}
	
	public void setCurrent(T current) {
		this.current = current;
	}
	
	private static String getTree(String tree, Node<?> p) {
		if (p != null) {
			return getTree(
						"/".concat((String)p.getCurrent()).concat(tree),
						p.parent
					);
		}
		else {
			return tree;
		}
	}
	
	public static String getTree(Node<?> p) {
		 return getTree("", p);
	}
	
	public String toString() {
		
		return String.format("%s/%s", this.getParent().getCurrent(), current);
	}
	
	public static void main(String[] args) {
		Node<String> Barry = new Node<String>(null, "Barry");
		Node<String> Claire = new Node<String>(Barry, "Claire");
		Node<String> Harry = new Node<String>(Claire, "Harry");
		Node<String> Alex = new Node<String>(Harry, "Alex");
		Node<String> Megan = new Node<String>(Claire, "Megan");
		
		Megan.setParent(Claire);

		System.out.println(getTree(Harry));
		System.out.println(getTree(Alex));
		System.out.println(getTree(Megan));
	}
}
