import javax.swing.tree.TreeNode;

public interface Component extends TreeNode {
	//composite pattern base also visitorElement
	public String getID();
	
	public void addMember(String groupid, Component mem);
	
	public void acceptVisitor(Visitor v);

	public void setParent(Component par);
	
	public void follows(Observer obs, String id);

	public User getUser(String id);
}
