
public class LastUpdatedVisitor implements Visitor {
	
	private String lastUpdated;
	private Long latest;
	
	public LastUpdatedVisitor() {
		lastUpdated = "";
		latest = Long.MIN_VALUE;
	}

	public void visit(User u) {
		if(u.getUpdateTime() > latest){
			lastUpdated = u.getID();
			latest = u.getUpdateTime();
		}
	}

	public void visit(Group g) {
		for(Component c: g.getChildren()){
			c.acceptVisitor(this);
		}
	}

	public String getLast(){
		return lastUpdated;
	}
	
}
