
public class CountUsersVisitor implements Visitor {

	private int count;
	
	public CountUsersVisitor(){
		count = 0;
	}
	
	public void visit(User u) {
		count += 1;
	}

	public void visit(Group g) {
		for(Component c: g.getChildren()){
			c.acceptVisitor(this);
		}
	}
	
	public int getCount(){
		return count;
	}

}
