
public class CountGroupsVisitor implements Visitor {

	private int count;
	
	public CountGroupsVisitor(){
		count = 0;
	}
	
	public void visit(User u) {
		
	}

	public void visit(Group g) {
		count += 1;
		for(Component c: g.getChildren()){
			c.acceptVisitor(this);
		}
	}
	
	public int getCount(){
		return count;
	}

}
