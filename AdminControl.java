import javax.swing.tree.DefaultTreeModel;


public class AdminControl extends DefaultTreeModel{
	//singleton pattern
	private static Group Root = new Group("Root");
	private AdminControl() {super(Root);}
	private static AdminControl admin = new AdminControl();
	public static AdminControl createView(){
		return admin;
	}
	
	public void addUser(String parentid, String id) {
		Root.addMember(parentid, new User(id,Root));
	}
	
	public void addGroup(String parentid, String id) {
		Root.addMember(parentid, new Group(id));
	}
	
	public Group getRoot(){
		return Root;
	}
	
}
