import java.util.HashSet;
import java.util.Set;


public class IsUniqueVisitor implements Visitor {
	
	private Set<String> IDS;
	private boolean unique;
	
	public IsUniqueVisitor() {
		IDS = new HashSet<String>();
		unique = true;
	}

	public void visit(User u) {
		System.out.print("wut");
		if(IDS.contains(u.getID())){
			unique = false;
		}else{
			IDS.add(u.getID());
		}
	}

	public void visit(Group g) {
		if(IDS.contains(g.getID())){
			unique = false;
		}else{
			IDS.add(g.getID());
		}
		for(Component c: g.getChildren()){
			c.acceptVisitor(this);
		}
	}
	
	public boolean getUnique(){
		return unique;
	}

}
