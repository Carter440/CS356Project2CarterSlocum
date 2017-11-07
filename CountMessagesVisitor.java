public class CountMessagesVisitor implements Visitor {
	private int count;
	public CountMessagesVisitor(){
		count = 0;
	}

	public void visit(User u) {
		for(String [] s: u.getMessages()){
			if(u.getID().equals(s[0])){
				count += 1;
			}
		}
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
