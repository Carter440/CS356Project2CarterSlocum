import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Group implements Component {

	private String ID;
	private Component parent = null;
	private List<Component> members = new LinkedList<>();
	public Group(String id) {
		ID = id;
	}
	public void setParent(Component par){
		parent = par;
	}
	public void follows(Observer obs, String id){
		for(Component m: members) {
				m.follows(obs, id);
		}
	}
	public List<Component> getChildren(){
		return members;
	}
	public void addMember(String parentid,Component mem) {
		if(parentid.equals(ID)) {
		mem.setParent((Component) this);
		members.add(mem);
		}else {
			for(Component m: members) {
				m.addMember(parentid, mem);
			}
		}
	}
	public String getID() {
		return ID;
	}
	public String toString(){
		return ID;
	}
	public void acceptVisitor(Visitor v){
		v.visit(this);
	}
	public Enumeration<Component> children() {
		return (Enumeration<Component>)members;
	}
	public boolean getAllowsChildren() {
		return true;
	}
	public TreeNode getChildAt(int arg0) {
		return members.get(arg0);
	}
	public int getChildCount() {
		return members.size();
	}
	public int getIndex(TreeNode arg0) {
		return members.indexOf(arg0);
	}
	public TreeNode getParent() {
		return parent;
	}
	public boolean isLeaf() {
		return false;
	}
	public User getUser(String id){
		for(Component m: members) {
			User use = m.getUser(id);
			if(use != null) return use;
		}
		return null;
	}
}
