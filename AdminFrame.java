import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;


public class AdminFrame {
	public AdminFrame(){
		AdminControl ac = AdminControl.createView();
		JTree t = new JTree(ac.getRoot());
		JFrame mast = new JFrame();
		JPanel tree = new JPanel();
		JPanel butts = new JPanel();
		JPanel addug = new JPanel();
		JPanel opps = new JPanel();
		JPanel uview = new JPanel();
		t.setEditable(true);
		tree.add(t);
		JTextField uid = new JTextField("User ID");
		JTextField gid = new JTextField("Group ID");
		JButton addu = new JButton("Add User");
		addu.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ac.addUser(gid.getText(),uid.getText());
		    	t.updateUI();
		    }  
		}); 
		JButton addg = new JButton("Add Group");
		addg.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	ac.addGroup(gid.getText(),uid.getText());
		    	t.updateUI();
		    }
		});
		addug.add(uid);
		addug.add(addu);
		addug.add(gid);
		addug.add(addg);
		JButton uv = new JButton("Open User View");
		uv.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	User ues = ac.getRoot().getUser(uid.getText());
		    	if(ues != null) {UserFrame us = new UserFrame(ues);}
		    }  
		}); 
		uview.add(uv);
		JButton countu = new JButton("Count Users");
		countu.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	CountUsersVisitor v = new CountUsersVisitor();
		    	ac.getRoot().acceptVisitor(v);
		    	JFrame f = new JFrame();
		    	JLabel l = new JLabel(Integer.toString(v.getCount()));
		    	f.add(l);
		    	f.setSize(100,100);
		    	f.setVisible(true);
		    }  
		}); 
		JButton countg = new JButton("Count Groups");
		countg.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	CountGroupsVisitor v = new CountGroupsVisitor();
		    	ac.getRoot().acceptVisitor(v);
		    	JFrame f = new JFrame();
		    	JLabel l = new JLabel(Integer.toString(v.getCount()));
		    	f.add(l);
		    	f.setSize(100,100);
		    	f.setVisible(true);
		    }  
		}); 
		JButton countm = new JButton("Count messages");
		countm.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	CountMessagesVisitor v = new CountMessagesVisitor();
		    	ac.getRoot().acceptVisitor(v);
		    	JFrame f = new JFrame();
		    	JLabel l = new JLabel(Integer.toString(v.getCount()));
		    	f.add(l);
		    	f.setSize(100,100);
		    	f.setVisible(true);
		    }  
		}); 
		JButton countp = new JButton("Count positive");
		countp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	PercentPositiveMessages v = new PercentPositiveMessages();
		    	ac.getRoot().acceptVisitor(v);
		    	JFrame f = new JFrame();
		    	JLabel l = new JLabel(Float.toString(v.getCount()));
		    	f.add(l);
		    	f.setSize(100,100);
		    	f.setVisible(true);
		    }  
		});
		tree.setLayout(new GridLayout(1,1));
		opps.add(countu); opps.add(countg); opps.add(countm); opps.add(countp);
		addug.setLayout(new GridLayout(2,2));
		opps.setLayout(new GridLayout(2,2));
		uview.setLayout(new GridLayout(1,1));
		butts.add(addug); butts.add(uview); butts.add(opps);
		butts.setLayout(new GridLayout(3,1));
		mast.add(tree); mast.add(butts);
		mast.setSize(400,500);
		mast.setLayout(new GridLayout(1,2));
		mast.setVisible(true);
	}
}
