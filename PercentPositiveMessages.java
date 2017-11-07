public class PercentPositiveMessages implements Visitor {
	private int count;
	private int positive;
	public PercentPositiveMessages(){
		count = 0;
		positive = 0;
	}

	public void visit(User u) {
		for(String [] s: u.getMessages()){
			if(u.getID().equals(s[0])){
				count += 1;
				if(s[1].length() > 10){
					positive += 1;
				}
			}
		}
	}

	public void visit(Group g) {
		for(Component c: g.getChildren()){
			c.acceptVisitor(this);
		}
	}

	public float getCount(){
		if(count == 0) return 0.0f;
		return positive/count;
	}
}