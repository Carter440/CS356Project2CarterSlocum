import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class User extends Subject implements Component, Observer {
	private String ID;
	private List<String> following = new LinkedList<>();
	private List<String []> messages = new LinkedList<>();
	private Component parent;
	private Component ROOT;
	private String newMessage;
	public User(String id, Component root){
		ID = id;
		ROOT = root;
		following.add(id);
		this.follows(this, id);
	}
	public void setParent(Component par){
		parent = par;
	}
	public void follow(String id) {
		following.add(id);
		ROOT.follows(this, id);
	}
	public void follows(Observer obs, String id){
		if(id.equals(ID)){
			attach(obs);
		}
	}
	public void update(Subject subject) {
		if (subject instanceof User){
			String [] mess = {((User) subject).getID(),((User) subject).getNewMessage()};
			messages.add(mess);
		}
	}
	public List<String[]> getMessages(){
		return messages;
	}
	public String getID() {
		return ID;
	}
	public String toString(){
		return ID;
	}
	public void addMember(String groupid, Component mem) {
			
	}
	public void acceptVisitor(Visitor v){
		v.visit(this);
	}
	public String getNewMessage(){
		return newMessage;
	}
	public void Tweet(String tweet){
		newMessage = tweet;
		notifyObservers();
	}
	public Enumeration<Component> children() {
		return null;
	}
	public boolean getAllowsChildren() {
		return false;
	}
	public TreeNode getChildAt(int arg0) {
		return null;
	}
	public int getChildCount() {
		return 0;
	}
	public int getIndex(TreeNode arg0) {
		return -1;
	}
	public TreeNode getParent() {
		return parent;
	}
	public boolean isLeaf() {
		return true;
	}
	public User getUser(String id) {
		if(id.equals(ID)) return this;
		return null;
	}
	public List<String> getFollowing(){
		return following;
	}

}
